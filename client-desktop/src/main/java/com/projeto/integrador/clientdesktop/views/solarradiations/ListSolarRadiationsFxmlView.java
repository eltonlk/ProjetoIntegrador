package com.projeto.integrador.clientdesktop.views.solarradiations;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class ListSolarRadiationsFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/solarradiations/ListSolarRadiations.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Radiações Solar";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
