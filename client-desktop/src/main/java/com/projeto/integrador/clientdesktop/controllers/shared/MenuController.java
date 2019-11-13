package com.projeto.integrador.clientdesktop.controllers.shared;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.Policy;
import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.views.audits.ListAuditsFxmlView;
import com.projeto.integrador.clientdesktop.views.colors.ListColorsFxmlView;
import com.projeto.integrador.clientdesktop.views.materials.ListMaterialsFxmlView;
import com.projeto.integrador.clientdesktop.views.projects.ListProjectsFxmlView;
import com.projeto.integrador.clientdesktop.views.reports.ListReportsFxmlView;
import com.projeto.integrador.clientdesktop.views.settings.ListSettingsFxmlView;
import com.projeto.integrador.clientdesktop.views.solarradiations.ListSolarRadiationsFxmlView;
import com.projeto.integrador.clientdesktop.views.users.ListUsersFxmlView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

@Controller
public class MenuController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  // @Autowired
  // private Policy policy;

  private Boolean policy = Boolean.TRUE;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    System.out.println(">>>>>>>>>>>>>>>>>>>>> aqui!");
    // System.out.println(policy);
    // System.out.println(policy.can());

    goToMaterialsButton.setDisable(true);
  }

  // private Map<String, String> policies() {
  //   Map<String, String> policies = new HashMap<String, String>();

  //   policies.put("goToProjectsButton", "ROLE_PROJECTS_READ_PRIVILEGE");
  //   policies.put("goToMaterialsButton", "ROLE_PROJECTS_READ_PRIVILEGE");
  //   policies.put("goToColorsButton", "ROLE_PROJECTS_READ_PRIVILEGE");
  //   policies.put("goToSolarRadiationsButton", "ROLE_PROJECTS_READ_PRIVILEGE");
  //   policies.put("goToReportsButton", "ROLE_PROJECTS_READ_PRIVILEGE");
  //   policies.put("goToAuditsButton", "ROLE_PROJECTS_READ_PRIVILEGE");
  //   policies.put("goToSettingsButton", "ROLE_PROJECTS_READ_PRIVILEGE");
  //   policies.put("goToUsersButton", "ROLE_PROJECTS_READ_PRIVILEGE");

  //   return policies;
  // }

  @FXML
  private void goToAudits(ActionEvent event) throws IOException {
    stageManager.switchScene(new ListAuditsFxmlView());
  }

  @FXML
  private void goToColors(ActionEvent event) throws IOException {
    stageManager.switchScene(new ListColorsFxmlView());
  }

  @FXML
  private void goToMaterials(ActionEvent event) throws IOException {
    stageManager.switchScene(new ListMaterialsFxmlView());
  }

  @FXML
  private void goToProjects(ActionEvent event) throws IOException {
    stageManager.switchScene(new ListProjectsFxmlView());
  }

  @FXML
  private void goToReports(ActionEvent event) throws IOException {
    stageManager.switchScene(new ListReportsFxmlView());
  }

	@FXML
  private void goToSettings(ActionEvent event) throws IOException {
    stageManager.switchScene(new ListSettingsFxmlView());
  }

  @FXML
  private void goToSolarRadiations(ActionEvent event) throws IOException {
    stageManager.switchScene(new ListSolarRadiationsFxmlView());
  }

  @FXML
  private void goToUsers(ActionEvent event) throws IOException {
    stageManager.switchScene(new ListUsersFxmlView());
  }

  @FXML
  private void logout(ActionEvent event) throws IOException {
    Node  source = (Node) event.getSource();
    Stage stage  = (Stage) source.getScene().getWindow();

    stage.close();
  }

  // @FXML
  // private Button goToProjectsButton;

  @FXML
  private Button goToMaterialsButton;

  // @FXML
  // private Button goToColorsButton;

  // @FXML
  // private Button goToSolarRadiationsButton;

  // @FXML
  // private Button goToReportsButton;

  // @FXML
  // private Button goToAuditsButton;

  // @FXML
  // private Button goToSettingsButton;

  // @FXML
  // private Button goToUsersButton;

}
