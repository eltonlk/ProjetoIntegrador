package com.projeto.integrador.clientdesktop.controllers.settings.components;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.projeto.integrador.clientdesktop.config.PolicyHelper;
import com.projeto.integrador.clientdesktop.config.StageManager;
import com.projeto.integrador.clientdesktop.models.Option;
import com.projeto.integrador.clientdesktop.resources.OptionResource;
import com.projeto.integrador.clientdesktop.utils.ToggleSwitch;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class OptionController implements Initializable {

  @Lazy
  @Autowired
  private StageManager stageManager;

  @Autowired
  private OptionResource optionResource;

  private Option option;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public Option getOption() {
    return option;
  }

  public void setOption(Option option) {
    this.option = option;

    fillContent();
  }

  private void fillContent() {
    PolicyHelper policyHelper = new PolicyHelper();

    row.setAlignment(Pos.CENTER_LEFT);

    ToggleSwitch toggle = new ToggleSwitch("enabled".equals(option.getValue()));

    toggle.setDisable(policyHelper.cannot("ROLE_OPTIONS_UPDATE_PRIVILEGE"));

    toggle.setCallback(new Runnable(){
      @Override
      public void run() {
        boolean isOn = toggle.switchedOnProperty().get();

        option.setValue(isOn ? "enabled" : "disabled");

        optionResource.update(option);
      }
    });

    Label label = new Label(humanName(option));

    row.getChildren().addAll(toggle, label);
  }

  private String humanName(Option option) {
    Map<String, String> map = new HashMap<>();

    map.put("audits", "Habilitar Histórico");

    if (map.get(option.getName()) != null) {
      return map.get(option.getName());
    } else {
      return option.getName();
    }
  }

  @FXML
  private HBox row;

}
