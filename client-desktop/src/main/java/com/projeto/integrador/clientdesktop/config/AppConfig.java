package com.projeto.integrador.clientdesktop.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class AppConfig {

  @Autowired
  SpringFxmlLoader loader;

  @Bean
  @Lazy(value = true)
  public StageManager stageManager(Stage stage) throws IOException {
    return new StageManager(loader, stage);
  }

  @Bean
  protected AuthenticationManager authenticationManager() throws Exception {
    return new CustomAuthenticationManager();
  }

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();

    // restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://eltonlk-projeto-integrador.herokuapp.com/"));
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:8080/"));

    List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();

    if (CollectionUtils.isEmpty(interceptors)) {
      interceptors = new ArrayList<>();
    }

    interceptors.add(new RestTemplateAuthenticationInterceptor());

    restTemplate.setInterceptors(interceptors);

    return restTemplate;
  }

}
