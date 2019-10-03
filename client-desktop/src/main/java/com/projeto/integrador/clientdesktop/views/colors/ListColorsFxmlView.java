package com.projeto.integrador.clientdesktop.views.colors;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class ListColorsFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/colors/ListColors.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Cores";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
