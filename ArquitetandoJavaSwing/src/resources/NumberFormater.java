/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.text.NumberFormat;
import java.util.Currency;

/**
 *
 * @author nyko-
 */
public class NumberFormater {

    public static NumberFormat newDecimal(int maxInteger, int maxFraction) {
        NumberFormat thermalConductivityIndexFormat = NumberFormat.getNumberInstance();
        thermalConductivityIndexFormat.setCurrency(Currency.getInstance(","));        
        thermalConductivityIndexFormat.setMaximumIntegerDigits(maxInteger);
        thermalConductivityIndexFormat.setMaximumFractionDigits(maxFraction);
        return thermalConductivityIndexFormat;
    }
}
