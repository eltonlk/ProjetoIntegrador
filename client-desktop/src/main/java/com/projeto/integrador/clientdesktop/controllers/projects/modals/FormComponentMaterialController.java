package com.projeto.integrador.clientdesktop.controllers.projects.modals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.config.ToastHelper;
import com.projeto.integrador.clientdesktop.controllers.projects.ShowProjectController;
import com.projeto.integrador.clientdesktop.models.Component;
import com.projeto.integrador.clientdesktop.models.ComponentMaterial;
import com.projeto.integrador.clientdesktop.models.Material;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.resources.ComponentMaterialResource;
import com.projeto.integrador.clientdesktop.resources.MaterialResource;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FormComponentMaterialController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private ComponentMaterialResource componentMaterialResource;

  @Autowired
  private ProjectResource projectResource;

  @Autowired
  private MaterialResource materialResource;

  private ObservableList<Material> materialsOptions;

  private Project project;

  private Component component;

  private ComponentMaterial componentMaterial;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Mask.addTo(widthInput, Mask.DECIMAL_5_X_5);
    Mask.addTo(thermalConductivityIndexInput, Mask.DECIMAL_5_X_5);
    Mask.addTo(solarFactorInput, Mask.DECIMAL_1_X_5);
    Mask.addTo(resistanceInput, Mask.DECIMAL_5_X_5);

    componentMaterial = new ComponentMaterial();

    materialsOptions = FXCollections.observableArrayList(materialResource.getAll());

    materialComboBox.setItems(materialsOptions);

    materialComboBox.setOnAction((e) -> {
      Material material = materialComboBox.getSelectionModel().getSelectedItem();
      String kind = "";

      if (material != null) {
        thermalConductivityIndexInput.setText(NumberParser.localizeFromDouble(material.getThermalConductivityIndex()));
        solarFactorInput.setText(NumberParser.localizeFromDouble(material.getSolarFactor()));
        resistanceInput.setText(NumberParser.localizeFromDouble(material.getResistance()));

        kind = material.getKind();
      }

      thermalConductivityIndexWrapper.setVisible(false);
      solarFactorWrapper.setVisible(false);
      resistanceWrapper.setVisible(false);

      if ("translucent".equals(kind)) {
        thermalConductivityIndexWrapper.setVisible(true);
        solarFactorWrapper.setVisible(true);
      } else if ("air".equals(kind)) {
        resistanceWrapper.setVisible(true);
      } else {
        thermalConductivityIndexWrapper.setVisible(true);
      }
    });

    materialComboBox.fireEvent(new ActionEvent());
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public void setComponent(Component component) {
    this.component = component;
  }

  public void setComponentMaterial(ComponentMaterial componentMaterial) {
    this.componentMaterial = componentMaterial;

    fillForm();
  }

  private void fillForm() {
    materialComboBox.getSelectionModel().select(componentMaterial.getMaterial());
    widthInput.setText(NumberParser.localizeFromDouble(componentMaterial.getWidth()));
    thermalConductivityIndexInput.setText(NumberParser.localizeFromDouble(componentMaterial.getThermalConductivityIndex()));
    solarFactorInput.setText(NumberParser.localizeFromDouble(componentMaterial.getSolarFactor()));
    resistanceInput.setText(NumberParser.localizeFromDouble(componentMaterial.getResistance()));

    materialComboBox.fireEvent(new ActionEvent());

    if (componentMaterial.getId() != null && componentMaterial.getId() > 0) {
      titleLabel.setText("Alterar Material");
      submitButton.setText("Atualizar");
    }
  }

  @FXML
  private void save(ActionEvent event) throws IOException {
    componentMaterial.setComponent(this.component);
    componentMaterial.setMaterial(materialComboBox.getSelectionModel().getSelectedItem());
    componentMaterial.setWidth(NumberParser.parseToDouble(widthInput.getText()));
    componentMaterial.setThermalConductivityIndex(NumberParser.parseToDouble(thermalConductivityIndexInput.getText()));
    componentMaterial.setSolarFactor(NumberParser.parseToDouble(solarFactorInput.getText()));
    componentMaterial.setResistance(NumberParser.parseToDouble(resistanceInput.getText()));

    if (componentMaterial.getId() != null && componentMaterial.getId() > 0) {
      componentMaterialResource.update(componentMaterial);

      ToastHelper.success(String.format("Material \"%s\" foi atualizado.", componentMaterial.getMaterial().getName()));
    } else {
      componentMaterialResource.create(componentMaterial);

      ToastHelper.success(String.format("Material \"%s\" foi atualizado.", componentMaterial.getMaterial().getName()));
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
  private ComboBox<Material> materialComboBox;

  @FXML
  private TextField widthInput;

  @FXML
  private VBox thermalConductivityIndexWrapper;

  @FXML
  private TextField thermalConductivityIndexInput;

  @FXML
  private VBox solarFactorWrapper;

  @FXML
  private TextField solarFactorInput;

  @FXML
  private VBox resistanceWrapper;

  @FXML
  private TextField resistanceInput;

  @FXML
  private Button submitButton;

}
