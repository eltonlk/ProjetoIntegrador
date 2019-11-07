package com.projeto.integrador.clientdesktop.views.reports;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

public class ListReportsFxmlView implements AbstractFxmlView {

  @Override
  public String getFxmlFile() {
    return "/fxml/reports/ListReports.fxml";
  }

  @Override
  public String getTitle() {
    return "Arquitetando: Relatórios";
  }

  @Override
  public Boolean isResizable() {
    return true;
  }

}
