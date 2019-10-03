package com.projeto.integrador.clientdesktop.views.projects;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class UpdateProjectFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/projects/UpdateProject.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Alterar Projeto";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
