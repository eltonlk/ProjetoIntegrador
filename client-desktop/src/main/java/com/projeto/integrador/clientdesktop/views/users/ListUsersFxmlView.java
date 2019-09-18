package com.projeto.integrador.clientdesktop.views.users;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class ListUsersFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/users/ListUsers.fxml";
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
