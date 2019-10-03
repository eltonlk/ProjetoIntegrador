package com.projeto.integrador.clientdesktop.controllers.projects;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.views.projects.ListProjectsFxmlView;
import com.projeto.integrador.clientdesktop.views.projects.UpdateProjectFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListProjectsFxmlView());
  }

  @FXML
  private void goToUpdate(ActionEvent event) throws IOException {
    stageManager.switchScene(new UpdateProjectFxmlView());
    UpdateProjectController controller = stageManager.getLoader().getController();
    controller.setProject(project);
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
    projectResource.delete(project);

    stageManager.switchScene(new ListProjectsFxmlView());
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
    solarRadiationLabel.setText(project.getSolarRadiation().getName() + " (" + project.getSolarRadiation().getIndex() + ")");
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label solarRadiationLabel;

}
