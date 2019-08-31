/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import sources.User;

/**
 *
 * @author nyko-
 */
public class UsersController {

    public static List listAll() {
        List list = new ArrayList();
        
        list.add(new User(1, "Thief", "thief"));
        list.add(new User(2, "Somerset", "somerset"));
        list.add(new User(3, "Pretto", "prettinho"));
        list.add(new User(4, "I Am Ok You Are Ok", "_a_a_a_"));
        
        return list;
    }
    
}
