/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import main.StageManager;
import resources.AuthenticateUser;

/**
 * FXML Controller class
 *
 * @author nyko-
 */
public class LoginController implements Initializable {
    @FXML
    private JFXButton btnSubmit;
    @FXML
    private JFXTextField tfLogin;
    @FXML
    private JFXPasswordField tfPassword;
   

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
        submit();
    }

    private void fieldKeyPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            submit();
        }
    }

    private void submit() {
        String login = tfLogin.getText();
        String password = tfPassword.getText();

        if (AuthenticateUser.authenticate(login, password)) {
            StageManager.setScene(StageManager.View.APPLICATION);
        } else {
            tfPassword.setText("");
            tfPassword.requestFocus();
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválido!");
        }
    }
}
