package com.projeto.integrador.clientdesktop.controllers.colors;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.config.ToastHelper;
import com.projeto.integrador.clientdesktop.config.ValidatorHelper;
import com.projeto.integrador.clientdesktop.models.Color;
import com.projeto.integrador.clientdesktop.resources.ColorResource;
import com.projeto.integrador.clientdesktop.utils.Mask;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.colors.ListColorsFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

  private ValidatorHelper validator = new ValidatorHelper();

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    color = new Color();

    Mask.addTo(absorbabilityIndexInput, Mask.DECIMAL_5_X_5);
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

    if (validator.valid(color)) {
      colorResource.update(color);

      stageManager.switchScene(new ListColorsFxmlView());

      ToastHelper.success(String.format("Cor \"%s\" alterada", color.getName()));
    }
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListColorsFxmlView());
  }

  @FXML
  private TextField nameInput;

  @FXML
  private TextField absorbabilityIndexInput;

  @FXML
  private CheckBox activeCheckBox;

}
