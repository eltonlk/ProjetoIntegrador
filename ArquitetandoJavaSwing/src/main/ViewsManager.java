/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import resources.AuthenticateUser;
import views.main.ApplicationView;
import views.main.LoginView;

/**
 *
 * @author nyko-
 */
public class ViewsManager {

    private static final LoginView LOGIN_VIEW = buildLoginView();
    private static final ApplicationView APPLICATION_VIEW = buildApplicationView();

    public enum View {
        LOGIN,
        APPLICATION
    }

    private static LoginView buildLoginView() {
        LoginView view = new LoginView();
        view.setSize(new Dimension(600, 400));
        view.setResizable(false);
        view.setLocationRelativeTo(null);

        URL resource = view.getClass().getResource("/images/logo.png");
        Image image = Toolkit.getDefaultToolkit().getImage(resource);
        view.setIconImage(image);

        return view;
    }

    private static ApplicationView buildApplicationView() {
        ApplicationView view = new ApplicationView();
        view.setExtendedState(MAXIMIZED_BOTH);
        view.setMinimumSize(new Dimension(600, 400));
        view.setLocationRelativeTo(null);

        URL resource = view.getClass().getResource("/images/logo.png");
        Image image = Toolkit.getDefaultToolkit().getImage(resource);
        view.setIconImage(image);

        return view;
    }

    public static void showView(View view) {
        switch (view) {
            case LOGIN:
                LOGIN_VIEW.setVisible(true);
                APPLICATION_VIEW.setVisible(false);
                break;
            case APPLICATION:
                if (AuthenticateUser.isAuthenticated()) {
                    APPLICATION_VIEW.setVisible(true);
                    LOGIN_VIEW.setVisible(false);
                } else {
                    LOGIN_VIEW.setVisible(true);
                    APPLICATION_VIEW.setVisible(false);
                }
                break;
        }
    }
}
