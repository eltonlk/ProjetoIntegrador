package com.projeto.integrador.clientdesktop;

import com.projeto.integrador.clientdesktop.config.JavaFXApplication;

import javafx.application.Application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		Application.launch(JavaFXApplication.class, args);
	}

}
