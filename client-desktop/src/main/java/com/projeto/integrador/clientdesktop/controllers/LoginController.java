package com.projeto.integrador.clientdesktop.controllers;

import com.projeto.integrador.clientdesktop.utils.Flash;
import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.views.DashboardFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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

  @Autowired
  private AuthenticationManager authenticationManager;

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // TODO: remove on production
    usernameInput.setText("admin");
    passwordInput.setText("123456789");
  }

  public String getPassword() {
    return passwordInput.getText();
	}

	public String getUsername() {
    return usernameInput.getText();
  }

	@FXML
  private void login(ActionEvent event) throws IOException{
    Authentication authToken = new UsernamePasswordAuthenticationToken(getUsername(), getPassword());

    try {
      authToken = authenticationManager.authenticate(authToken);

      SecurityContextHolder.getContext().setAuthentication(authToken);

      stageManager.switchScene(new DashboardFxmlView());
    } catch (AuthenticationException e) {
      Node flash = new Flash().showMessage("Usuário ou senha inválido");

      if (loginPanel.getChildren().size() > 1) {
        loginPanel.getChildren().remove(0);
      }

      loginPanel.getChildren().add(0, flash);
    }
  }

  @FXML
  private PasswordField passwordInput;

  @FXML
  private TextField usernameInput;

  @FXML
  private Label lblLogin;

  @FXML
  private VBox loginPanel;
}
