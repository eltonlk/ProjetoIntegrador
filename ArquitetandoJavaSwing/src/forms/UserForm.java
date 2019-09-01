/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import controllers.UsersController;
import javax.swing.JOptionPane;
import sources.User;
import views.main.ApplicationView;

/**
 *
 * @author nyko-
 */
public class UserForm {

    private final User user;
    private final String action;

    public UserForm(int id) {
        this.action = "update";
        this.user = new UsersController().find(id);
    }

    public UserForm() {
        this.action = "create";
        this.user = new User();
    }

    public String getName() {
        return this.user.getName();
    }

    public String getEmail() {
        return this.user.getEmail();
    }

    public String getUsername() {
        return this.user.getUsername();
    }

    public boolean isActive() {
        return this.user.isActive();
    }

    public boolean isInactive() {
        return this.user.isInactive();
    }

    public void save(String name, String email, String username, String password, String repeatPassword, boolean active) {
        String errors = null;

        if ("create".equals(this.action)) {
            if (password == null || password.isEmpty()) {
                errors = "Senha não pode ficar em branco.";
            } else if (!password.equals(repeatPassword)) {
                errors = "Confimação da senha não é igual a senha.";
            }
        }

        if (errors == null || errors.isEmpty()) {
            User newUser = new User();
            newUser.setName(name);
            newUser.setEmail(email);
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setActive(active);

            if ("update".equals(this.action)) {
                errors = new UsersController().update(this.user.getId(), newUser);
            } else {
                errors = new UsersController().create(newUser);
            }
        }

        if (errors == null || errors.isEmpty()) {
            goBackToList();
        } else {
            JOptionPane.showMessageDialog(null, errors);
        }
    }

    public void cancel() {
        goBackToList();
    }

    private void goBackToList() {
        views.users.List frame = new views.users.List();
        ApplicationView.changeInternalFrame(frame);
    }

}
