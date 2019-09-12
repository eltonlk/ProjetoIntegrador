/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

/**
 *
 * @author nyko-
 */
public class ProjectMaterial {

    private int id;
    private Material material;
    private double width;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        if (width < 0) {
            width = 0;
        }

        this.width = width;
    }

    public double getThermalConductivity() {
        if (material == null) {
            return 0;
        } else {
            return width / material.getThermalConductivityIndex();
        }
    }

}
