package com.projeto.integrador.clientdesktop.views.colors;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class CreateColorFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/colors/CreateColor.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Adicionar Cor";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
