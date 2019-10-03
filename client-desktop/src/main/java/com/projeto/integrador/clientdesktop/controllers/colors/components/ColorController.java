package com.projeto.integrador.clientdesktop.controllers.colors.components;

import java.io.IOException;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.colors.UpdateColorController;
import com.projeto.integrador.clientdesktop.models.Color;
import com.projeto.integrador.clientdesktop.resources.ColorResource;
import com.projeto.integrador.clientdesktop.utils.NumberFormatter;
import com.projeto.integrador.clientdesktop.views.colors.ListColorsFxmlView;
import com.projeto.integrador.clientdesktop.views.colors.UpdateColorFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ColorController extends VBox {

  private Color color;

  private StageManager stageManager;

  private ColorResource colorResource;

  public ColorController() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/colors/components/Color.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
        fxmlLoader.load();
    } catch (IOException exception) {
        throw new RuntimeException(exception);
    }
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;

    fillContent();
  }

  public StageManager getStageManager() {
    return stageManager;
  }

  public void setStageManager(StageManager stageManager) {
    this.stageManager = stageManager;

    fillContent();
  }

  public ColorResource getColorResource() {
    return colorResource;
  }

  public void setColorResource(ColorResource colorResource) {
    this.colorResource = colorResource;

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
