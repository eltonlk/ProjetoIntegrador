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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class CreateUserController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private UserResource userResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    activeCheckBox.setSelected(true);
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    User user = new User();
    user.setName(nameInput.getText());
    user.setEmail(emailInput.getText());
    user.setUsername(usernameInput.getText());
    user.setPassword(passwordInput.getText());
    user.setActive(activeCheckBox.isSelected());

    userResource.create(user);

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
