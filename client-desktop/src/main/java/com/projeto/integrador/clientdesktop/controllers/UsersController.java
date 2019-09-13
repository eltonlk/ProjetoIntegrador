package com.projeto.integrador.clientdesktop.controllers;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.views.ApplicationFxmlView;

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
public class UsersController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

	@FXML
  private void goToDashboard(ActionEvent event) throws IOException{
    stageManager.switchScene(new ApplicationFxmlView());
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

}
