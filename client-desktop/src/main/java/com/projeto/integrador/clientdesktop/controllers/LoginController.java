package com.projeto.integrador.clientdesktop.controllers;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.views.DashboardFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController implements Initializable {

	@FXML
  private Button btnLogin;

  @FXML
  private PasswordField password;

  @FXML
  private TextField username;

  @FXML
  private Label lblLogin;

  @Lazy
  @Autowired
  private StageManager stageManager;

	@FXML
  private void login(ActionEvent event) throws IOException{
    stageManager.switchScene(new DashboardFxmlView());
  }

	public String getPassword() {
		return password.getText();
	}

	public String getUsername() {
		return username.getText();
	}

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

}
