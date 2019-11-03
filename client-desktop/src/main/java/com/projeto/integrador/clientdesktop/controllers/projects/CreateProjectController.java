package com.projeto.integrador.clientdesktop.controllers.projects;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.collections.ProjectSeasonCollection;
import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.models.SolarRadiation;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.resources.SolarRadiationResource;
import com.projeto.integrador.clientdesktop.utils.Mask;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.projects.ListProjectsFxmlView;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

@Controller
public class CreateProjectController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ProjectResource projectResource;

  @Autowired
  private SolarRadiationResource solarRadiationResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Mask.addTo(externalTemperatureInput, "([\\-])?\\d{0,2}");
    Mask.addTo(internalTemperatureInput, "([\\-])?\\d{0,2}");

    ObservableList<ProjectSeasonCollection> seasonOptions = FXCollections.observableArrayList(ProjectSeasonCollection.collection());
    seasonComboBox.setItems(seasonOptions);

    ObservableList<SolarRadiation> solarRadiationOptions = FXCollections.observableArrayList(solarRadiationResource.getAll());
    solarRadiationComboBox.setItems(solarRadiationOptions);
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    Project project = new Project();
    project.setName(nameInput.getText());
    project.setSeason(seasonComboBox.getSelectionModel().getSelectedItem().getValue());
    project.setExternalTemperature(NumberParser.parseToInt(externalTemperatureInput.getText()));
    project.setInternalTemperature(NumberParser.parseToInt(internalTemperatureInput.getText()));
    project.setSolarRadiation(solarRadiationComboBox.getSelectionModel().getSelectedItem());

    Project projectCreated = projectResource.create(project);

    if (project.getErrors() == null) {
      stageManager.switchScene(new ShowProjectFxmlView());
      ShowProjectController controller = stageManager.getLoader().getController();
      controller.setProject(projectCreated);
    } else {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Erros");
      alert.setHeaderText("Foram encontrados alguns erros, por favor dê uma olhada:");
      alert.setContentText(project.getErrors().toJSONString());
      alert.showAndWait();
    }

  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListProjectsFxmlView());
  }

  @FXML
  private Button submitButton;

  @FXML
  private TextField nameInput;

  @FXML
  private ComboBox<ProjectSeasonCollection> seasonComboBox;

  @FXML
  private TextField externalTemperatureInput;

  @FXML
  private TextField internalTemperatureInput;

  @FXML
  private ComboBox<SolarRadiation> solarRadiationComboBox;

}
