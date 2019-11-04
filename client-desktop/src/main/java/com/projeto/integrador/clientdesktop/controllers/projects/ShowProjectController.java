package com.projeto.integrador.clientdesktop.controllers.projects;

import com.projeto.integrador.clientdesktop.collections.ProjectSeasonCollection;
import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.projects.components.RoomController;
import com.projeto.integrador.clientdesktop.controllers.projects.modals.FormRoomController;
import com.projeto.integrador.clientdesktop.controllers.projects.modals.ProjectSendMailController;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.models.Room;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.projects.ListProjectsFxmlView;
import com.projeto.integrador.clientdesktop.views.projects.UpdateProjectFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class ShowProjectController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ProjectResource projectResource;

  private Project project;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  @FXML
  private void createRoom(ActionEvent event) throws IOException {
    Stage modal = stageManager.buildModal("/fxml/projects/modals/FormRoom.fxml");

    FormRoomController controller = stageManager.getLoader().getController();
    controller.setProject(getProject());

    modal.show();
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListProjectsFxmlView());
  }

  @FXML
  private void goToUpdate(ActionEvent event) throws IOException {
    stageManager.switchScene(new UpdateProjectFxmlView());
    UpdateProjectController controller = stageManager.getLoader().getController();
    controller.setProject(getProject());
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
    Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja excluir o projeto '" + project.getName() + "' ?", ButtonType.YES, ButtonType.NO);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      projectResource.delete(getProject());

      stageManager.switchScene(new ListProjectsFxmlView());
    }
  }

  @FXML
  private void sendMail(ActionEvent event) throws IOException {
    Stage modal = stageManager.buildModal("/fxml/projects/modals/ProjectSendMail.fxml");

    ProjectSendMailController controller = stageManager.getLoader().getController();
    controller.setProject(getProject());

    modal.show();
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;

    fillContent();
  }

  private void fillContent() {
    nameLabel.setText(project.getName());
    seasonLabel.setText(ProjectSeasonCollection.findByValue(project.getSeason()).toString());
    externalTemperatureLabel.setText(NumberParser.localizeFromInt(project.getExternalTemperature()));
    internalTemperatureLabel.setText(NumberParser.localizeFromInt(project.getInternalTemperature()));
    solarRadiationLabel.setText(project.getSolarRadiation().getName());

    if (project.getRooms() != null) {
      for (Room room : project.getRooms()) {
        try {
          FXMLLoader loader = stageManager.getLoaderComponent("/fxml/projects/components/Room.fxml");

          roomsList.getChildren().add(loader.load());

          RoomController controller = loader.getController();

          controller.setProject(getProject());
          controller.setRoom(room);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label seasonLabel;

  @FXML
  private Label externalTemperatureLabel;

  @FXML
  private Label internalTemperatureLabel;

  @FXML
  private Label solarRadiationLabel;

  @FXML
  private Pane roomsList;

}
