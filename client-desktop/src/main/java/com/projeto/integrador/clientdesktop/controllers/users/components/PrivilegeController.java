package com.projeto.integrador.clientdesktop.controllers.users.components;

import java.net.URL;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.models.UserRole;
import com.projeto.integrador.clientdesktop.resources.OptionResource;
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
    privilegeToggle.setAlignment(Pos.CENTER_LEFT);

    ToggleSwitch toggle = new ToggleSwitch(userRole.isEnable());

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
      case "READ_PRIVILEGE":
        return "Visualizar";

      case "CREATE_PRIVILEGE":
        return "Adicionar";

      case "UPDATE_PRIVILEGE":
        return "Alterar";

      case "DELETE_PRIVILEGE":
        return "Excluir";

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
