package com.projeto.integrador.clientdesktop.controllers.users.components;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RoleController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  private String roleName;

  private Collection<UserRole> userRoles;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public void render() {
    roleLabel.setText(getHumanRoleName());

    getUserRoles().forEach((userRole) -> {
      try {
        FXMLLoader loader = stageManager.getLoaderComponent("/fxml/users/components/Privilege.fxml");

        privilegesList.getChildren().add(loader.load());

        PrivilegeController controller = loader.getController();
        controller.setUserRole(userRole);
        controller.render();
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Collection<UserRole> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(Collection<UserRole> userRoles) {
    this.userRoles = userRoles;
  }

  private String getHumanRoleName() {
    switch (getRoleName()) {
      case "ROLE_AUDITS":
        return "Histórico";

      case "ROLE_COLORS":
        return "Cores";

      case "ROLE_MATERIALS":
        return "Materiais";

      case "ROLE_OPTIONS":
        return "Opções";

      case "ROLE_PROJECTS":
        return "Projetos";

      case "ROLE_SOLAR_RADIATIONS":
        return "Radiação Solar";

      case "ROLE_USERS":
        return "Usuários";

      case "ROLE_USER_ROLES":
        return "Permissões";

      default:
        return "Não Implementado";
    }
  }

  @FXML
  private Label roleLabel;

  @FXML
  private HBox privilegesList;

}
