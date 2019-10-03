package com.projeto.integrador.clientdesktop.controllers.colors;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Color;
import com.projeto.integrador.clientdesktop.resources.ColorResource;
import com.projeto.integrador.clientdesktop.utils.NumberFormatter;
import com.projeto.integrador.clientdesktop.views.colors.ListColorsFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class CreateColorController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ColorResource colorResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    activeCheckBox.setSelected(true);

    // TODO:
    absorbabilityIndexInput.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\d{0,5}([\\,]\\d{0,5})?")) {
        absorbabilityIndexInput.setText(oldValue);
      }
    });
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    Color color = new Color();
    color.setName(nameInput.getText());
    color.setAbsorbabilityIndex(NumberFormatter.parseToDouble(absorbabilityIndexInput.getText()));
    color.setActive(activeCheckBox.isSelected());

    colorResource.create(color);

		stageManager.switchScene(new ListColorsFxmlView());
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListColorsFxmlView());
  }

  @FXML
  private Button submitButton;

  @FXML
  private TextField nameInput;

  @FXML
  private TextField absorbabilityIndexInput;

  @FXML
  private CheckBox activeCheckBox;

}
