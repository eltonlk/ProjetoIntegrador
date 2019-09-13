package com.projeto.integrador.clientdesktop.views;

public class LoginFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/Login.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando";
  }

  @Override
  public Boolean isResizable() {
    return false;
  }

}
