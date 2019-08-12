/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import resources.AuthenticateUser;

/**
 *
 * @author nyko-
 */
public class StageManager {

    private static Stage stage;

    public enum View {
        LOGIN,
        APPLICATION
    }

    public static void setStage(Stage stage) {
        StageManager.stage = stage;
    }

    public static void setScene(View view) {
        try {
            switchView(view);
        } catch (IOException ex) {
            String message = "Não foi possivel localizar a tela.";

            Logger.getLogger(StageManager.class.getName()).log(Level.SEVERE, message, ex);
        }
    }

    private static void switchView(View view) throws IOException {
        switch (view) {
            case LOGIN:
                setScene("/views/main/Login.fxml");
                break;
            case APPLICATION:
                if (AuthenticateUser.isAuthenticated()) {
                    setScene("/views/main/Application.fxml");
                } else {
                    setScene("/views/main/Login.fxml");
                }
                break;
        }
    }

    private static void setScene(String path) throws IOException {
        URL resource = StageManager.class.getClass().getResource(path);

        Parent root = FXMLLoader.load(resource);

        Scene scene = new Scene(root);

        String style = StageManager.class.getClass().getResource("/assets/stylesheets/main.css").toExternalForm();

        scene.getStylesheets().add(style);

        StageManager.stage.setScene(scene);

        if (!StageManager.stage.isShowing()) {
            StageManager.stage.show();
        }
    }

}
