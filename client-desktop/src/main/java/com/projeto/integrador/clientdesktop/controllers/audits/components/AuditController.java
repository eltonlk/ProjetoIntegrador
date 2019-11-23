package com.projeto.integrador.clientdesktop.controllers.audits.components;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Audit;
import com.projeto.integrador.clientdesktop.utils.DateParser;
import com.projeto.integrador.clientdesktop.utils.I18n;

import org.json.simple.JSONObject;
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
    modifiedDateLabel.setText(DateParser.localized(audit.getCreatedAt()));
    actionLabel.setText(I18n.t(audit.getAction()));
    auditableTypeLabel.setText(I18n.t(audit.getAuditableType()));
    auditedChangesLabel.setText(i18nAuditedChanges(audit.getAuditedChanges()));
  }

  private String i18nAuditedChanges(JsonNode jsonObject) {
    String text = "";

    Iterator<Entry<String, JsonNode>> iterator = jsonObject.fields();

    while (iterator.hasNext()) {
      Entry<String, JsonNode> entry = iterator.next();
      String key = entry.getKey();

      text += I18n.t(key) + " = " + jsonObject.get(key).toString();

      if (iterator.hasNext()) {
        text += ", ";
      }
    }

    return "{ " + text + " }";
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
