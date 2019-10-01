package com.projeto.integrador.clientdesktop.views.users;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class PermissionsFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/users/Permissions.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Permissões do Usuário";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
