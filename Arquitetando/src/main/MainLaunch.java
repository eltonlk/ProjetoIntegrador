package main;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author nyko-
 */
public class MainLaunch extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Arquitetando");
        stage.setResizable(false);
        
        MainController.setMainLaunch(this);
        MainController.setStage(stage);
        MainController.setScene("/views/Login.fxml");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
