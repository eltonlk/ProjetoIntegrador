package com.projeto.integrador.clientdesktop;

import javafx.stage.Stage;

import org.springframework.context.ApplicationEvent;

class StageReadEvent extends ApplicationEvent {

  public StageReadEvent(Stage source) {
    super(source);
  }

  public Stage getStage() {
    return Stage.class.cast(getSource());
  }

}
