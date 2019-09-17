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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
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

  @Autowired
  private AuthenticationManager authenticationManager;

  @Lazy
  @Autowired
  private StageManager stageManager;

	@FXML
  private void login(ActionEvent event) throws IOException{
    Authentication authToken = new UsernamePasswordAuthenticationToken(username.getText(), password.getText());

    try {
      authToken = authenticationManager.authenticate(authToken);
      SecurityContextHolder.getContext().setAuthentication(authToken);
      stageManager.switchScene(new DashboardFxmlView());
    } catch (AuthenticationException e) {
System.out.println(e.getMessage());
      lblLogin.setText("Login failure, please try again:");
    }
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
