package com.projeto.integrador.clientdesktop.controllers.users;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.User;
import com.projeto.integrador.clientdesktop.resources.UserResource;
import com.projeto.integrador.clientdesktop.views.users.ListUsersFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class UpdateUserController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private UserResource userResource;

  private User user;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;

    fillForm();
  }

  private void fillForm() {
  }


  // @FXML
  // private void update(ActionEvent event) throws IOException {
  //   User user = new User();
  //   user.setName(nameInput.getText());
  //   user.setEmail(emailInput.getText());
  //   user.setUsername(usernameInput.getText());
  //   user.setPassword(passwordInput.getText());
  //   user.setActive(activeCheckBox.isSelected());

  //   userResource.update(user);

	// 	stageManager.switchScene(new ListUsersFxmlView());
  // }

  // @FXML
  // private void goToBack(ActionEvent event) throws IOException {
	// 	stageManager.switchScene(new ListUsersFxmlView());
  // }

  @FXML
  private Button submitButton;

  @FXML
  private PasswordField passwordInput;

  @FXML
  private TextField emailInput;

  @FXML
  private TextField nameInput;

  @FXML
  private TextField usernameInput;

  @FXML
  private CheckBox activeCheckBox;

}
