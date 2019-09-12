package com.projeto.integrador.clientdesktop.views;

import javafx.stage.Stage;

public class LoginFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/Login.fxml";
  }

  @Override
  public void prepareStage(Stage stage) {
    stage.setTitle("Login");
    stage.setResizable(false);
  }

}
