package com.projeto.integrador.clientdesktop.controllers.colors;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Color;
import com.projeto.integrador.clientdesktop.resources.ColorResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
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
public class UpdateColorController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ColorResource colorResource;

  private Color color;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    color = new Color();

    absorbabilityIndexInput.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\d{0,5}([\\,]\\d{0,5})?")) {
        absorbabilityIndexInput.setText(oldValue);
      }
    });
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;

    fillForm();
  }

  private void fillForm() {
    nameInput.setText(color.getName());
    absorbabilityIndexInput.setText(NumberParser.localizeFromDouble(color.getAbsorbabilityIndex()));
    activeCheckBox.setSelected(color.isActive());
  }

  @FXML
  private void update(ActionEvent event) throws IOException {
    color.setName(nameInput.getText());
    color.setAbsorbabilityIndex(NumberParser.parseToDouble(absorbabilityIndexInput.getText()));
    color.setActive(activeCheckBox.isSelected());

    colorResource.update(color);

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
