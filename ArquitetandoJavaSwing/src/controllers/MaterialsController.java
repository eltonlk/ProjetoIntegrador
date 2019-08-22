/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.owlike.genson.GenericType;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import resources.ApiConnection;
import resources.LogManager;
import sources.Material;

/**
 *
 * @author nyko-
 */
public class MaterialsController {

    public ArrayList<Material> list(String searchParams) {
        ArrayList<Material> materials = new ArrayList<>();

        try {
            ArrayList<Material> materialsObjects = (ArrayList<Material>) new ApiConnection().getList("/materials", new GenericType<ArrayList<Material>>() {
            });

            for (Material material : materialsObjects) {
                material.active();
                materials.add(material);
            }
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        }

        return materials;
    }

    public Material find(int id) {
        Material material = null;

        try {
            material = (Material) new ApiConnection().get("/materials/" + id, Material.class);
            material.active();
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        }

        return material;
    }

    public String create(Material material) {
        try {
            String input = "{\"name\":\"" + material.getName() + "\"}";

            new ApiConnection().post("/materials", input);

            return "";
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel gravar o material.";
    }

    public String update(int id, Material material) {
        try {
            String input = "{\"name\":\"" + material.getName() + "\"}";

            new ApiConnection().put("/materials/" + id, input);

            return "";
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel gravar o material.";
    }

    public String delete(int id) {
        try {
            new ApiConnection().delete("/materials/" + id);

            return "";
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel excluir o Material";
    }
}
