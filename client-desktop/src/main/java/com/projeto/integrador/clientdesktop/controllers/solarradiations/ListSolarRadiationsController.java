package com.projeto.integrador.clientdesktop.controllers.solarradiations;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.solarradiations.components.SolarRadiationController;
import com.projeto.integrador.clientdesktop.models.SolarRadiation;
import com.projeto.integrador.clientdesktop.resources.SolarRadiationResource;
import com.projeto.integrador.clientdesktop.views.solarradiations.CreateSolarRadiationFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class ListSolarRadiationsController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private SolarRadiationResource solarRadiationResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    for (SolarRadiation solarRadiation : solarRadiationResource.getAll()) {
      try {
        FXMLLoader loader = stageManager.getLoaderComponent("/fxml/solarradiations/components/SolarRadiation.fxml");

        solarRadiationsList.getChildren().add(loader.load());

        SolarRadiationController controller = loader.getController();
        controller.setSolarRadiation(solarRadiation);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  @FXML
  private void goToCreate(ActionEvent event) throws IOException {
		stageManager.switchScene(new CreateSolarRadiationFxmlView());
  }

  @FXML
  private Pane solarRadiationsList;

}
