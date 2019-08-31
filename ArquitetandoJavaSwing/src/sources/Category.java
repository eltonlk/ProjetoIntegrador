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

    public Category() {
        this.active = true;
    }

    public Category(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public Category(int id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return this.active;
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
