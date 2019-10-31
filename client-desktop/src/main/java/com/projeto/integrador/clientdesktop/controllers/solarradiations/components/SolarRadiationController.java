package com.projeto.integrador.clientdesktop.controllers.solarradiations.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.solarradiations.UpdateSolarRadiationController;
import com.projeto.integrador.clientdesktop.models.SolarRadiation;
import com.projeto.integrador.clientdesktop.resources.SolarRadiationResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.solarradiations.ListSolarRadiationsFxmlView;
import com.projeto.integrador.clientdesktop.views.solarradiations.UpdateSolarRadiationFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SolarRadiationController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private SolarRadiationResource solarRadiationResource;

  private SolarRadiation solarRadiation;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public SolarRadiation getSolarRadiation() {
    return solarRadiation;
  }

  public void setSolarRadiation(SolarRadiation solarRadiation) {
    this.solarRadiation = solarRadiation;

    fillContent();
  }

  private void fillContent() {
    nameLabel.setText(solarRadiation.getName());
    northLabel.setText(NumberParser.localizeFromInt(solarRadiation.getNorthIndex()));
    southLabel.setText(NumberParser.localizeFromInt(solarRadiation.getSouthIndex()));
    eastLabel.setText(NumberParser.localizeFromInt(solarRadiation.getEastIndex()));
    westLabel.setText(NumberParser.localizeFromInt(solarRadiation.getWestIndex()));
    northEastLabel.setText(NumberParser.localizeFromInt(solarRadiation.getNorthEastIndex()));
    northWestLabel.setText(NumberParser.localizeFromInt(solarRadiation.getNorthWestIndex()));
    southEastLabel.setText(NumberParser.localizeFromInt(solarRadiation.getSouthEastIndex()));
    southWestLabel.setText(NumberParser.localizeFromInt(solarRadiation.getSouthWestIndex()));
    perpendicularLabel.setText(NumberParser.localizeFromInt(solarRadiation.getPerpendicularIndex()));
  }

  @FXML
  private void goToUpdate(ActionEvent event) throws IOException {
    stageManager.switchScene(new UpdateSolarRadiationFxmlView());
    UpdateSolarRadiationController controller = stageManager.getLoader().getController();
    controller.setSolarRadiation(solarRadiation);
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
    Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja excluir a radiação solar '" + solarRadiation.getName() + "' ?", ButtonType.YES, ButtonType.NO);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      solarRadiationResource.delete(solarRadiation);

      stageManager.switchScene(new ListSolarRadiationsFxmlView());
    }
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label northLabel;

  @FXML
  private Label southLabel;

  @FXML
  private Label eastLabel;

  @FXML
  private Label westLabel;

  @FXML
  private Label northEastLabel;

  @FXML
  private Label northWestLabel;

  @FXML
  private Label southEastLabel;

  @FXML
  private Label southWestLabel;

  @FXML
  private Label perpendicularLabel;

}
