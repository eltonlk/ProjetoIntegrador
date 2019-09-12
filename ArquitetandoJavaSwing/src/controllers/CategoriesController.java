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
import sources.Category;

/**
 *
 * @author nyko-
 */
public class CategoriesController {

    public ArrayList<Category> list(String searchParams) {
        ArrayList<Category> categories = new ArrayList<>();

        try {
            ArrayList<Category> categoriesObjects = (ArrayList<Category>) new ApiConnection().getList("/categories", new GenericType<ArrayList<Category>>() {
            });

            for (Category categoryObject : categoriesObjects) {
                categoryObject.active();
                categories.add(categoryObject);
            }
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return categories;
    }

    public Category find(int id) {
        Category category = null;

        try {
            category = (Category) new ApiConnection().get("/categories/" + id, Category.class);
            category.active();
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return category;
    }

    public String create(Category category) {
        try {
            String json = categoryToJson(category);

            new ApiConnection().post("/categories", json);

            return "";
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel gravar a Categoria.";
    }

    public String update(int id, Category category) {
        try {
            String json = categoryToJson(category);

            new ApiConnection().put("/categories/" + id, json);

            return "";
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel gravar a categoria.";
    }

    public String delete(int id) {
        try {
            new ApiConnection().delete("/categories/" + id);

            return "";
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel excluir a categoria";
    }

    private String categoryToJson(Category category) {
        String json = "{\"name\":\"" + category.getName() + "\""
                + ", \"active\":\"" + category.isActive() + "\""
                + "}";

        return json;
    }
}
