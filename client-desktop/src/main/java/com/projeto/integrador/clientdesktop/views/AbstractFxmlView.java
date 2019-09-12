package com.projeto.integrador.clientdesktop.views;

import javafx.stage.Stage;

public interface AbstractFxmlView {

  public String getFxmlFile();
  public void prepareStage(Stage stage);

}
