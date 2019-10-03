package com.projeto.integrador.clientdesktop.views.solarradiations;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class CreateSolarRadiationFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/solarradiations/CreateSolarRadiation.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Adicionar Radiação Solar";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
