package com.projeto.integrador.clientdesktop.controllers.users;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.views.users.ListUsersFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class CreateUserController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListUsersFxmlView());
  }

}
