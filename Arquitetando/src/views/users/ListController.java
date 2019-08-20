/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.users;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controllers.UsersController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import resources.TableBuilder;

/**
 * FXML Controller class
 *
 * @author nyko-
 */
public class ListController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnNew;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private JFXTextField tfSearchName;
    @FXML
    private TableView table;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnNew.setText("Adicionar");
        btnSearch.setText("Pesquisar");
        tfSearchName.setPromptText("Nome");
        
        btnNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("VAI PARA A TELA DE ADICIONAR USUÁRIO");
            }
        });
        
        buildTableData();
    }

    private void buildTableData() {
        String[] headerTitles = new String[]{"Nome", "Login"};
        String[] bodyProperties = new String[]{"name", "login"};

        List users = UsersController.listAll();

        TableBuilder.build(table, FXCollections.observableList(users), headerTitles, bodyProperties);
    }

}
