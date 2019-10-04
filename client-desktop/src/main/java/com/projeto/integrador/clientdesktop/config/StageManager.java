package com.projeto.integrador.clientdesktop.config;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StageManager {

  private final Stage stage;
  private final SpringFxmlLoader loader;

  public StageManager(SpringFxmlLoader loader, Stage stage) {
    this.loader = loader;
    this.stage = stage;
  }

  public void switchScene(AbstractFxmlView view) {
    Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view.getFxmlFile());

    show(viewRootNodeHierarchy, view);
  }

  private void show(final Parent rootNode, AbstractFxmlView view) {
    Scene scene = prepareScene(rootNode);

    stage.setScene(scene);
    stage.setTitle(view.getTitle());
    stage.setResizable(view.isResizable());
    stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/logo.png")));

    if (!view.isResizable()) {
      stage.sizeToScene();
      stage.centerOnScreen();
    }

    try {
      stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private Scene prepareScene(Parent rootNode) {
    Scene scene = stage.getScene();

    if (scene == null) {
      scene = new Scene(rootNode);
    }

    scene.setRoot(rootNode);

    return scene;
  }

  private Parent loadViewNodeHierarchy(String fxmlFilePath) {
    Parent rootNode = null;

    try {
      rootNode = loader.load(fxmlFilePath);

      Objects.requireNonNull(rootNode, "A Root FXML node must not be null");
    } catch (IOException e) {
      e.printStackTrace();
    }

    return rootNode;
  }

  public FXMLLoader getLoader() {
    return loader.getLoader();
  }

  public FXMLLoader getLoaderComponent(String fxmlFilePath) {
    return loader.buildLoader(fxmlFilePath);
  }

  public Stage buildModal(String fxmlFilePath) {
    Stage dialog = new Stage();

    Parent viewRootNodeHierarchy = loadViewNodeHierarchy(fxmlFilePath);

    Scene scene = new Scene(viewRootNodeHierarchy);

    dialog.setScene(scene);

    dialog.initOwner(stage);
    dialog.initModality(Modality.APPLICATION_MODAL);

    return dialog;
  }

}
