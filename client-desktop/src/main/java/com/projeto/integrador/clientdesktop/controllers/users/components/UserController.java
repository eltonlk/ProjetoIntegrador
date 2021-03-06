package com.projeto.integrador.clientdesktop.controllers.users.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.config.ToastHelper;
import com.projeto.integrador.clientdesktop.controllers.users.PermissionsController;
import com.projeto.integrador.clientdesktop.controllers.users.UpdateUserController;
import com.projeto.integrador.clientdesktop.models.User;
import com.projeto.integrador.clientdesktop.resources.UserResource;
import com.projeto.integrador.clientdesktop.views.users.ListUsersFxmlView;
import com.projeto.integrador.clientdesktop.views.users.PermissionsFxmlView;
import com.projeto.integrador.clientdesktop.views.users.UpdateUserFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserController implements Initializable {

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

    fillContent();
  }

  private void fillContent() {
    nameLabel.setText(user.getName());
    emailLabel.setText(user.getEmail());
    inactiveLabel.setVisible(!user.isActive());
  }

  @FXML
  private void goToUpdate(ActionEvent event) throws IOException {
    stageManager.switchScene(new UpdateUserFxmlView());
    UpdateUserController controller = stageManager.getLoader().getController();
    controller.setUser(user);
  }

  @FXML
  private void goToPermissions(ActionEvent event) throws IOException {
    stageManager.switchScene(new PermissionsFxmlView());
    PermissionsController controller = stageManager.getLoader().getController();
    controller.setUser(user);
    controller.render();
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
    Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja excluir o usuário '" + user.getName() + "' ?", ButtonType.YES, ButtonType.NO);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      userResource.delete(user);

      stageManager.switchScene(new ListUsersFxmlView());

      ToastHelper.success(String.format("Usuário \"%s\" foi removido.", user.getName()));
    }
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label emailLabel;

  @FXML
  private Label inactiveLabel;

}
