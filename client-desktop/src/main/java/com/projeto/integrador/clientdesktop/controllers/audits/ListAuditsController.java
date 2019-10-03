package com.projeto.integrador.clientdesktop.controllers.audits;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.controllers.audits.components.AuditController;
import com.projeto.integrador.clientdesktop.models.Audit;
import com.projeto.integrador.clientdesktop.resources.AuditResource;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class ListAuditsController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private AuditResource auditResource;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    for (Audit audit : auditResource.getAll()) {
      try {
        FXMLLoader loader = stageManager.getLoaderComponent("/fxml/audits/components/Audit.fxml");

        auditsList.getChildren().add(loader.load());

        AuditController controller = loader.getController();
        controller.setAudit(audit);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @FXML
  private Pane auditsList;

}
