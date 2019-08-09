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

import sources.Material;

/**
 *
 * @author nyko-
 */
public class MateriaisController {

    public ArrayList<Material> listar(String parametrosPesquisa) {
        ArrayList<Material> materiais = new ArrayList<>();
        
        try {
            URL url = new URL("http://localhost:8080/materials");
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
            
            ArrayList<Material> materialsObjects;
            materialsObjects = new Genson().deserialize(builder.toString(), new GenericType<ArrayList<Material>>(){});
            
            for (Material materialObject : materialsObjects) {
                materialObject.active();
                materiais.add(materialObject);
            }
            
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return materiais;
    }

    public String criar(Material material) {
        try {
            URL url = new URL("http://localhost:8080/materials");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"name\":\"" + material.getName() + "\"}";

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

        return "Não foi possivel gravar o material.";
    }

    public Material procurar(int materialId) {
        Material material = new Material();
        
        try {
            URL url = new URL("http://localhost:8080/materials/" + materialId);
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
            
            material = new Genson().deserialize(builder.toString(), Material.class);
            
            material.active();

            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return material;
    }

    public String atualizar(int materialId, Material material) {
        try {
            URL url = new URL("http://localhost:8080/materials/" + materialId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"name\":\"" + material.getName() + "\"}";

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

        return "Não foi possivel gravar o material.";
    }

    public String excluir(int materialId) {
        try {
            URL url = new URL("http://localhost:8080/materials/" + materialId);
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
        
        return "Não foi possivel excluir o Material";
    }
    
}
