package com.projeto.integrador.clientdesktop.views;

public class UsersFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/Users.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Usuários";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
