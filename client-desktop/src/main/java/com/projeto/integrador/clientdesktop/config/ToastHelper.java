package com.projeto.integrador.clientdesktop.config;

import org.controlsfx.control.Notifications;

import javafx.geometry.Pos;

public class ToastHelper {

  public void successMessage(String message) {
    Notifications notificationBuilder = Notifications.create()
    .text(message)
    .position(Pos.TOP_RIGHT);

    notificationBuilder.show();
  }

  public static void success(String message) {
    ToastHelper toast = new ToastHelper();

    toast.successMessage(message);
  }

}
