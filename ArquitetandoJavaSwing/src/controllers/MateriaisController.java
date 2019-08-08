/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            StringBuilder builder = new StringBuilder();

            while ((output = br.readLine()) != null) {
                builder.append(output);
            }

            System.out.println(builder.toString());

            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        System.out.println("CRIAR DEVE CONECTAR NO SERVIDOR");;

        Material material = new Material();;
        material.setId(1);
        material.setNome("Material");
        material.ativar();
        materiais.add(material);
        return materiais;
    }

    public String criar(Material material) {
        try {
            URL url = new URL("http://localhost:8080/materials");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"name\":\"" + material.getNome() + "\"}";

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
        System.out.println("PROCURAR DEVE CONECTAR NO SERVIDOR");
        Material material = new Material();
        material.setId(1);
        material.setNome("Material");
        material.inativar();
        return material;
    }

    public String atualizar(int id, Material material) {
        System.out.println("ATUALIZAR DEVE CONECTAR NO SERVIDOR");
        return "";
    }

    public String excluir(int id) {
        System.out.println("EXCLUIR DEVE CONECTAR NO SERVIDOR");
        return "";
    }
    
}
