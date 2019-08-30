/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.text.DecimalFormat;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author nyko-
 */
public class NumberFormatterFactory {

    public static DefaultFormatterFactory newDecimal(String mask, double max) {
        DecimalFormat decimal = new DecimalFormat(mask);
        NumberFormatter numFormatter = new NumberFormatter(decimal);
        numFormatter.setMaximum(max);
        numFormatter.setFormat(decimal);
        numFormatter.setAllowsInvalid(false);
        DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatter);

        return dfFactory;
    }
}
