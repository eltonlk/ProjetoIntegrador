package com.projeto.integrador.clientdesktop.controllers.projects;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.projects.components.ProjectController;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.views.projects.CreateProjectFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class ListProjectsController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ProjectResource projectResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    for (Project project : projectResource.getAll()) {
      try {
        FXMLLoader loader = stageManager.getLoaderComponent("/fxml/projects/components/Project.fxml");

        projectsList.getChildren().add(loader.load());

        ProjectController controller = loader.getController();
        controller.setProject(project);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @FXML
  private void goToCreate(ActionEvent event) throws IOException {
		stageManager.switchScene(new CreateProjectFxmlView());
  }

  @FXML
  private Pane projectsList;

}
