package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Component;
import com.projeto.integrador.clientdesktop.models.ComponentMaterial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

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

  private void fillContent() {
    // nameLabel.setText(component.getName());
    // areaLabel.setText(component.getArea());
    // heatFlowLabel.setText(component.getHeatFlow());
  }

  @FXML
  private void createComponentMaterial(ActionEvent event) throws IOException {
    ComponentMaterial componentMaterial = new ComponentMaterial();

    FXMLLoader loader = stageManager.getLoaderComponent("/fxml/projects/components/ComponentMaterial.fxml");

    componentMaterialsList.getChildren().add(loader.load());

    ComponentMaterialController controller = loader.getController();
    controller.setComponentMaterial(componentMaterial);
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label areaLabel;

  @FXML
  private Label heatFlowLabel;

  @FXML
  private Pane componentMaterialsList;

}
