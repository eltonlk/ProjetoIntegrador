package com.projeto.integrador.clientdesktop.config;

import com.projeto.integrador.clientdesktop.views.AbstractFxmlView;

import java.io.IOException;
import java.util.Objects;

import javafx.scene.Parent;
import javafx.scene.Scene;
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

    show(viewRootNodeHierarchy, view.getTitle());
  }

  private void show(final Parent rootNode, String title) {
    Scene scene = prepareScene(rootNode);

    stage.setTitle(title);
    stage.setScene(scene);
    stage.sizeToScene();
    stage.centerOnScreen();

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

}
