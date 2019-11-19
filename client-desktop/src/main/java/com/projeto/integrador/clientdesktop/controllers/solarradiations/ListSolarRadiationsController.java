package com.projeto.integrador.clientdesktop.controllers.solarradiations;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.solarradiations.components.SolarRadiationController;
import com.projeto.integrador.clientdesktop.models.SolarRadiation;
import com.projeto.integrador.clientdesktop.resources.SolarRadiationResource;
import com.projeto.integrador.clientdesktop.views.solarradiations.CreateSolarRadiationFxmlView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

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

  private BufferedReader templateBuffer;

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
  private void goToImport(ActionEvent event) throws IOException {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Importar Arquivo CSV");

    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
    fileChooser.getExtensionFilters().add(extFilter);

    File file = fileChooser.showOpenDialog(stageManager.getStage());

    if (file != null) {
      solarRadiationResource.importFile(file);
    }
  }

  @FXML
  private void goToDownloadTemplate(ActionEvent event) throws IOException {
    FileChooser fileChooser = new FileChooser();

    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
    fileChooser.getExtensionFilters().add(extFilter);
    fileChooser.setInitialFileName("Radiacoes_Solar.csv");

    File file = fileChooser.showSaveDialog(stageManager.getStage());

    if(file != null){
      templateBuffer = new BufferedReader(new InputStreamReader(
        new FileInputStream(getClass().getResource("/templates/Radiacoes_Solar.csv").getPath()), "UTF-8"));

      FileWriter fileWriter = new FileWriter(file);

      String line;
      while ((line = templateBuffer.readLine()) != null) {
        fileWriter.write(line);
        fileWriter.write("\n");
      }

      fileWriter.close();
    }
  }

  @FXML
  private Pane solarRadiationsList;

}
