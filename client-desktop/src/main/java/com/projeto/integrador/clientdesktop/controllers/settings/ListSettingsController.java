package com.projeto.integrador.clientdesktop.controllers.settings;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.settings.components.OptionController;
import com.projeto.integrador.clientdesktop.models.Option;
import com.projeto.integrador.clientdesktop.resources.OptionResource;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class ListSettingsController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private OptionResource optionResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    for (Option option : optionResource.getAll()) {
      try {
        FXMLLoader loader = stageManager.getLoaderComponent("/fxml/settings/components/Option.fxml");

        optionsList.getChildren().add(loader.load());

        OptionController controller = loader.getController();
        controller.setOption(option);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @FXML
  private VBox optionsList;

}
