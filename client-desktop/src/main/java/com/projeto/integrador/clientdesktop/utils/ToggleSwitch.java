package com.projeto.integrador.clientdesktop.utils;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ToggleSwitch extends Parent {

  private BooleanProperty switchedOn = new SimpleBooleanProperty(false);

  private TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(0.5));
  private FillTransition fillAnimation = new FillTransition(Duration.seconds(0.5));

  private ParallelTransition animation = new ParallelTransition(translateAnimation, fillAnimation);

  private Runnable callback;

  public ToggleSwitch(boolean defaultValue) {
    Rectangle background = newRectangle();
    Circle trigger = newCircle();

    translateAnimation.setNode(trigger);
    fillAnimation.setShape(background);

    getChildren().addAll(background, trigger);

    switchedOn.addListener((obs, oldState, newState) -> {
      if (callback != null) {
        callback.run();
      }

      boolean isOn = newState.booleanValue();
      translateAnimation.setToX(isOn ? 25 : 0);
      fillAnimation.setFromValue(isOn ? Color.WHITE : Color.web("#2980B9"));
      fillAnimation.setToValue(isOn ? Color.web("#2980B9") : Color.WHITE);

      animation.play();
    });

    setOnMouseClicked(event -> {
        switchedOn.set(!switchedOn.get());
    });

    switchedOn.set(defaultValue);
  }

  public BooleanProperty switchedOnProperty() {
    return switchedOn;
  }

  public void setCallback(Runnable callback) {
    this.callback = callback;
  }

  private Rectangle newRectangle() {
    Rectangle background = new Rectangle(50, 25);
    background.setArcWidth(25);
    background.setArcHeight(25);
    background.setFill(Color.WHITE);
    background.setStroke(Color.LIGHTGRAY);

    return background;
  }

  private Circle newCircle() {
    Circle circle = new Circle(12.5);
    circle.setCenterX(12.5);
    circle.setCenterY(12.5);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.LIGHTGRAY);

    DropShadow shadow = new DropShadow();
    shadow.setRadius(2);
    circle.setEffect(shadow);

    return circle;
  }
}
