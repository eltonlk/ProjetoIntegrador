package com.projeto.integrador.clientdesktop.controls;

import com.projeto.integrador.clientdesktop.config.PolicyHelper;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

public class ButtonCan extends Button {

  private PolicyHelper policyHelper;

  private final StringProperty policy = new SimpleStringProperty();

  public ButtonCan() {
    policyHelper = new PolicyHelper();
  }

  public final StringProperty policyProperty() {
    return policy;
  }

  public final String getPolicy() {
    return policy.get();
  }

  public final void setPolicy(String policy) {
    this.policy.set(policy);

    this.setDisable(policyHelper.cannot(policy));
  }

}
