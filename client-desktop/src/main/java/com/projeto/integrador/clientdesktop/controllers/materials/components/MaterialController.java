package com.projeto.integrador.clientdesktop.controllers.materials.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.materials.UpdateMaterialController;
import com.projeto.integrador.clientdesktop.models.Material;
import com.projeto.integrador.clientdesktop.resources.MaterialResource;
import com.projeto.integrador.clientdesktop.utils.NumberFormatter;
import com.projeto.integrador.clientdesktop.views.materials.ListMaterialsFxmlView;
import com.projeto.integrador.clientdesktop.views.materials.UpdateMaterialFxmlView;

import javafx.event.ActionEvent;
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
public class MaterialController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private MaterialResource materialResource;

  private Material material;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public Material getMaterial() {
    return material;
  }

  public void setMaterial(Material material) {
    this.material = material;

    fillContent();
  }

  private void fillContent() {
    nameLabel.setText(material.getName());
    thermalConductivityIndexLabel.setText(NumberFormatter.localizeFromDouble(material.getThermalConductivityIndex()));
    inactiveLabel.setVisible(!material.isActive());
  }

  @FXML
  private void goToUpdate(ActionEvent event) throws IOException {
    stageManager.switchScene(new UpdateMaterialFxmlView());
    UpdateMaterialController controller = stageManager.getLoader().getController();
    controller.setMaterial(material);
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
    materialResource.delete(material);

    stageManager.switchScene(new ListMaterialsFxmlView());
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label thermalConductivityIndexLabel;

  @FXML
  private Label inactiveLabel;

}
