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
import main.MainLaunch;

/**
 *
 * @author nyko-
 */
public class MainController {

    private static MainLaunch main;
    private static Stage stage;
    
    public static void setMainLaunch(MainLaunch main) {
        MainController.main = main;
    }

    public static void setStage(Stage stage) {
        MainController.stage = stage;
    }

    public static void setScene(String path) {
        MainController.setScene(main.getClass().getResource(path));
    }

    public static void setScene(URL resource) {
        try {
            Parent root = FXMLLoader.load(resource);

            Scene scene = new Scene(root);

            MainController.stage.setScene(scene);
            
            if (!MainController.stage.isShowing()) {
                MainController.stage.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
