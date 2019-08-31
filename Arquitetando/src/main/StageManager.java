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
    public static final String MAIN_CSS = "/assets/stylesheets/main.css";

    public enum View {

        LOGIN("/views/main/Session.fxml", false),
        APPLICATION("/views/main/Application.fxml", true);

        private final String path;
        private final boolean resizable;

        public String getPath() {
            return this.path;
        }

        public boolean isResizable() {
            return this.resizable;
        }

        private View(String path, boolean resizable) {
            this.path = path;
            this.resizable = resizable;
        }
    }

    public static void setStage(Stage stage) {
        StageManager.stage = stage;
    }

    public static void setStageResizable(boolean value) {
        stage.setResizable(value);

        if (!value) {
            stage.sizeToScene();
        }
    }

    public static void setScene(View view) {
        if (!view.equals(View.LOGIN) && !AuthenticateUser.isAuthenticated()) {
            view = View.LOGIN;
        }

        try {
            switchScene(view);
        } catch (IOException ex) {
            String message = "Não foi possivel localizar a tela.";

            Logger.getLogger(StageManager.class.getName()).log(Level.SEVERE, message, ex);
        }
    }

    private static void switchScene(View view) throws IOException {
        URL resource = StageManager.class.getClass().getResource(view.getPath());

        Parent root = FXMLLoader.load(resource);

        Scene scene = new Scene(root);

        String style = StageManager.class.getClass().getResource(MAIN_CSS).toExternalForm();

        scene.getStylesheets().add(style);

        StageManager.stage.setScene(scene);

        if (!StageManager.stage.isShowing()) {
            StageManager.stage.show();
        }

        StageManager.setStageResizable(view.isResizable());
    }
}
