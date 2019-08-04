/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        try {
            Scene scene = getScene(path);

            MainController.stage.setScene(scene);

            if (!MainController.stage.isShowing()) {
                MainController.stage.show();
            }
        } catch (Exception ex) {
            String message = "Não foi possivel localizar a tela.";
            
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, message, ex);
        }
    }
    
    public static Scene getScene(String path) throws IOException {
        Parent root = FXMLLoader.load(main.getClass().getResource(path));
        
        return new Scene(root);
    }

    public static void closeStage() {
        MainController.stage.close();
    }

}
