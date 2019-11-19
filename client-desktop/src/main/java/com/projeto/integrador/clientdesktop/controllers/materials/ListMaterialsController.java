package com.projeto.integrador.clientdesktop.controllers.materials;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.materials.components.MaterialController;
import com.projeto.integrador.clientdesktop.models.Material;
import com.projeto.integrador.clientdesktop.resources.MaterialResource;
import com.projeto.integrador.clientdesktop.views.materials.CreateMaterialFxmlView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
public class ListMaterialsController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private MaterialResource materialResource;

  private BufferedReader templateBuffer;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    for (Material material : materialResource.getAll()) {
      try {
        FXMLLoader loader = stageManager.getLoaderComponent("/fxml/materials/components/Material.fxml");

        materialsList.getChildren().add(loader.load());

        MaterialController controller = loader.getController();
        controller.setMaterial(material);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  @FXML
  private void goToCreate(ActionEvent event) throws IOException {
		stageManager.switchScene(new CreateMaterialFxmlView());
  }

  @FXML
  private void goToImport(ActionEvent event) throws IOException {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Importar Arquivo CSV");

    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
    fileChooser.getExtensionFilters().add(extFilter);

    File file = fileChooser.showOpenDialog(stageManager.getStage());

    if (file != null) {
      materialResource.importFile(file);
    }
  }

  @FXML
  private void goToDownloadTemplate(ActionEvent event) throws IOException {
    FileChooser fileChooser = new FileChooser();

    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
    fileChooser.getExtensionFilters().add(extFilter);
    fileChooser.setInitialFileName("Materiais.csv");

    File file = fileChooser.showSaveDialog(stageManager.getStage());

    if(file != null){
      templateBuffer = new BufferedReader(new InputStreamReader(
        new FileInputStream(getClass().getResource("/templates/Materiais.csv").getPath()), "UTF-8"));

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
  private Pane materialsList;

}
