/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.owlike.genson.GenericType;
import java.util.ArrayList;
import resources.ApiConnection;
import resources.LogManager;
import sources.User;

/**
 *
 * @author nyko-
 */
public class UsersController {

    public ArrayList<User> list() {
        ArrayList<User> users = new ArrayList<>();

        try {
            users = (ArrayList<User>) new ApiConnection().getList("/users", new GenericType<ArrayList<User>>() {
            });
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return users;
    }

    public User find(int id) {
        User user = null;

        try {
            user = (User) new ApiConnection().get("/users/" + id, User.class);
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return user;
    }

    public String create(User user) {
        try {
            String input = "{\"name\":\"" + user.getName() + "\""
                    + ", \"email\":\"" + user.getEmail() + "\""
                    + ", \"username\":\"" + user.getUsername() + "\""
                    + ", \"password\":\"" + user.getPassword() + "\""
                    + ", \"active\":\"" + user.isActive() + "\""
                    + "}";

            new ApiConnection().post("/users", input);

            return "";
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel gravar o usuário.";
    }

    public String update(int id, User user) {
        try {
            String input = "{\"name\":\"" + user.getName() + "\""
                    + ", \"email\":\"" + user.getEmail() + "\""
                    + ", \"username\":\"" + user.getUsername() + "\""
                    + ", \"active\":\"" + user.isActive() + "\""
                    + "}";

            new ApiConnection().put("/users/" + id, input);

            return "";
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel gravar o usuário.";
    }

    public String delete(int id) {
        try {
            new ApiConnection().delete("/users/" + id);

            return "";
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel excluir o usuário";
    }
}
