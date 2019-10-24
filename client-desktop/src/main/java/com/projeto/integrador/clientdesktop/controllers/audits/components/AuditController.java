package com.projeto.integrador.clientdesktop.controllers.audits.components;

import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Audit;
import com.projeto.integrador.clientdesktop.utils.DateParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

@Controller
public class AuditController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  private Audit audit;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public Audit getAudit() {
    return audit;
  }

  public void setAudit(Audit audit) {
    this.audit = audit;

    fillContent();
  }

  private void fillContent() {
    usernameLabel.setText(audit.getUsername());
    modifiedDateLabel.setText(DateParser.localized(audit.getModifiedDate()));
    actionLabel.setText(audit.getAction());
    auditableTypeLabel.setText(audit.getAuditableType());
    auditedChangesLabel.setText(audit.getAuditedChanges());
  }

  @FXML
  private Label usernameLabel;

  @FXML
  private Label modifiedDateLabel;

  @FXML
  private Label actionLabel;

  @FXML
  private Label auditedChangesLabel;

  @FXML
  private Label auditableTypeLabel;

}
