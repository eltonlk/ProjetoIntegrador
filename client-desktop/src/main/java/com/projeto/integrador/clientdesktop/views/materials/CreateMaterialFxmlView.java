package com.projeto.integrador.clientdesktop.views.materials;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class CreateMaterialFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/materials/CreateMaterial.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Adicionar Material";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
