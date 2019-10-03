package com.projeto.integrador.clientdesktop.controllers.colors;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.colors.components.ColorController;
import com.projeto.integrador.clientdesktop.models.Color;
import com.projeto.integrador.clientdesktop.resources.ColorResource;
import com.projeto.integrador.clientdesktop.views.colors.CreateColorFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class ListColorsController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ColorResource colorResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    for (Color color : colorResource.getAll()) {
      try {
        FXMLLoader loader = stageManager.getLoaderComponent("/fxml/colors/components/Color.fxml");

        colorsList.getChildren().add(loader.load());

        ColorController controller = loader.getController();
        controller.setColor(color);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  @FXML
  private void goToCreate(ActionEvent event) throws IOException {
    stageManager.switchScene(new CreateColorFxmlView());
  }

  @FXML
  private Pane colorsList;

}
