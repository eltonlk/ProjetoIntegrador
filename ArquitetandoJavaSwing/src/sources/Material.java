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

    public Material(int id, String name) {
        this.id = id;
        this.name = name;
    }    

    public Material() {
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

    public boolean isAtivo() {
        return active;
    }
    
    public boolean isInativo() {
        return !isAtivo();
    }

    public void active() {
        this.active = true;
    }

    public void inactive() {
        this.active = false;
    }
}
