package com.projeto.integrador.clientdesktop.views.settings;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class ListSettingsFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/settings/ListSettings.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Opçoes do Sistema";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
