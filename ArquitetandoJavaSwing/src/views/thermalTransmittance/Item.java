/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.thermalTransmittance;

import sources.Material;

/**
 *
 * @author nyko-
 */
public class Item {

    private Material material;
    private double width;

    Material getMaterial() {
        return this.material;
    }

    void setMaterial(Material material) {
        this.material = material;
    }

    double getWidth() {
        return this.width;
    }

    void setWidth(double width) {
        if (width < 0) {
            width = 0;
        }
        this.width = width;
    }

    double getThermalConductivity() {
        if (material == null) {
            return 0;
        } else {
            return width / material.getThermalConductivityIndex();
        }
    }
}
