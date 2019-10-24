package com.projeto.integrador.clientdesktop.controllers.users;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.users.components.RoleController;
import com.projeto.integrador.clientdesktop.models.User;
import com.projeto.integrador.clientdesktop.models.UserRole;
import com.projeto.integrador.clientdesktop.views.users.ListUsersFxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

@Controller
public class PermissionsController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  private User user;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public void render() {
    nameLabel.setText(getUser().getName());

    Map<String, List<UserRole>> groupByRole = user.getRoles().stream().collect(Collectors.groupingBy(u -> u.getRole().getName()));

    groupByRole.forEach((roleName, userRoles) -> {
      try {
        FXMLLoader loader = stageManager.getLoaderComponent("/fxml/users/components/Role.fxml");

        rolesList.getChildren().add(loader.load());

        RoleController controller = loader.getController();
        controller.setRoleName(roleName);
        controller.setUserRoles(userRoles);
        controller.render();
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListUsersFxmlView());
  }

  @FXML
  private Label nameLabel;

  @FXML
  private VBox rolesList;

}
