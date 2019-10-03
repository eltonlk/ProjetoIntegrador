package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.ComponentMaterial;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

  private ComponentMaterial componentMaterial;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public ComponentMaterial getComponentMaterial() {
    return componentMaterial;
  }

  public void setComponentMaterial(ComponentMaterial componentMaterial) {
    this.componentMaterial = componentMaterial;

    fillContent();
  }

  private void fillContent() {
    // nameLabel.setText(face.getName());
    // heatFlowLabel.setText(face.getHeatFlow());
  }

  @FXML
  private Label materialLabel;

  @FXML
  private Label widthLabel;

  @FXML
  private Label thermalConductitityIndexLabel;

  @FXML
  private Label resistanceLabel;

}
