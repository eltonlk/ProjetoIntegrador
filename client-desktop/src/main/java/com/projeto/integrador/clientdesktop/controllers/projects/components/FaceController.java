package com.projeto.integrador.clientdesktop.controllers.projects.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.collections.FaceKindCollection;
import com.projeto.integrador.clientdesktop.collections.FaceOrientationCollection;
import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.config.ToastHelper;
import com.projeto.integrador.clientdesktop.controllers.projects.ShowProjectController;
import com.projeto.integrador.clientdesktop.controllers.projects.modals.FormComponentController;
import com.projeto.integrador.clientdesktop.controllers.projects.modals.FormFaceController;
import com.projeto.integrador.clientdesktop.models.Component;
import com.projeto.integrador.clientdesktop.models.Face;
import com.projeto.integrador.clientdesktop.models.Project;
import com.projeto.integrador.clientdesktop.resources.FaceResource;
import com.projeto.integrador.clientdesktop.resources.ProjectResource;
import com.projeto.integrador.clientdesktop.utils.NumberParser;
import com.projeto.integrador.clientdesktop.views.projects.ShowProjectFxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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

  @Autowired
  private FaceResource faceResource;

  @Autowired
  private ProjectResource projectResource;

  private Face face;

  private Project project;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  @FXML
  private void update(ActionEvent event) throws IOException {
    Stage modal = stageManager.buildModal("/fxml/projects/modals/FormFace.fxml");

    FormFaceController controller = stageManager.getLoader().getController();
    controller.setProject(getProject());
    controller.setFace(face);

    modal.show();
  }

  @FXML
  private void delete(ActionEvent event) throws IOException {
    String message = "Deseja excluir a face '" + FaceOrientationCollection.findByValue(face.getOrientation()).toString() + "' ?";
    Alert alert = new Alert(AlertType.CONFIRMATION, message, ButtonType.YES, ButtonType.NO);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      faceResource.delete(face);

      stageManager.switchScene(new ShowProjectFxmlView());
      ShowProjectController controller = stageManager.getLoader().getController();
      Project project = projectResource.refresh(getProject());
      controller.setProject(project);

      ToastHelper.success(String.format("Face \"%s\" foi removida.", face.getOrientation()));
    }
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
    kindLabel.setText(FaceKindCollection.findByValue(face.getKind()).toString());
    orientationLabel.setText(FaceOrientationCollection.findByValue(face.getOrientation()).toString());
    heatFlowLabel.setText(NumberParser.localizeFromDouble(face.getHeatFlow(), "#.##") + " W");

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
    Stage modal = stageManager.buildModal("/fxml/projects/modals/FormComponent.fxml");

    FormComponentController controller = stageManager.getLoader().getController();
    controller.setProject(getProject());
    controller.setFace(getFace());

    modal.show();
  }

  @FXML
  private Label kindLabel;

  @FXML
  private Label orientationLabel;

  @FXML
  private Label heatFlowLabel;

  @FXML
  private Pane componentsList;

}
