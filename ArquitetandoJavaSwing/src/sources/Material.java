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
public class Material {

    public int id;
    public String name;
    public boolean active;
    public double thermalConductivityIndex;

    public Material() {
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isInactive() {
        return !isActive();
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void activate() {
        this.active = true;
    }

    public void inactivate() {
        this.active = false;
    }

    public double getThermalConductivityIndex() {;;
        return thermalConductivityIndex;
    }

    public void setThermalConductivityIndex(double thermalConductivityIndex) {
        this.thermalConductivityIndex = thermalConductivityIndex;
    }

    @Override
    public String toString() {
        return name;
    }
}
