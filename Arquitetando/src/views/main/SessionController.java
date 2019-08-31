/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controllers.ApiSessionController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import main.StageManager;
import resources.ResizablePane;
import resources.Snackbar;

/**
 * FXML Controller class
 *
 * @author nyko-
 */
public class SessionController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane leftPane;
    @FXML
    private AnchorPane rightPane;
    @FXML
    private ImageView logo;
    @FXML
    private AnchorPane loginPane;
    @FXML
    private Label title;
    @FXML
    private JFXTextField tfLogin;
    @FXML
    private JFXPasswordField tfPassword;
    @FXML
    private JFXButton btnSubmit;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfLogin.setPromptText("Login");
        tfPassword.setPromptText("Senha");
        btnSubmit.setText("Entrar");

        new ResizablePane(leftPane, logo).fixedSize(150, 150).touch();
        new ResizablePane(rightPane, loginPane).fixedSize(200, 200).touch();

        title.setAlignment(Pos.CENTER);
        tfLogin.requestFocus();

        root.setMinSize(600, 400);
        leftPane.setMinSize(250, 400);
        rightPane.setMinSize(350, 400);
    }

    @FXML
    public void btnSubmitOnAction(ActionEvent event) {
        submit();
    }

    @FXML
    private void fieldKeyPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            submit();
        }
    }

    private void submit() {
        String login = tfLogin.getText();
        String password = tfPassword.getText();

        if (ApiSessionController.create(login, password)) {
            StageManager.setScene(StageManager.View.APPLICATION);
        } else {
            tfPassword.setText("");

            new Snackbar("Usuário ou senha inválido!").show(rightPane);

            if (login.isEmpty()) {
                tfLogin.requestFocus();
            } else {
                tfPassword.requestFocus();
            }
        }
    }
}
