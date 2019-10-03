package com.projeto.integrador.clientdesktop.views.materials;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class UpdateMaterialFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/materials/UpdateMaterial.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Alterar Material";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
