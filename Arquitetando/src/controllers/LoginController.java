/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.MainController;

/**
 * FXML Controller class
 *
 * @author nyko-
 */
public class LoginController implements Initializable {

    @FXML
    public TextField tfEmail;

    @FXML
    private PasswordField pfPassword;
    @FXML
    private Button btnSubmit;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void submit(ActionEvent event) {
        String email = tfEmail.getText();
        String password = pfPassword.getText();

        boolean authenticated = email.equals("admin") && password.equals("admin");

        if (authenticated) {
            System.out.println("Usuário autenticado");
            MainController.setScene("/views/Dashboard.fxml");
        } else {
            System.out.println("E-mail ou senha incorreto");
        }
    }
}
