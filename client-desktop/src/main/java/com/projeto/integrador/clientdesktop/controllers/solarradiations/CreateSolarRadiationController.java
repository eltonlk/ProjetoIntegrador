package com.projeto.integrador.clientdesktop.controllers.solarradiations;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.SolarRadiation;
import com.projeto.integrador.clientdesktop.resources.SolarRadiationResource;
import com.projeto.integrador.clientdesktop.utils.Mask;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
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
    TextField[] indexTextFieldList = {northIndexInput, southIndexInput, eastIndexInput, westIndexInput,
      northEastIndexInput, northWestIndexInput, southEastIndexInput, southWestIndexInput, perpendicularIndexInput};

    for (TextField indexTextField : indexTextFieldList) {
      Mask.addTo(indexTextField, "\\d{0,5}");
    }
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    SolarRadiation solarRadiation = new SolarRadiation();
    solarRadiation.setName(nameInput.getText());
    solarRadiation.setNorthIndex(NumberParser.parseToInt(northIndexInput.getText()));
    solarRadiation.setSouthIndex(NumberParser.parseToInt(southIndexInput.getText()));
    solarRadiation.setEastIndex(NumberParser.parseToInt(eastIndexInput.getText()));
    solarRadiation.setWestIndex(NumberParser.parseToInt(westIndexInput.getText()));
    solarRadiation.setNorthEastIndex(NumberParser.parseToInt(northEastIndexInput.getText()));
    solarRadiation.setNorthWestIndex(NumberParser.parseToInt(northWestIndexInput.getText()));
    solarRadiation.setSouthEastIndex(NumberParser.parseToInt(southEastIndexInput.getText()));
    solarRadiation.setSouthWestIndex(NumberParser.parseToInt(southWestIndexInput.getText()));
    solarRadiation.setPerpendicularIndex(NumberParser.parseToInt(perpendicularIndexInput.getText()));

    solarRadiationResource.create(solarRadiation);

		stageManager.switchScene(new ListSolarRadiationsFxmlView());
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListSolarRadiationsFxmlView());
  }

  @FXML
  private TextField nameInput;

  @FXML
  private TextField northIndexInput;

  @FXML
  private TextField southIndexInput;

  @FXML
  private TextField eastIndexInput;

  @FXML
  private TextField westIndexInput;

  @FXML
  private TextField northEastIndexInput;

  @FXML
  private TextField northWestIndexInput;

  @FXML
  private TextField southEastIndexInput;

  @FXML
  private TextField southWestIndexInput;

  @FXML
  private TextField perpendicularIndexInput;

}
