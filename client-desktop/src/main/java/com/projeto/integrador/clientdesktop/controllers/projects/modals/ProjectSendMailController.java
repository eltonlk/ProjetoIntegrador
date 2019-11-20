package com.projeto.integrador.clientdesktop.controllers.projects.modals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.config.ToastHelper;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProjectSendMailController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ProjectResource projectResource;

  private Project project;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public void setProject(Project project) {
    this.project = project;
  }

  @FXML
  private void send(ActionEvent event) throws IOException {
    String email = emailInput.getText();

    projectResource.sendMail(project, email);

    close(event);

    ToastHelper.success(String.format("Projeto \"%s\" foi enviado por e-mail.", project.getName()));
  }

  private void close(ActionEvent event) {
    Node  source = (Node) event.getSource();
    Stage stage  = (Stage) source.getScene().getWindow();

    stage.close();
  }

  @FXML
  private Label titleLabel;

  @FXML
  private TextField emailInput;

}
