package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Face;
import com.projeto.integrador.clientdesktop.models.Room;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

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

  private Room room;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
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
    heatLoadLabel.setText("" + room.getHeatLoad());
  }

  @FXML
  private void createFace(ActionEvent event) throws IOException {
    Face face = new Face();

    FXMLLoader loader = stageManager.getLoaderComponent("/fxml/projects/components/Face.fxml");

    facesList.getChildren().add(loader.load());

    FaceController controller = loader.getController();
    controller.setFace(face);
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label heatLoadLabel;

  @FXML
  private Pane facesList;

}
