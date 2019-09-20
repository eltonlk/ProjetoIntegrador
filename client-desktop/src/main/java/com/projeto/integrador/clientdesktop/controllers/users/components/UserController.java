package com.projeto.integrador.clientdesktop.controllers.users.components;

import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.models.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import org.springframework.stereotype.Controller;

@Controller
public class UserController implements Initializable {

  private User user;

  public UserController() {
  }

  public UserController(User user) {
    this.user = user;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    nameLabel.setText(user.getName());
    emailLabel.setText(user.getEmail());
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label emailLabel;

}
