package com.projeto.integrador.clientdesktop.views.audits;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class ListAuditsFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/audits/ListAudits.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Histórico";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
