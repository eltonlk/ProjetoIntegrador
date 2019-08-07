/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import sources.Categoria;

/**
 *
 * @author nyko-
 */
public class CategoriasController {

    public ArrayList<Categoria> listar(String parametrosPesquisa) {
        System.out.println("CRIAR DEVE CONECTAR NO SERVIDOR");
        ArrayList<Categoria> categorias = new ArrayList<>();
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNome("Categoria");
        categoria.ativar();
        categorias.add(categoria);
        return categorias;
    }

    public String criar(Categoria categoria) {
        System.out.println("CRIAR DEVE CONECTAR NO SERVIDOR");
        return "";
    }

    public Categoria procurar(int categoriaId) {
        System.out.println("PROCURAR DEVE CONECTAR NO SERVIDOR");
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNome("Categoria");
        categoria.inativar();
        return categoria;
    }

    public String atualizar(int id, Categoria categoria) {
        System.out.println("ATUALIZAR DEVE CONECTAR NO SERVIDOR");
        return "";
    }

    public String excluir(int id) {
        System.out.println("EXCLUIR DEVE CONECTAR NO SERVIDOR");
        return "";
    }
    
}
