package com.projeto.integrador.clientdesktop.controllers.projects.modals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.projects.ShowProjectController;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.models.Room;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.resources.RoomResource;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FormRoomController implements Initializable {

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
    this.room = new Room();
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public void setRoom(Room room) {
    this.room = room;

    fillForm();
  }

  private void fillForm() {
    nameInput.setText(room.getName());

    if (room.getId() != null && room.getId() > 0) {
      titleLabel.setText("Alterar Cômodo");
      submitButton.setText("Atualizar");
    }
  }

  @FXML
  private void save(ActionEvent event) throws IOException {
    this.room.setProject(this.project);
    this.room.setName(nameInput.getText());

    if (room.getId() != null && room.getId() > 0) {
      roomResource.update(room);
    } else {
      roomResource.create(room);
    }

    close(event);
  }

  private void close(ActionEvent event) {
    Project project = projectResource.refresh(this.project);

    stageManager.switchScene(new ShowProjectFxmlView());
    ShowProjectController controller = stageManager.getLoader().getController();
    controller.setProject(project);

    Node  source = (Node) event.getSource();
    Stage stage  = (Stage) source.getScene().getWindow();

    stage.close();
  }

  @FXML
  private Label titleLabel;

  @FXML
  private TextField nameInput;

  @FXML
  private Button submitButton;

}
