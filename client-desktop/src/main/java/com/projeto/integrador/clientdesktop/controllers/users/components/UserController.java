package com.projeto.integrador.clientdesktop.controllers.users.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.users.UpdateUserController;
import com.projeto.integrador.clientdesktop.models.User;
import com.projeto.integrador.clientdesktop.resources.UserResource;
import com.projeto.integrador.clientdesktop.views.users.ListUsersFxmlView;
import com.projeto.integrador.clientdesktop.views.users.UpdateUserFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController implements Initializable {

  private StageManager stageManager;

  private User user;

  @Autowired
  private UserResource userResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public StageManager getStageManager() {
    return stageManager;
  }

  public void setStageManager(StageManager stageManager) {
    this.stageManager = stageManager;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;

    fillContent();
  }

  private void fillContent() {
    nameLabel.setText(user.getName());
    emailLabel.setText(user.getEmail());
  }

  @FXML
  private void goToUpdate(ActionEvent event) throws IOException {
    stageManager.switchScene(new UpdateUserFxmlView());
    UpdateUserController controller = stageManager.getLoader().getController();
    controller.setUser(user);
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
System.out.println(">>>>>>>>>>>>>>>>>>>>>");
System.out.println(userResource);
    userResource.delete(user);

    stageManager.switchScene(new ListUsersFxmlView());
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label emailLabel;

}
