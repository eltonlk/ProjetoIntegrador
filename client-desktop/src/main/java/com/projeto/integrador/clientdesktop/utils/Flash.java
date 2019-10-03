package com.projeto.integrador.clientdesktop.utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Flash {

    public enum Kind {
        INFO(144,202,249),
        WARNING(255,245,157),
        ERROR(239,154,154);

        private final int r;
        private final int g;
        private final int b;

        public int getR() {
            return this.r;
        }

        public int getG() {
            return this.g;
        }

        public int getB() {
            return this.b;
        }

        private Kind(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }

    public Node showMessage(String message) {
        Label text = new Label(message);

        HBox pane = new HBox();
        pane.setAlignment(Pos.CENTER);
        pane.setBackground(new Background(this.bgColor()));
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.getChildren().add(text);

        return pane;
    }

    private BackgroundFill bgColor() {
        Color color = Color.rgb(Kind.WARNING.getR(), Kind.WARNING.getG(), Kind.WARNING.getB());

        return new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
    }

}
