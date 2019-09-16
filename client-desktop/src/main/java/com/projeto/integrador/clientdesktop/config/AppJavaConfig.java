package com.projeto.integrador.clientdesktop.config;

import java.io.IOException;

import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppJavaConfig {

  @Autowired
  SpringFxmlLoader loader;

  @Bean
  @Lazy(value = true)
  public StageManager stageManager(Stage stage) throws IOException {
    return new StageManager(loader, stage);
  }

  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

}
