package com.projeto.integrador.clientdesktop.views.users;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class UpdateUserFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/users/UpdateUser.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Alterar Usuário";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
