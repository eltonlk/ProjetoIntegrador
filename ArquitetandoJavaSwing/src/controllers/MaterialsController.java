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
            materials = (ArrayList<Material>) new ApiConnection().getList("/materials", new GenericType<ArrayList<Material>>() {
            });
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return materials;
    }

    public Material find(int id) {
        Material material = null;

        try {
            material = (Material) new ApiConnection().get("/materials/" + id, Material.class);
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return material;
    }

    public String create(Material material) {
        try {
            String input = "{\"name\":\"" + material.getName() + "\""
                    + ", \"active\":\"" + material.isActive() + "\""
                    + ", \"thermal_conductivity_index_kind\":\"" + material.isThermalConductivityFixed() + "\""
                    + ", \"thermal_conductivity_index\":\"" + material.getThermalConductivityIndex() + "\""
                    + "}";

            new ApiConnection().post("/materials", input);

            return "";
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel gravar o material.";
    }
    
    public String update(int id, Material material) {
        try {
            String input = "{\"name\":\"" + material.getName() + "\""
                    + ", \"active\":\"" + material.isActive() + "\""
                    + ", \"thermal_conductivity_index_kind\":\"" + material.isThermalConductivityFixed() + "\""
                    + ", \"thermal_conductivity_index\":\"" + material.getThermalConductivityIndex() + "\""
                    + "}";

            new ApiConnection().put("/materials/" + id, input);

            return "";
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
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
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel excluir o Material";
    }
}
