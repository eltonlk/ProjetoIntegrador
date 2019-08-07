/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import sources.Material;

/**
 *
 * @author nyko-
 */
public class MateriaisController {

    public ArrayList<Material> listar(String parametrosPesquisa) {
        System.out.println("CRIAR DEVE CONECTAR NO SERVIDOR");
        ArrayList<Material> materiais = new ArrayList<>();
        Material material = new Material();
        material.setId(1);
        material.setNome("Material");
        material.ativar();
        materiais.add(material);
        return materiais;
    }

    public String criar(Material material) {
        System.out.println("CRIAR DEVE CONECTAR NO SERVIDOR");
        return "";
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
