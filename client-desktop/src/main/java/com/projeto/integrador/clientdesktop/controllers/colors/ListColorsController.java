package com.projeto.integrador.clientdesktop.controllers.colors;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.config.ToastHelper;
import com.projeto.integrador.clientdesktop.controllers.colors.components.ColorController;
import com.projeto.integrador.clientdesktop.models.Color;
import com.projeto.integrador.clientdesktop.resources.ColorResource;
import com.projeto.integrador.clientdesktop.views.colors.CreateColorFxmlView;
import com.projeto.integrador.clientdesktop.views.colors.ListColorsFxmlView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
public class ListColorsController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ColorResource colorResource;

  private BufferedReader templateBuffer;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    for (Color color : colorResource.getAll()) {
      try {
        FXMLLoader loader = stageManager.getLoaderComponent("/fxml/colors/components/Color.fxml");

        colorsList.getChildren().add(loader.load());

        ColorController controller = loader.getController();
        controller.setColor(color);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @FXML
  private void goToCreate(ActionEvent event) throws IOException {
    stageManager.switchScene(new CreateColorFxmlView());
  }

  @FXML
  private void goToImport(ActionEvent event) throws IOException {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Importar Arquivo CSV");

    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
    fileChooser.getExtensionFilters().add(extFilter);

    File file = fileChooser.showOpenDialog(stageManager.getStage());

    if (file != null) {
      colorResource.importFile(file);

      stageManager.switchScene(new ListColorsFxmlView());

      ToastHelper.success("CSV importado.");
    }
  }

  @FXML
  private void goToDownloadTemplate(ActionEvent event) throws IOException {
    FileChooser fileChooser = new FileChooser();

    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
    fileChooser.getExtensionFilters().add(extFilter);
    fileChooser.setInitialFileName("Cores.csv");

    File file = fileChooser.showSaveDialog(stageManager.getStage());

    if(file != null){
      templateBuffer = new BufferedReader(new InputStreamReader(
        getClass().getResourceAsStream("/templates/Cores.csv"),
        StandardCharsets.UTF_8
      ));

      OutputStreamWriter fileWriter = new OutputStreamWriter(
        new FileOutputStream(file),
        StandardCharsets.UTF_8
      );

      String line;
      while ((line = templateBuffer.readLine()) != null) {
        fileWriter.write(line);
        fileWriter.write("\n");
      }

      fileWriter.close();
    }
  }

  @FXML
  private Pane colorsList;

}
