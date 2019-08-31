/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author nyko-
 */
public class TableBuilder {
    
    public static void build(TableView table, ObservableList data, String[] headerTitles, String[] bodyProperties) {
        table.setItems(data);
        
        for (int i = 0; i < headerTitles.length; i++) {
            TableColumn titleCol = new TableColumn(headerTitles[i]);
            titleCol.setCellValueFactory(new PropertyValueFactory(bodyProperties[i]));
            
            table.getColumns().addAll(titleCol);
        }
        
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
}
