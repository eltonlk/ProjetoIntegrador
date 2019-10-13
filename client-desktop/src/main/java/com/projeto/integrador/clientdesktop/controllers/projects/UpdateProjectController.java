package com.projeto.integrador.clientdesktop.controllers.projects;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.models.SolarRadiation;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.resources.SolarRadiationResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class UpdateProjectController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ProjectResource projectResource;

  @Autowired
  private SolarRadiationResource solarRadiationResource;

  private ObservableList<SolarRadiation> solarRadiationOptions;

  private Project project;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    TextField[] indexTextFieldList = {externalTemperatureInput, internalTemperatureInput};

    for (TextField indexTextField : indexTextFieldList) {
      indexTextField.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("([\\-])?\\d{0,2}")) {
          indexTextField.setText(oldValue);
        }
      });
    }

    solarRadiationOptions = FXCollections.observableArrayList(solarRadiationResource.getAll());
    solarRadiationComboBox.setItems(solarRadiationOptions);

    project = new Project();
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;

    fillForm();
  }

  private void fillForm() {
    nameInput.setText(project.getName());
    externalTemperatureInput.setText(NumberParser.localizeFromInt(project.getExternalTemperature()));
    internalTemperatureInput.setText(NumberParser.localizeFromInt(project.getInternalTemperature()));
    solarRadiationComboBox.getSelectionModel().select(project.getSolarRadiation());
  }

  @FXML
  private void update(ActionEvent event) throws IOException {
    project.setName(nameInput.getText());
    project.setExternalTemperature(NumberParser.parseToInt(externalTemperatureInput.getText()));
    project.setInternalTemperature(NumberParser.parseToInt(internalTemperatureInput.getText()));
    project.setSolarRadiation(solarRadiationComboBox.getSelectionModel().getSelectedItem());

    projectResource.update(project);

    stageManager.switchScene(new ShowProjectFxmlView());
    ShowProjectController controller = stageManager.getLoader().getController();
    controller.setProject(project);
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
    stageManager.switchScene(new ShowProjectFxmlView());
    ShowProjectController controller = stageManager.getLoader().getController();
    controller.setProject(project);
  }

  @FXML
  private Button submitButton;

  @FXML
  private TextField nameInput;

  @FXML
  private ComboBox<String> seasonComboBox;

  @FXML
  private TextField externalTemperatureInput;

  @FXML
  private TextField internalTemperatureInput;

  @FXML
  private ComboBox<SolarRadiation> solarRadiationComboBox;

}
