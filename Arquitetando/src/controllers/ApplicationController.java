/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import main.StageManager;
import resources.AuthenticateUser;

/**
 * FXML Controller class
 *
 * @author nyko-
 */
public class ApplicationController implements Initializable {

    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnUsers;
    @FXML
    private Button btnMaterials;
    @FXML
    private Button btnCategories;
    @FXML
    private Button btnClose;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private AnchorPane menuPane;
    @FXML
    private ImageView menuLogo;

    enum View {

        CATEGORIES
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCategories.setOnAction((ActionEvent event) -> {
            setScene(View.CATEGORIES);
        });
    }

    @FXML
    public void logout(ActionEvent event) {
        AuthenticateUser.logout();
        StageManager.setScene(StageManager.View.LOGIN);
    }

    private void setScene(View view) {
        try {
            switchView(view);
        } catch (IOException ex) {
            String message = "Não foi possivel localizar a tela.";

            Logger.getLogger(StageManager.class.getName()).log(Level.SEVERE, message, ex);
        }
    }

    private void switchView(View view) throws IOException {
        switch (view) {
            case CATEGORIES:
                setScene("/views/categories/List.fxml");
                break;
        }
    }

    private void setScene(String path) throws IOException {
        URL resource = StageManager.class.getClass().getResource(path);

        Parent root = FXMLLoader.load(resource);

        String style = StageManager.class.getClass().getResource("/assets/stylesheets/main.css").toExternalForm();

        root.getStylesheets().add(style);

        mainPane.getChildren().setAll(root);
    }
}
