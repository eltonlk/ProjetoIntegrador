package com.projeto.integrador.clientdesktop.config;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.controlsfx.control.Notifications;

import javafx.geometry.Pos;

public class ValidatorHelper {

  public Boolean valid(Object object) {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    Set<ConstraintViolation<Object>> errors = validator.validate(object);

    if (errors.isEmpty()) {
      return Boolean.TRUE;
    }

    String message = errors
    .stream()
    .map(ConstraintViolation::getMessage)
    .collect(Collectors.joining("\n"));

    Notifications notificationBuilder = Notifications.create()
      .title("Não foi possivel salvar!")
      .text(message)
      .position(Pos.TOP_CENTER);

    notificationBuilder.show();

    return Boolean.FALSE;
  }

}
