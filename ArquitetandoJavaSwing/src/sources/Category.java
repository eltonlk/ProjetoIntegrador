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
public class Category {

    private int id;
    private String name;
    private boolean active;

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
