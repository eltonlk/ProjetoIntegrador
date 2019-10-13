package com.projeto.integrador.clientdesktop.utils;

import java.text.DecimalFormat;

public class NumberParser {

    public static int parseToInt(String numberString) {
        return Integer.parseInt(numberString.replace(",", "."));
    }

    public static Double parseToDouble(String numberString) {
        return Double.parseDouble(numberString.replace(",", "."));
    }

    public static String localizeFromInt(int number) {
        return localizeFromDouble(number);
    }

    public static String localizeFromDouble(double number) {
        DecimalFormat formatter = new DecimalFormat();

        return formatter.format(number);
    }

    public static String localizeFromDouble(double number, String mask) {
        DecimalFormat formatter = new DecimalFormat(mask);

        return formatter.format(number);
    }

}
