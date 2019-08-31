/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.main;

import com.jfoenix.controls.JFXButton;
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
import resources.ResizablePane;

/**
 * FXML Controller class
 *
 * @author nyko-
 */
public class ApplicationController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane menuPane;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private ImageView menuLogo;
    @FXML
    private Button btnUsers;
    @FXML
    private Button btnMaterials;
    @FXML
    private JFXButton btnLogout;

    private static final String MAIN_CSS = "/assets/stylesheets/main.css";

    enum View {

        USERS_LIST("/views/users/List.fxml");

        private final String path;

        public String getPath() {
            return this.path;
        }

        private View(String path) {
            this.path = path;
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnUsers.setText("Usuáros");
        btnUsers.setOnAction((ActionEvent event) -> {
            setScene(View.USERS_LIST);
        });

        btnMaterials.setText("Materiais");
        btnMaterials.setOnAction((ActionEvent event) -> {
            //setScene(View.MATERIALS_LIST);
        });

        btnLogout.setText("Sair");
        btnLogout.setOnAction((ActionEvent event) -> {
            logout();
        });
    }

    private void logout() {
        AuthenticateUser.logout();
        StageManager.setScene(StageManager.View.LOGIN);
    }

    private void setScene(View view) {
        try {
            switchScene(view);
        } catch (IOException ex) {
            String message = "Não foi possivel localizar a tela.";

            Logger.getLogger(StageManager.class.getName()).log(Level.SEVERE, message, ex);
        }
    }

    private void switchScene(View view) throws IOException {
        URL resource = StageManager.class.getClass().getResource(view.getPath());

        Parent parent = (Parent) FXMLLoader.load(resource);

        String style = StageManager.class.getClass().getResource(MAIN_CSS).toExternalForm();

        parent.getStylesheets().add(style);

        mainPane.getChildren().setAll(parent);

        new ResizablePane(mainPane, parent).responsive(0, 0, 0, 0).touch();
    }
}
