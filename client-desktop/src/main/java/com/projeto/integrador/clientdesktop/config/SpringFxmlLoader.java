package com.projeto.integrador.clientdesktop.config;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringFxmlLoader {

  private final ApplicationContext context;
  private FXMLLoader loader;

  @Autowired
  public SpringFxmlLoader(ApplicationContext context) {
    this.context = context;
  }

  public Parent load(String fxmlPath) throws IOException {
    return buildLoader(fxmlPath).load();
  }

  public FXMLLoader buildLoader(String fxmlPath) {
    loader = new FXMLLoader();

    loader.setControllerFactory(context::getBean);

    loader.setLocation(getClass().getResource(fxmlPath));

    return loader;
  }

  public FXMLLoader getLoader() {
    return loader;
  }

}
