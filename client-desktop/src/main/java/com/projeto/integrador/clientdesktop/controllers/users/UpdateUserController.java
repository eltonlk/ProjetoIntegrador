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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
    user = new User();
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;

    fillForm();
  }

  private void fillForm() {
    nameInput.setText(user.getName());
    emailInput.setText(user.getEmail());
    usernameInput.setText(user.getUsername());
    activeCheckBox.setSelected(user.isActive());
  }

  @FXML
  private void update(ActionEvent event) throws IOException {
    user.setName(nameInput.getText());
    user.setEmail(emailInput.getText());
    user.setUsername(usernameInput.getText());
    user.setActive(activeCheckBox.isSelected());

    userResource.update(user);

    if (user.getErrors() == null) {
      stageManager.switchScene(new ListUsersFxmlView());
    } else {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Erros");
      alert.setHeaderText("Foram encontrados alguns erros, por favor dê uma olhada:");
      alert.setContentText(user.getErrors().toJSONString());
      alert.showAndWait();
    }
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListUsersFxmlView());
  }

  @FXML
  private Button submitButton;

  @FXML
  private TextField emailInput;

  @FXML
  private TextField nameInput;

  @FXML
  private TextField usernameInput;

  @FXML
  private CheckBox activeCheckBox;

}
