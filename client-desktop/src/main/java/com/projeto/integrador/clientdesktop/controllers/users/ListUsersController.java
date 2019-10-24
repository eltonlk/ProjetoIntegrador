package com.projeto.integrador.clientdesktop.controllers.users;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.users.components.UserController;
import com.projeto.integrador.clientdesktop.models.User;
import com.projeto.integrador.clientdesktop.resources.UserResource;
import com.projeto.integrador.clientdesktop.views.users.CreateUserFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class ListUsersController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private UserResource userResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    for (User user : userResource.getAll()) {
      try {
        FXMLLoader loader = stageManager.getLoaderComponent("/fxml/users/components/User.fxml");

        usersList.getChildren().add(loader.load());

        UserController controller = loader.getController();
        controller.setUser(user);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @FXML
  private void goToCreate(ActionEvent event) throws IOException {
		stageManager.switchScene(new CreateUserFxmlView());
  }

  @FXML
  private Pane usersList;

}
