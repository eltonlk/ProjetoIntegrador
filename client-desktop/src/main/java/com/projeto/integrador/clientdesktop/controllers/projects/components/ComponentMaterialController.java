package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.config.ToastHelper;
import com.projeto.integrador.clientdesktop.controllers.projects.ShowProjectController;
import com.projeto.integrador.clientdesktop.controllers.projects.modals.FormComponentMaterialController;
import com.projeto.integrador.clientdesktop.models.ComponentMaterial;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.resources.ComponentMaterialResource;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ComponentMaterialController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ComponentMaterialResource componentMaterialResource;

  @Autowired
  private ProjectResource projectResource;

  private ComponentMaterial componentMaterial;

  private Project project;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  @FXML
  private void update(ActionEvent event) throws IOException {
    Stage modal = stageManager.buildModal("/fxml/projects/modals/FormComponentMaterial.fxml");

    FormComponentMaterialController controller = stageManager.getLoader().getController();
    controller.setProject(getProject());
    controller.setComponentMaterial(componentMaterial);

    modal.show();
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
    Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja excluir o material '" + componentMaterial.getMaterial().getName() + "' ?", ButtonType.YES, ButtonType.NO);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      componentMaterialResource.delete(componentMaterial);

      stageManager.switchScene(new ShowProjectFxmlView());
      ShowProjectController controller = stageManager.getLoader().getController();
      Project project = projectResource.refresh(getProject());
      controller.setProject(project);

      ToastHelper.success(String.format("Material \"%s\" foi removido.", componentMaterial.getMaterial().getName()));
    }
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public ComponentMaterial getComponentMaterial() {
    return componentMaterial;
  }

  public void setComponentMaterial(ComponentMaterial componentMaterial) {
    this.componentMaterial = componentMaterial;

    fillContent();
  }

  private void fillContent() {
    materialLabel.setText(getComponentMaterial().getMaterial().getName());
    widthLabel.setText(NumberParser.localizeFromDouble(getComponentMaterial().getWidth()) + " m");
    resistanceLabel.setText(NumberParser.localizeFromDouble(getComponentMaterial().getResistance(), "#.###"));
  }

  @FXML
  private Label materialLabel;

  @FXML
  private Label widthLabel;

  @FXML
  private Label resistanceLabel;

}
