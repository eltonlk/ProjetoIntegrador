package com.projeto.integrador.clientdesktop.views.projects;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class ShowProjectFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/projects/ShowProject.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Projeto";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
