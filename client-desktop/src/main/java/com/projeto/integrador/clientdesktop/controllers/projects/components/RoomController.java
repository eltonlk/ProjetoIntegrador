package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.config.ToastHelper;
import com.projeto.integrador.clientdesktop.controllers.projects.ShowProjectController;
import com.projeto.integrador.clientdesktop.controllers.projects.modals.FormFaceController;
import com.projeto.integrador.clientdesktop.controllers.projects.modals.FormRoomController;
import com.projeto.integrador.clientdesktop.models.Face;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.models.Room;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.resources.RoomResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RoomController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private RoomResource roomResource;

  @Autowired
  private ProjectResource projectResource;

  private Project project;

  private Room room;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  @FXML
  private void update(ActionEvent event) throws IOException {
    Stage modal = stageManager.buildModal("/fxml/projects/modals/FormRoom.fxml");

    FormRoomController controller = stageManager.getLoader().getController();
    controller.setProject(getProject());
    controller.setRoom(room);

    modal.show();
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
    Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja excluir o cômodo '" + room.getName() + "' ?", ButtonType.YES, ButtonType.NO);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      roomResource.delete(room);

      stageManager.switchScene(new ShowProjectFxmlView());
      ShowProjectController controller = stageManager.getLoader().getController();
      Project project = projectResource.refresh(getProject());
      controller.setProject(project);

      ToastHelper.success(String.format("Cômodo \"%s\" foi removido.", room.getName()));
    }
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;

    fillContent();
  }

  private void fillContent() {
    nameLabel.setText(room.getName());
    heatLoadLabel.setText(NumberParser.localizeFromDouble(room.getHeatLoad(), "#.##") + " W");
    btuLabel.setText(NumberParser.localizeFromDouble((int) room.getBTUCalculated()) + " BTU/H");

    if (room.getFaces() != null) {
      for (Face face : room.getFaces()) {
        try {
          FXMLLoader loader = stageManager.getLoaderComponent("/fxml/projects/components/Face.fxml");

          facesList.getChildren().add(loader.load());

          FaceController controller = loader.getController();
          controller.setProject(getProject());
          controller.setFace(face);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @FXML
  private void createFace(ActionEvent event) throws IOException {
    Stage modal = stageManager.buildModal("/fxml/projects/modals/FormFace.fxml");

    FormFaceController controller = stageManager.getLoader().getController();
    controller.setProject(getProject());
    controller.setRoom(getRoom());

    modal.show();
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label heatLoadLabel;

  @FXML
  private Label btuLabel;

  @FXML
  private Pane facesList;

}
