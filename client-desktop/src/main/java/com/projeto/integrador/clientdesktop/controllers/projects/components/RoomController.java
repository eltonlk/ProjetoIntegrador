package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.projects.modals.CreateFaceController;
import com.projeto.integrador.clientdesktop.models.Face;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.models.Room;
import com.projeto.integrador.clientdesktop.utils.NumberFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

  private Project project;

  private Room room;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
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
    heatLoadLabel.setText(NumberFormatter.localizeFromDouble(room.getHeatLoad()));

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
    Stage modal = stageManager.buildModal("/fxml/projects/modals/CreateFace.fxml");

    CreateFaceController controller = stageManager.getLoader().getController();
    controller.setProject(getProject());
    controller.setRoom(getRoom());

    modal.show();
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label heatLoadLabel;

  @FXML
  private Pane facesList;

}
