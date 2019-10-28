package com.projeto.integrador.clientdesktop.controllers.materials;

import com.projeto.integrador.clientdesktop.collections.MaterialKindCollection;
import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Material;
import com.projeto.integrador.clientdesktop.resources.MaterialResource;
import com.projeto.integrador.clientdesktop.utils.Mask;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.materials.ListMaterialsFxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class CreateMaterialController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private MaterialResource materialResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    activeCheckBox.setSelected(true);

    ObservableList<MaterialKindCollection> kindOptions = FXCollections.observableArrayList(MaterialKindCollection.collection());
    kindComboBox.setItems(kindOptions);
    kindComboBox.setOnAction((e) -> {
      kindChanged();
    });
    kindComboBox.fireEvent(new ActionEvent());

    Mask.addTo(thermalConductivityIndexInput, Mask.DECIMAL_5_X_5);
    Mask.addTo(solarFactorInput, Mask.DECIMAL_5_X_5);
    Mask.addTo(resistanceInput, Mask.DECIMAL_5_X_5);
  }

  private void kindChanged() {
    String kind = "";

    if (kindComboBox.getSelectionModel().getSelectedItem() != null) {
      kind = kindComboBox.getSelectionModel().getSelectedItem().getValue();
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
  }

  @FXML
  private void create(ActionEvent event) throws IOException {
    Material material = new Material();
    material.setName(nameInput.getText());
    material.setKind(kindComboBox.getSelectionModel().getSelectedItem().getValue());
    material.setThermalConductivityIndex(NumberParser.parseToDouble(thermalConductivityIndexInput.getText()));
    material.setSolarFactor(NumberParser.parseToDouble(solarFactorInput.getText()));
    material.setResistance(NumberParser.parseToDouble(resistanceInput.getText()));
    material.setActive(activeCheckBox.isSelected());

    materialResource.create(material);

		stageManager.switchScene(new ListMaterialsFxmlView());
  }

  @FXML
  private void goToBack(ActionEvent event) throws IOException {
		stageManager.switchScene(new ListMaterialsFxmlView());
  }

  @FXML
  private TextField nameInput;

  @FXML
  private ComboBox<MaterialKindCollection> kindComboBox;

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
  private CheckBox activeCheckBox;

  @FXML
  private Button submitButton;

}
