package com.projeto.integrador.clientdesktop.controllers.projects.modals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.projects.ShowProjectController;
import com.projeto.integrador.clientdesktop.models.Face;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.models.Room;
import com.projeto.integrador.clientdesktop.resources.FaceResource;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CreateFaceController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private FaceResource faceResource;

  @Autowired
  private ProjectResource projectResource;

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
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    Face face = new Face();
    face.setRoom(getRoom());
    face.setName(nameInput.getText());
    face.setOrientation("north"); // TODO: get value from combobox

    faceResource.create(face);

    Project project = projectResource.refresh(getProject());

    stageManager.switchScene(new ShowProjectFxmlView());
    ShowProjectController controller = stageManager.getLoader().getController();
    controller.setProject(project);

    Node  source = (Node) event.getSource();
    Stage stage  = (Stage) source.getScene().getWindow();

    stage.close();
  }

  @FXML
  private TextField nameInput;

  @FXML
  private ComboBox<String> orientationComboBox;

}
