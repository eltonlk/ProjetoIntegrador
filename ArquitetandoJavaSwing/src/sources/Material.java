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

    public Material() {
        this.active = true;
    }

    public Material(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public Material(int id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
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

    public void active() {
        this.active = true;
    }

    public void inactive() {
        this.active = false;
    }
}
