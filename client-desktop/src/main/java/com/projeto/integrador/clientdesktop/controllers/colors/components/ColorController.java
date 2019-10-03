package com.projeto.integrador.clientdesktop.controllers.colors.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.colors.UpdateColorController;
import com.projeto.integrador.clientdesktop.models.Color;
import com.projeto.integrador.clientdesktop.resources.ColorResource;
import com.projeto.integrador.clientdesktop.utils.NumberFormatter;
import com.projeto.integrador.clientdesktop.views.colors.ListColorsFxmlView;
import com.projeto.integrador.clientdesktop.views.colors.UpdateColorFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class ColorController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ColorResource colorResource;

  private Color color;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;

    fillContent();
  }

  private void fillContent() {
    String absorbability = NumberFormatter.localizeFromDouble(color.getAbsorbabilityIndex());

    nameLabel.setText(color.getName());
    absorbabilityLabel.setText(absorbability);
  }

  @FXML
  private void goToUpdate(ActionEvent event) throws IOException {
    stageManager.switchScene(new UpdateColorFxmlView());
    UpdateColorController controller = stageManager.getLoader().getController();
    controller.setColor(color);
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
    colorResource.delete(color);

    stageManager.switchScene(new ListColorsFxmlView());
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label absorbabilityLabel;

}
