package com.projeto.integrador.clientdesktop.controllers.projects.modals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.projects.ShowProjectController;
import com.projeto.integrador.clientdesktop.models.Component;
import com.projeto.integrador.clientdesktop.models.ComponentMaterial;
import com.projeto.integrador.clientdesktop.models.Material;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.resources.ComponentMaterialResource;
import com.projeto.integrador.clientdesktop.resources.MaterialResource;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CreateComponentMaterialController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ComponentMaterialResource componentMaterialResource;

  @Autowired
  private ProjectResource projectResource;

  @Autowired
  private MaterialResource materialResource;

  private ObservableList<Material> materialsOptions;

  private Project project;

  private Component component;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    materialsOptions = FXCollections.observableArrayList(materialResource.getAll());

    materialComboBox.setItems(materialsOptions);

    materialComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      thermalConductivityIndexInput.setText(NumberParser.localizeFromDouble(newValue.getThermalConductivityIndex()));
    });
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public Component getComponent() {
    return component;
  }

  public void setComponent(Component component) {
    this.component = component;
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    ComponentMaterial componentMaterial = new ComponentMaterial();
    componentMaterial.setComponent(getComponent());
    componentMaterial.setMaterial(materialComboBox.getSelectionModel().getSelectedItem());
    componentMaterial.setWidth(NumberParser.parseToDouble(widthInput.getText()));
    componentMaterial.setThermalConductivityIndex(NumberParser.parseToDouble(thermalConductivityIndexInput.getText()));

    componentMaterialResource.create(componentMaterial);

    Project project = projectResource.refresh(getProject());

    stageManager.switchScene(new ShowProjectFxmlView());
    ShowProjectController controller = stageManager.getLoader().getController();
    controller.setProject(project);

    Node  source = (Node) event.getSource();
    Stage stage  = (Stage) source.getScene().getWindow();

    stage.close();
  }

  @FXML
  private ComboBox<Material> materialComboBox;

  @FXML
  private TextField widthInput;

  @FXML
  private TextField thermalConductivityIndexInput;

}
