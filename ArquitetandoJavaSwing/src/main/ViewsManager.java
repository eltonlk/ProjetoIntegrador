/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import resources.AuthenticateUser;
import views.main.ApplicationView;
import views.main.LoginView;

/**
 *
 * @author nyko-
 */
public class ViewsManager {
    
    private static final LoginView loginView = new LoginView();
    private static final ApplicationView applicationView = new ApplicationView();

    public enum View {
        LOGIN,
        APPLICATION
    }    

    public static void showView(View view) {
        switch (view) {
            case LOGIN:
                loginView.setVisible(true);
                applicationView.setVisible(false);
                break;
            case APPLICATION:
                if (AuthenticateUser.isAuthenticated()) {
                    applicationView.setVisible(true);
                    loginView.setVisible(false);
                } else {
                    loginView.setVisible(true);
                    applicationView.setVisible(false);
                }
                break;
        }
    }
}
