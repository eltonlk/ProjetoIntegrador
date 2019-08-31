/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import com.jfoenix.controls.JFXSnackbar;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

/**
 *
 * @author nyko-
 */
public class Snackbar {

    private final Label message;

    public Snackbar(String message) {
        this.message = new Label(message);
    }

    public void show(AnchorPane rightPane) {
        message.setPadding(new Insets(15));
        message.setBackground(new Background(new BackgroundFill(Paint.valueOf("333"), CornerRadii.EMPTY, Insets.EMPTY)));
        message.setTextFill(Paint.valueOf("fff"));

        JFXSnackbar snackbar = new JFXSnackbar(rightPane);
        snackbar.enqueue(new JFXSnackbar.SnackbarEvent(message, Duration.seconds(4), null));
    }
}
