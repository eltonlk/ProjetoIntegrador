package com.projeto.integrador.clientdesktop.controllers.users;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.User;
import com.projeto.integrador.clientdesktop.resources.UserResource;
import com.projeto.integrador.clientdesktop.views.users.CreateUserFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

    usersTable.setItems(loadUsers());
  }

  private ObservableList<User> loadUsers() {
    return FXCollections.observableArrayList(
      userResource.getAll()
    );
  }

  @FXML
  private void goToCreate(ActionEvent event) throws IOException {
		stageManager.switchScene(new CreateUserFxmlView());
  }

  @FXML
  private TableView<User> usersTable;

  @FXML
  private TableColumn<User, String> nameColumn;

  @FXML
  private TableColumn<User, String> usernameColumn;

  @FXML
  private TableColumn<User, String> emailColumn;

  @FXML
  private TableColumn actionsColumn;

}
