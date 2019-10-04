package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.ComponentMaterial;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.utils.NumberFormatter;

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

  private Project project;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
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
    widthLabel.setText(NumberFormatter.localizeFromDouble(getComponentMaterial().getWidth()));
    thermalConductitityIndexLabel.setText(NumberFormatter.localizeFromDouble(getComponentMaterial().getThermalConductitityIndex()));
    resistanceLabel.setText(NumberFormatter.localizeFromDouble(getComponentMaterial().getResistance()));
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
