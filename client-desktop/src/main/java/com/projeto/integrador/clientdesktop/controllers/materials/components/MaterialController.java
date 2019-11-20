package com.projeto.integrador.clientdesktop.controllers.materials.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.config.ToastHelper;
import com.projeto.integrador.clientdesktop.controllers.materials.UpdateMaterialController;
import com.projeto.integrador.clientdesktop.models.Material;
import com.projeto.integrador.clientdesktop.resources.MaterialResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.materials.ListMaterialsFxmlView;
import com.projeto.integrador.clientdesktop.views.materials.UpdateMaterialFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;

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
    thermalConductivityIndexLabel.setText(NumberParser.localizeFromDouble(material.getThermalConductivityIndex()));
    solarFactorLabel.setText(NumberParser.localizeFromDouble(material.getSolarFactor()));
    resistanceLabel.setText(NumberParser.localizeFromDouble(material.getResistance()));
    inactiveLabel.setVisible(!material.isActive());

    thermalConductivityIndexWrapper.setVisible(false);
    solarFactorWrapper.setVisible(false);
    resistanceWrapper.setVisible(false);

    if ("translucent".equals(material.getKind())) {
      thermalConductivityIndexWrapper.setVisible(true);
      solarFactorWrapper.setVisible(true);
    } else if ("air".equals(material.getKind())) {
      resistanceWrapper.setVisible(true);
    } else {
      thermalConductivityIndexWrapper.setVisible(true);
    }
  }

  @FXML
  private void goToUpdate(ActionEvent event) throws IOException {
    stageManager.switchScene(new UpdateMaterialFxmlView());
    UpdateMaterialController controller = stageManager.getLoader().getController();
    controller.setMaterial(material);
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
    Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja excluir o material '" + material.getName() + "' ?", ButtonType.YES, ButtonType.NO);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      materialResource.delete(material);

      stageManager.switchScene(new ListMaterialsFxmlView());

      ToastHelper.success(String.format("Material \"%s\" foi removida.", material.getName()));
    }
  }

  @FXML
  private Label nameLabel;

  @FXML
  private HBox thermalConductivityIndexWrapper;

  @FXML
  private Label thermalConductivityIndexLabel;

  @FXML
  private HBox solarFactorWrapper;

  @FXML
  private Label solarFactorLabel;

  @FXML
  private HBox resistanceWrapper;

  @FXML
  private Label resistanceLabel;

  @FXML
  private Label inactiveLabel;

}
