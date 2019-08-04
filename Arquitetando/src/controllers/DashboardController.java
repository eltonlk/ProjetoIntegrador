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
import javafx.scene.layout.AnchorPane;
import main.MainController;

/**
 * FXML Controller class
 *
 * @author nyko-
 */
public class DashboardController implements Initializable {
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnUsers;
    @FXML
    private Button btnMaterials;
    @FXML
    private Button btnCategories;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void close(ActionEvent event) {
        MainController.closeStage();
    }
    
}
