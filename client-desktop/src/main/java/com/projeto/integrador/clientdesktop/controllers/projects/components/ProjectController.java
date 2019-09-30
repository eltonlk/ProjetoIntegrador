package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.models.Project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import org.springframework.stereotype.Controller;

@Controller
public class ProjectController implements Initializable {

  private Project project;

  public ProjectController() {
  }

  public ProjectController(Project project) {
    this.project = project;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    nameLabel.setText(project.getName());
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  @FXML
  private Label nameLabel;

}
