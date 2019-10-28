package com.projeto.integrador.clientdesktop.utils;

import java.text.DecimalFormat;

public class NumberParser {

  public static int parseToInt(String numberString) {
    try {
      return Integer.parseInt(numberString.replace(",", "."));
    } catch(Exception e) {
      return 0;
    }
  }

  public static Double parseToDouble(String numberString) {
    try {
      return Double.parseDouble(numberString.replace(",", "."));
    } catch(Exception e) {
      return 0.0;
    }
  }

  public static String localizeFromInt(int number) {
    try {
      return localizeFromDouble(number);
    } catch(Exception e) {
      return "";
    }
  }

  public static String localizeFromDouble(double number) {
    DecimalFormat formatter = new DecimalFormat();

    try {
      return formatter.format(number);
    } catch(Exception e) {
      return "";
    }
  }

  public static String localizeFromDouble(double number, String mask) {
    DecimalFormat formatter = new DecimalFormat(mask);

    try {
      return formatter.format(number);
    } catch(Exception e) {
      return "";
    }
  }

}
