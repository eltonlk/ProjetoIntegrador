package com.projeto.integrador.clientdesktop.config;

import com.projeto.integrador.clientdesktop.Main;
import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.views.LoginFxmlView;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
public class JavaFXApplication extends Application {

  private ConfigurableApplicationContext context;
  private StageManager stageManager;

  @Override
  public void init() throws Exception {
    this.context = springBootApplicationContext();
  }

  @Override
  public void start(Stage stage) throws Exception {
    stageManager = context.getBean(StageManager.class, stage);

    displayInitialScene();
  }

  @Override
  public void stop() throws Exception {
    context.close();
    Platform.exit();
  }

  protected void displayInitialScene() {
    stageManager.switchScene(new LoginFxmlView());
  }

  private ConfigurableApplicationContext springBootApplicationContext() {
    SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
    String[] args = getParameters().getRaw().stream().toArray(String[]::new);

    return builder.run(args);
  }

}
