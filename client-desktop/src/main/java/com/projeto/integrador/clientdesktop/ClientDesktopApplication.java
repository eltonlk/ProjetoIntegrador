package com.projeto.integrador.clientdesktop;

import com.projeto.integrador.clientdesktop.view.FxmlView;

import javafx.application.Application;
import javafx.stage.Stage;

import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class ClientDesktopApplication extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	}

	protected void displayInitialScene() {
		stageManager.switchScene(FxmlView.LOGIN);
	}

}

// import org.springframework.boot.builder.SpringApplicationBuilder;
// import org.springframework.context.ConfigurableApplicationContext;

// import com.codetreatise.config.StageManager;


// @SpringBootApplication
// public class Main extends Application {

//     protected ConfigurableApplicationContext springContext;
//     protected StageManager stageManager;

//     @Override
//     public void init() throws Exception {
//         springContext = springBootApplicationContext();
//     }

//     @Override
//     public void start(Stage stage) throws Exception {
//         stageManager = springContext.getBean(StageManager.class, stage);
//         displayInitialScene();
//     }

//     @Override
//     public void stop() throws Exception {
//         springContext.close();
//     }

//     private ConfigurableApplicationContext springBootApplicationContext() {
//         SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
//         String[] args = getParameters().getRaw().stream().toArray(String[]::new);
//         return builder.run(args);
//     }
