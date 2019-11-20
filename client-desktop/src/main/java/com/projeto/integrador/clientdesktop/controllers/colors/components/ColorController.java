package com.projeto.integrador.clientdesktop.controllers.colors.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.config.ToastHelper;
import com.projeto.integrador.clientdesktop.controllers.colors.UpdateColorController;
import com.projeto.integrador.clientdesktop.models.Color;
import com.projeto.integrador.clientdesktop.resources.ColorResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.colors.ListColorsFxmlView;
import com.projeto.integrador.clientdesktop.views.colors.UpdateColorFxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
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
    String absorbability = NumberParser.localizeFromDouble(color.getAbsorbabilityIndex());

    nameLabel.setText(color.getName());
    absorbabilityLabel.setText(absorbability);
    inactiveLabel.setVisible(!color.isActive());
  }

  @FXML
  private void goToUpdate(ActionEvent event) throws IOException {
    stageManager.switchScene(new UpdateColorFxmlView());
    UpdateColorController controller = stageManager.getLoader().getController();
    controller.setColor(color);
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
    Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja excluir a cor '" + color.getName() + "' ?", ButtonType.YES, ButtonType.NO);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      colorResource.delete(color);

      stageManager.switchScene(new ListColorsFxmlView());

      ToastHelper.success(String.format("Cor \"%s\" foi removida.", color.getName()));
    }
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label absorbabilityLabel;

  @FXML
  private Label inactiveLabel;

}
