package com.projeto.integrador.clientdesktop.controllers;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.User;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class UsersController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

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

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

    usersTable.setItems(listaDeClientes());
  }

  private ObservableList<User> listaDeClientes() {
    return FXCollections.observableArrayList(
      new User(new Long(1), "Usuário 1", "user_1", "user1@mail.com"),
      new User(new Long(2), "Usuário 2", "user_2", "user2@mail.com"),
      new User(new Long(3), "Usuário 3", "user_3", "user3@mail.com")
    );
  }

}
