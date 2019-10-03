package com.projeto.integrador.clientdesktop.views.solarradiations;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class UpdateSolarRadiationFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/solarradiations/UpdateSolarRadiation.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Alterar Radiação Solar";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
