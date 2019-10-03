package com.projeto.integrador.clientdesktop.views.colors;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class UpdateColorFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/colors/UpdateColor.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Alterar Cor";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
