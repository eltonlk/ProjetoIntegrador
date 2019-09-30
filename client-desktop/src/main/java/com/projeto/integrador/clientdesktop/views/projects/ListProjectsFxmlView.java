package com.projeto.integrador.clientdesktop.views.projects;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class ListProjectsFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/projects/ListProjects.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Projetos";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
