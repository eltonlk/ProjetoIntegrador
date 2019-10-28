package com.projeto.integrador.clientdesktop.utils;

import javafx.scene.control.TextField;

public class Mask {

  public static final String DECIMAL_5_X_5 = "\\d{0,5}([\\,]\\d{0,5})?";

  public static void addTo(TextField field, String mask) {
    field.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches(mask)) {
        field.setText(oldValue);
      }
    });
  }

}
