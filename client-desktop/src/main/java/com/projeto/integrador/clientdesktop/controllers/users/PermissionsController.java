package com.projeto.integrador.clientdesktop.controllers.users;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.users.components.RoleController;
import com.projeto.integrador.clientdesktop.models.Role;
import com.projeto.integrador.clientdesktop.models.User;
import com.projeto.integrador.clientdesktop.models.UserRole;
import com.projeto.integrador.clientdesktop.views.users.ListUsersFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

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
    Map<String, List<UserRole>> groupByRole = user.getRoles().stream().collect(Collectors.groupingBy(u -> u.getRole().getName()));

    groupByRole.forEach((roleName, userRoles) -> {
      try {
        FXMLLoader loader = stageManager.getLoaderComponent("/fxml/users/components/Role.fxml");

        rolesList.getChildren().add(loader.load());

        RoleController controller = loader.getController();
        controller.setRoleName(roleName);
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
  private VBox rolesList;

}
