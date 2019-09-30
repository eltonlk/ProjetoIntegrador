package com.projeto.integrador.clientdesktop.views.projects;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class CreateProjectFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/projects/CreateProject.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Adicionar Projeto";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
