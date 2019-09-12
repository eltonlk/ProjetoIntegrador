package com.projeto.integrador.clientdesktop.views;

public class ApplicationFxmlView implements AbstractFxmlView {

  @Override
  public String getTitle() {
    return "Arquitetando";
  }

  @Override
  public String getFxmlFile() {
    return "/fxml/Application.fxml";
  }

}
