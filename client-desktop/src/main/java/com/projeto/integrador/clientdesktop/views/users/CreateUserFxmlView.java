package com.projeto.integrador.clientdesktop.views.users;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class CreateUserFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/users/CreateUser.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Adicionar Usuário";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
