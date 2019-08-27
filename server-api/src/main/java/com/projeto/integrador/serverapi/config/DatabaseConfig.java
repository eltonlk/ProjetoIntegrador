package com.projeto.integrador.serverapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class DatabaseConfig {

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

}
