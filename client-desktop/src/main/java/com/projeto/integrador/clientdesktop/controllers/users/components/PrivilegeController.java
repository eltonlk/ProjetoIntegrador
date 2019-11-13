package com.projeto.integrador.clientdesktop.controllers.users.components;

import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.PolicyHelper;
import com.projeto.integrador.clientdesktop.models.UserRole;
import com.projeto.integrador.clientdesktop.resources.UserRoleResource;
import com.projeto.integrador.clientdesktop.utils.ToggleSwitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PrivilegeController implements Initializable {

  @Autowired
  private UserRoleResource userRoleResource;

  private UserRole userRole;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public void render() {
    PolicyHelper policyHelper = new PolicyHelper();

    privilegeToggle.setAlignment(Pos.CENTER_LEFT);

    ToggleSwitch toggle = new ToggleSwitch(userRole.isEnable());

    toggle.setDisable(policyHelper.cannot("ROLE_USERS_UPDATE_PRIVILEGE"));

    toggle.setCallback(new Runnable(){
      @Override
      public void run() {
        boolean isOn = toggle.switchedOnProperty().get();

        userRole.setEnable(isOn);

        userRoleResource.update(userRole);
      }
    });

    Label label = new Label(getHumanPrivilegeName(userRole));

    privilegeToggle.getChildren().addAll(toggle, label);
  }

  private String getHumanPrivilegeName(UserRole userRole) {
    switch (userRole.getPrivilege().getName()) {
      case "CREATE_PRIVILEGE":
        return "Adicionar";

      case "DELETE_PRIVILEGE":
        return "Excluir";

      case "GENERATE_PRIVILEGE":
        return "Gerar";

      case "IMPORT_PRIVILEGE":
        return "Importar";

      case "PERMISSIONS_PRIVILEGE":
        return "Permissões";

      case "READ_PRIVILEGE":
        return "Listar";

      case "SEND_MAIL_PRIVILEGE":
        return "Enviar E-mail";

      case "SHOW_PRIVILEGE":
        return "Visualizar";

      case "UPDATE_PRIVILEGE":
        return "Alterar";

      default:
        return userRole.getPrivilege().getName();
    }
  }

  public UserRole getUserRole() {
    return userRole;
  }

  public void setUserRole(UserRole userRole) {
    this.userRole = userRole;
  }

  @FXML
  private HBox privilegeToggle;

}
