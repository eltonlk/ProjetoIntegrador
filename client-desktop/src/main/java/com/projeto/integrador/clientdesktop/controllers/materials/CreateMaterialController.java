package com.projeto.integrador.clientdesktop.controllers.materials;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Material;
import com.projeto.integrador.clientdesktop.resources.MaterialResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.materials.ListMaterialsFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class CreateMaterialController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private MaterialResource materialResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    activeCheckBox.setSelected(true);

    thermalConductivityIndexInput.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\d{0,5}([\\,]\\d{0,5})?")) {
        thermalConductivityIndexInput.setText(oldValue);
      }
    });
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    Material material = new Material();
    material.setName(nameInput.getText());
    material.setThermalConductivityIndex(NumberParser.parseToDouble(thermalConductivityIndexInput.getText()));
    material.setActive(activeCheckBox.isSelected());

    materialResource.create(material);

		stageManager.switchScene(new ListMaterialsFxmlView());
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListMaterialsFxmlView());
  }

  @FXML
  private Button submitButton;

  @FXML
  private TextField nameInput;

  @FXML
  private TextField thermalConductivityIndexInput;

  @FXML
  private CheckBox activeCheckBox;

}
