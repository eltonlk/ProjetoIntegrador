/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import resources.AuthenticateUser;

/**
 *
 * @author nyko-
 */
public class ApiSessionController {

    public static boolean create(String login, String password) {
        return AuthenticateUser.authenticate(login, password);
    }
    
}
