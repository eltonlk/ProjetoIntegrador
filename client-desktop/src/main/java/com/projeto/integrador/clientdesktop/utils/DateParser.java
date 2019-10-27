package com.projeto.integrador.clientdesktop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

  private static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

  public static String localized(Date date) {
    SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_PATTERN);

    return formatter.format(date);
  }

}
