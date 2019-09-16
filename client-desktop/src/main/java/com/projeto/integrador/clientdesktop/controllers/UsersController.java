package com.projeto.integrador.clientdesktop.controllers;

import com.projeto.integrador.clientdesktop.config.StageManager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class UsersController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

}