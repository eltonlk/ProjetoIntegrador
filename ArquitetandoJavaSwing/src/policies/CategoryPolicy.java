/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package policies;

/**
 *
 * @author nicolas
 */
public class CategoryPolicy {

    public static boolean canRead() {
        return true;
    }

    public static boolean canSearch() {
        return true;
    }

    public static boolean canNew() {
        return true;
    }

    public static boolean canEdit() {
        return true;
    }

    public static boolean canDestroy() {
        return true;
    }  
    
}
