package com.projeto.integrador.clientdesktop.controllers.projects;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.views.projects.ListProjectsFxmlView;

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

  private Project project;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
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
  }

  @FXML
  private Label nameLabel;

}
