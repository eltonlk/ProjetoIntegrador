package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.projects.modals.CreateComponentMaterialController;
import com.projeto.integrador.clientdesktop.models.Component;
import com.projeto.integrador.clientdesktop.models.ComponentMaterial;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.utils.NumberParser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ComponentController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  private Component component;

  private Project project;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public Component getComponent() {
    return component;
  }

  public void setComponent(Component component) {
    this.component = component;

    fillContent();
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  private void fillContent() {
    nameLabel.setText(component.getName());
    areaLabel.setText(NumberParser.localizeFromDouble(component.getArea()));
    colorLabel.setText(component.getColor().getName());
    heatFlowLabel.setText(NumberParser.localizeFromDouble(component.getHeatFlow()));

    if (getComponent().getComponentMaterials() != null) {
      for (ComponentMaterial componentMaterial : getComponent().getComponentMaterials()) {
        try {
          FXMLLoader loader = stageManager.getLoaderComponent("/fxml/projects/components/ComponentMaterial.fxml");

          componentMaterialsList.getChildren().add(loader.load());

          ComponentMaterialController controller = loader.getController();
          controller.setProject(getProject());
          controller.setComponentMaterial(componentMaterial);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @FXML
  private void createComponentMaterial(ActionEvent event) throws IOException {
    Stage modal = stageManager.buildModal("/fxml/projects/modals/CreateComponentMaterial.fxml");

    CreateComponentMaterialController controller = stageManager.getLoader().getController();

    controller.setProject(getProject());
    controller.setComponent(getComponent());

    modal.show();
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label areaLabel;

  @FXML
  private Label colorLabel;

  @FXML
  private Label heatFlowLabel;

  @FXML
  private Pane componentMaterialsList;

}
