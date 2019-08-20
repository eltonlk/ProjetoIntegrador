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

        StageManager.setStage(stage);
        StageManager.setScene(StageManager.View.LOGIN);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
