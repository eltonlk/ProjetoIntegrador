/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.text.DecimalFormat;
//import java.text.NumberFormat;

/**
 *
 * @author Elton Luis Kolling
 */
public class NumberParse {

    public static Double parseToDouble(String numberString) {
        return Double.parseDouble(numberString.replace(",", "."));
    }

    public static String localizeFromDouble(double number, String mask) {
        DecimalFormat formatter = new DecimalFormat(mask);

        return formatter.format(number);
    }

}
