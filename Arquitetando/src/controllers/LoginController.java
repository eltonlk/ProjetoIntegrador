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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import resources.AuthenticateUser;
import resources.Snackbar;

/**
 * FXML Controller class
 *
 * @author nyko-
 */
public class LoginController implements Initializable {

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

    private final int LOGO_SIZE = 150;
    private final int LOGIN_PANE_W_SIZE = 200;
    private final int LOGIN_PANE_H_SIZE = 200;

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
        
        addResizeListener();
        setLogoPosition();
        setLoginPanePosition();

        title.setAlignment(Pos.CENTER);
        tfLogin.requestFocus();
        
        root.setMinSize(600, 400);
        leftPane.setMinSize(250, 400);
        rightPane.setMinSize(350, 400);
    }

    private void addResizeListener() {
        leftPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setLogoPosition();
            }
        });

        leftPane.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setLogoPosition();
            }
        });
        
        rightPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setLoginPanePosition();
            }
        });

        rightPane.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setLoginPanePosition();
            }
        });
    }

    private void setLoginPanePosition() {
        double x = (rightPane.getWidth() - LOGIN_PANE_W_SIZE) / 2;
        double y = (rightPane.getHeight() - LOGIN_PANE_H_SIZE) / 2;

        AnchorPane.setRightAnchor(loginPane, x);
        AnchorPane.setTopAnchor(loginPane, y);
        AnchorPane.setLeftAnchor(loginPane, x);
        AnchorPane.setBottomAnchor(loginPane, y);
    }

    private void setLogoPosition() {
        double x = (leftPane.getWidth() - LOGO_SIZE) / 2;
        double y = (leftPane.getHeight() - LOGO_SIZE) / 2;

        AnchorPane.setRightAnchor(logo, x);
        AnchorPane.setTopAnchor(logo, y);
        AnchorPane.setLeftAnchor(logo, x);
        AnchorPane.setBottomAnchor(logo, y);
    }

    @FXML
    public void submit(ActionEvent event) {
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

        if (AuthenticateUser.authenticate(login, password)) {
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
