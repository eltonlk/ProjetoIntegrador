/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.util.ArrayList;

/**
 *
 * @author nyko-
 */
public class Project {

    private int id;
    private String name;
    private ArrayList<ProjectMaterial> slabMaterials;
    private ArrayList<ProjectMaterial> wallMaterials;

    public Project() {
        slabMaterials = new ArrayList<>();
        wallMaterials = new ArrayList<>();
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

    public ArrayList<ProjectMaterial> getSlabMaterials() {
        return slabMaterials;
    }

    public void addSlabMaterial(ProjectMaterial material) {
        this.slabMaterials.add(material);
    }

    public ArrayList<ProjectMaterial> getWallMaterials() {
        return wallMaterials;
    }

    public void addWallMaterial(ProjectMaterial material) {
        this.wallMaterials.add(material);
    }

}
