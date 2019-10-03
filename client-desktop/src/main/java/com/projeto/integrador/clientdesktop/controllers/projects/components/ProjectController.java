package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.projects.ShowProjectController;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProjectController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  private Project project;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
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
  private void goToShow(ActionEvent event) throws IOException {
    stageManager.switchScene(new ShowProjectFxmlView());
    ShowProjectController controller = stageManager.getLoader().getController();
    controller.setProject(project);
  }

  @FXML
  private Label nameLabel;

}
