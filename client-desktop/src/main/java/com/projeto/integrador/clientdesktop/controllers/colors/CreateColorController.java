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
import javafx.scene.text.Text;

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

  private ValidatorHelper validator = new ValidatorHelper();

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    activeCheckBox.setSelected(true);

    Mask.addTo(absorbabilityIndexInput, Mask.DECIMAL_5_X_5);
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    Color color = new Color();
    color.setName(nameInput.getText());
    color.setAbsorbabilityIndex(NumberParser.parseToDouble(absorbabilityIndexInput.getText()));
    color.setActive(activeCheckBox.isSelected());

    if (validator.valid(color)) {
      colorResource.create(color);

      stageManager.switchScene(new ListColorsFxmlView());

      ToastHelper.success(String.format("Cor \"%s\" adicionada", color.getName()));
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

  @FXML
  private Text flash;

}
