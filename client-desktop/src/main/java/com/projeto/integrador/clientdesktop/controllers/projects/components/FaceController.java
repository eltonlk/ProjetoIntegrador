package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.projects.modals.CreateComponentController;
import com.projeto.integrador.clientdesktop.models.Component;
import com.projeto.integrador.clientdesktop.models.Face;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.utils.NumberParser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

  private Project project;

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

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  private void fillContent() {
    nameLabel.setText(face.getName());
    orientationLabel.setText(face.getOrientation());
    heatFlowLabel.setText(NumberParser.localizeFromDouble(face.getHeatFlow()));

    if (face.getComponents() != null) {
      for (Component component : face.getComponents()) {
        try {
          FXMLLoader loader = stageManager.getLoaderComponent("/fxml/projects/components/Component.fxml");

          componentsList.getChildren().add(loader.load());

          ComponentController controller = loader.getController();
          controller.setProject(getProject());
          controller.setComponent(component);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @FXML
  private void createComponent(ActionEvent event) throws IOException {
    Stage modal = stageManager.buildModal("/fxml/projects/modals/CreateComponent.fxml");

    CreateComponentController controller = stageManager.getLoader().getController();
    controller.setProject(getProject());
    controller.setFace(getFace());

    modal.show();
  }

  @FXML
  private Label nameLabel;

  @FXML
  private Label orientationLabel;

  @FXML
  private Label heatFlowLabel;

  @FXML
  private Pane componentsList;

}
