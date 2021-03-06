package com.projeto.integrador.clientdesktop.controllers.projects.modals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.config.ToastHelper;
import com.projeto.integrador.clientdesktop.controllers.projects.ShowProjectController;
import com.projeto.integrador.clientdesktop.models.Color;
import com.projeto.integrador.clientdesktop.models.Component;
import com.projeto.integrador.clientdesktop.models.Face;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.resources.ColorResource;
import com.projeto.integrador.clientdesktop.resources.ComponentResource;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.utils.Mask;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FormComponentController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ComponentResource componentResource;

  @Autowired
  private ProjectResource projectResource;

  @Autowired
  private ColorResource colorResource;

  private Project project;

  private Face face;

  private Component component;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Mask.addTo(areaInput, Mask.DECIMAL_5_X_5);

    component = new Component();

    ObservableList<Color> colorsOptions = FXCollections.observableArrayList(colorResource.getAll());
    colorsOptions.add(0, null);
    colorComboBox.setItems(colorsOptions);
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public void setFace(Face face) {
    this.face = face;
  }

  public void setComponent(Component component) {
    this.component = component;

    fillForm();
  }

  private void fillForm() {
    nameInput.setText(component.getName());
    areaInput.setText(NumberParser.localizeFromDouble(component.getArea()));
    colorComboBox.getSelectionModel().select(component.getColor());

    if (component.getId() != null && component.getId() > 0) {
      titleLabel.setText("Alterar Componente");
      submitButton.setText("Atualizar");
    }
  }

  @FXML
  private void save(ActionEvent event) throws IOException {
    this.component.setFace(this.face);
    this.component.setName(nameInput.getText());
    this.component.setArea(NumberParser.parseToDouble(areaInput.getText()));
    this.component.setColor(colorComboBox.getSelectionModel().getSelectedItem());

    if (component.getId() != null && component.getId() > 0) {
      componentResource.update(component);

      ToastHelper.success(String.format("Componente \"%s\" foi atualizado.", component.getName()));
    } else {
      componentResource.create(component);

      ToastHelper.success(String.format("Componente \"%s\" foi atualizado.", component.getName()));
    }

    close(event);
  }

  private void close(ActionEvent event) {
    Project project = projectResource.refresh(this.project);

    stageManager.switchScene(new ShowProjectFxmlView());
    ShowProjectController controller = stageManager.getLoader().getController();
    controller.setProject(project);

    Node  source = (Node) event.getSource();
    Stage stage  = (Stage) source.getScene().getWindow();

    stage.close();
  }

  @FXML
  private Label titleLabel;

  @FXML
  private TextField nameInput;

  @FXML
  private TextField areaInput;

  @FXML
  private ComboBox<Color> colorComboBox;

  @FXML
  private Button submitButton;

}
