package com.projeto.integrador.clientdesktop.controllers.shared;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.views.UsersFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  @FXML
  private void goToAudits(ActionEvent event) throws IOException {
  }

  @FXML
  private void goToCategories(ActionEvent event) throws IOException {
  }

  @FXML
  private void goToMaterials(ActionEvent event) throws IOException {
  }

  @FXML
  private void goToProjects(ActionEvent event) throws IOException {
	}

	@FXML
  private void goToSettings(ActionEvent event) throws IOException {
	}

	@FXML
  private void goToUsers(ActionEvent event) throws IOException {
		stageManager.switchScene(new UsersFxmlView());
  }

  @FXML
  private void logout(ActionEvent event) throws IOException {
    Node  source = (Node) event.getSource();
    Stage stage  = (Stage) source.getScene().getWindow();

    stage.close();
  }

}
