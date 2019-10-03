package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Component;
import com.projeto.integrador.clientdesktop.models.Face;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FaceController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  private Face face;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public Face getFace() {
    return face;
  }

  public void setFace(Face face) {
    this.face = face;

    fillContent();
  }

  private void fillContent() {
    // nameLabel.setText(face.getName());
    // heatFlowLabel.setText(face.getHeatFlow());
  }

  @FXML
  private void createComponent(ActionEvent event) throws IOException {
    Component component = new Component();

    FXMLLoader loader = stageManager.getLoaderComponent("/fxml/projects/components/Component.fxml");

    componentsList.getChildren().add(loader.load());

    ComponentController controller = loader.getController();
    controller.setComponent(component);
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label heatFlowLabel;

  @FXML
  private Pane componentsList;

}
