/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import sorces.Categoria;

/**
 *
 * @author nyko-
 */
public class CategoriasController {

    public ArrayList<Categoria> listar(String parametrosPesquisa) {
        ArrayList<Categoria> categorias = new ArrayList<>();
        
        for (int i = 0; i < 2; i++) {
            Categoria categoria = new Categoria();
            categoria.setId(i);
            categoria.setNome("Nome is " + i);
            categorias.add(categoria);            
        }
        
        return categorias;
    }
    
}
