/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

/**
 *
 * @author nyko-
 */
public class AuthenticateUser {

    private static boolean authenticated;

    public static boolean authenticate(String login, String password) {
        authenticated = "admin".equals(login) && "admin".equals(password);

        return authenticated;
    }

    public static boolean isAuthenticated() {
        return authenticated;
    }

}
