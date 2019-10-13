package com.projeto.integrador.clientdesktop.controllers.projects.modals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.projects.ShowProjectController;
import com.projeto.integrador.clientdesktop.models.Color;
import com.projeto.integrador.clientdesktop.models.Component;
import com.projeto.integrador.clientdesktop.models.Face;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.resources.ColorResource;
import com.projeto.integrador.clientdesktop.resources.ComponentResource;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CreateComponentController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ComponentResource componentResource;

  @Autowired
  private ProjectResource projectResource;

  @Autowired
  private ColorResource colorResource;

  private ObservableList<Color> colorsOptions;

  private Project project;

  private Face face;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    colorsOptions = FXCollections.observableArrayList(colorResource.getAll());

    colorComboBox.setItems(colorsOptions);
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public Face getFace() {
    return face;
  }

  public void setFace(Face face) {
    this.face = face;
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    Component component = new Component();
    component.setFace(getFace());
    component.setName(nameInput.getText());
    component.setArea(NumberParser.parseToDouble(areaInput.getText()));
    component.setColor(colorComboBox.getSelectionModel().getSelectedItem());

    componentResource.create(component);

    Project project = projectResource.refresh(getProject());

    stageManager.switchScene(new ShowProjectFxmlView());
    ShowProjectController controller = stageManager.getLoader().getController();
    controller.setProject(project);

    Node  source = (Node) event.getSource();
    Stage stage  = (Stage) source.getScene().getWindow();

    stage.close();
  }

  @FXML
  private TextField nameInput;

  @FXML
  private TextField areaInput;

  @FXML
  private ComboBox<Color> colorComboBox;

}
