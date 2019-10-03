package com.projeto.integrador.clientdesktop.controllers.solarradiations;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.SolarRadiation;
import com.projeto.integrador.clientdesktop.resources.SolarRadiationResource;
import com.projeto.integrador.clientdesktop.utils.NumberFormatter;
import com.projeto.integrador.clientdesktop.views.solarradiations.ListSolarRadiationsFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class CreateSolarRadiationController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private SolarRadiationResource solarRadiationResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // TODO:
    indexInput.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\d{0,10}")) {
        indexInput.setText(oldValue);
      }
    });
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    SolarRadiation solarRadiation = new SolarRadiation();
    solarRadiation.setName(nameInput.getText());
    solarRadiation.setIndex(NumberFormatter.parseToDouble(indexInput.getText()));

    solarRadiationResource.create(solarRadiation);

		stageManager.switchScene(new ListSolarRadiationsFxmlView());
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListSolarRadiationsFxmlView());
  }

  @FXML
  private Button submitButton;

  @FXML
  private TextField nameInput;

  @FXML
  private TextField indexInput;

}
