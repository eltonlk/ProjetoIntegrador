package com.projeto.integrador.clientdesktop.utils;

import java.text.DecimalFormat;

public class NumberFormatter {

    public static Double parseToDouble(String numberString) {
        return Double.parseDouble(numberString.replace(",", "."));
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
