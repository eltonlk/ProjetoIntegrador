package com.projeto.integrador.clientdesktop.controllers.colors;

import com.projeto.integrador.clientdesktop.config.StageManager;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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

    colorResource.update(color);

    if (color.getErrors() == null) {
      stageManager.switchScene(new ListColorsFxmlView());
    } else {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Erros");
      alert.setHeaderText("Foram encontrados alguns erros, por favor dê uma olhada:");
      alert.setContentText(color.getErrors().toJSONString());
      alert.showAndWait();
    }
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
