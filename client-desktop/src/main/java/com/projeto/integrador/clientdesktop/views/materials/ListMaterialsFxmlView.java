package com.projeto.integrador.clientdesktop.views.materials;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class ListMaterialsFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/materials/ListMaterials.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Materiais";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
