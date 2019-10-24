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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FormFaceController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private FaceResource faceResource;

  @Autowired
  private ProjectResource projectResource;

  private Project project;

  private Room room;

  private Face face;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    face = new Face();
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public void setFace(Face face) {
    this.face = face;

    fillForm();
  }

  private void fillForm() {
    nameInput.setText(face.getName());
    orientationComboBox.getSelectionModel().select(face.getOrientation());

    if (face.getId() != null && face.getId() > 0) {
      titleLabel.setText("Alterar Face");
      submitButton.setText("Atualizar");
    }
  }

  @FXML
  private void save(ActionEvent event) throws IOException {
    this.face.setRoom(this.room);
    this.face.setName(nameInput.getText());
    this.face.setOrientation("north"); // TODO: get value from combobox

    if (face.getId() != null && face.getId() > 0) {
      faceResource.update(face);
    } else {
      faceResource.create(face);
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
  private ComboBox<String> orientationComboBox;

  @FXML
  private Button submitButton;

}
