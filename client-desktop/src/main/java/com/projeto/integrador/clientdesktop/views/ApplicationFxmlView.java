package com.projeto.integrador.clientdesktop.views;

import javafx.stage.Stage;

public class ApplicationFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/Application.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
