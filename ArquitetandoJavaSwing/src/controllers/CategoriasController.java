/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import sources.Category;
import sources.Material;

/**
 *
 * @author nyko-
 */
public class CategoriasController {

    public ArrayList<Category> listar(String parametrosPesquisa) {
        ArrayList<Category> categorias = new ArrayList<>();

        try {
            URL url = new URL("http://localhost:8080/categories");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            StringBuilder builder = new StringBuilder();

            while ((output = br.readLine()) != null) {
                builder.append(output);
            }

            System.out.println(builder.toString());
            
            ArrayList<Category> categoriesObjects;
            categoriesObjects = new Genson().deserialize(builder.toString(), new GenericType<ArrayList<Category>>(){});
            
            for (Category categoryObject : categoriesObjects) {
                categoryObject.active();
                categorias.add(categoryObject);
            }
            
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return categorias;
    }

    public String criar(Category categoria) {
        try {
            URL url = new URL("http://localhost:8080/categories");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"name\":\"" + categoria.getName() + "\"}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            conn.disconnect();
            
            return "";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }    
        
        return "Não foi possivel gravar a Categoria.";
    }

    public Category procurar(int categoryId) {
        Category category = new Category();
        
        try {
            URL url = new URL("http://localhost:8080/categories/" + categoryId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            StringBuilder builder = new StringBuilder();

            while ((output = br.readLine()) != null) {
                builder.append(output);
            }

            System.out.println(builder.toString());
            
            category = new Genson().deserialize(builder.toString(), Category.class);
            
            category.active();

            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return category;
    }

    public String atualizar(int id, Category categoria) {
        try {
            URL url = new URL("http://localhost:8080/categories/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"name\":\"" + categoria.getName() + "\"}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            conn.disconnect();
            
            return "";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        

        return "Não foi possivel gravar a categoria.";
    }

    public String excluir(int id) {
        try {
            URL url = new URL("http://localhost:8080/categories/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            conn.disconnect();
            
            return "";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
        
        return "Não foi possivel excluir a categoria";
    }
    
}
