package com.projeto.integrador.clientdesktop.controllers.users.components;

import java.net.URL;
import java.util.ResourceBundle;

import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.projeto.integrador.clientdesktop.models.Role;

// import com.projeto.integrador.clientdesktop.config.StageManager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RoleController implements Initializable {

  // @Lazy
  // @Autowired
  // private StageManager stageManager;

  private String roleName;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public void render() {
    roleLabel.setText(getHumanRoleName());


        // for (Option option : optionResource.getAll()) {
    //   try {
    //     FXMLLoader loader = stageManager.getLoaderComponent("/fxml/settings/components/Option.fxml");

    //     optionsList.getChildren().add(loader.load());

    //     OptionController controller = loader.getController();
    //     controller.setOption(option);
    //   } catch (Exception e) {
    //     e.printStackTrace();
    //   }
    // }


    // try {
    //   FXMLLoader loader = stageManager.getLoaderComponent("/fxml/users/components/Privilege.fxml");

    //   privilegesList.getChildren().add(loader.load());

    //   RoleController controller = loader.getController();
    //   // controller.setOption(option);
    // } catch (Exception e) {
    //   e.printStackTrace();
    // }
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getHumanRoleName() {
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
