package com.projeto.integrador.clientdesktop.controllers.projects.modals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.projects.ShowProjectController;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.models.Room;
import com.projeto.integrador.clientdesktop.resources.RoomResource;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CreateRoomController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private RoomResource roomResource;

  private Project project;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    Room room = new Room();
    room.setProject(project);
    room.setName(nameInput.getText());

    roomResource.create(room);

    stageManager.switchScene(new ShowProjectFxmlView());
    ShowProjectController controller = stageManager.getLoader().getController();
    controller.setProject(project);

    Node  source = (Node) event.getSource();
    Stage stage  = (Stage) source.getScene().getWindow();

    stage.close();
  }

  @FXML
  private TextField nameInput;

}
