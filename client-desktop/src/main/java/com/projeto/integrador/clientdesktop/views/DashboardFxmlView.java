package com.projeto.integrador.clientdesktop.views;

public class DashboardFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/Dashboard.fxml";
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
