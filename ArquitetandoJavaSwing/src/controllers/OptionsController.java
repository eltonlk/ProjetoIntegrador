/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.owlike.genson.GenericType;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import resources.ApiConnection;
import resources.LogManager;
import sources.Option;

/**
 *
 * @author nyko-
 */
public class OptionsController {

    public ArrayList<Option> list() {
        ArrayList<Option> options = new ArrayList<>();

        try {
            ArrayList<Option> optionsObjects = (ArrayList<Option>) new ApiConnection().getList("/options", new GenericType<ArrayList<Option>>() {
            });

            for (Option option : optionsObjects) {
                options.add(option);
            }
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return options;
    }

    public String update(int id, Option option) {
        try {
            String json = optionToJson(option);

            new ApiConnection().put("/options/" + id, json);

            return "";
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel gravar a opção.";
    }

    private String optionToJson(Option option) {
        String json = "{ \"name\":\"" + option.getName() + "\""
                + ", \"value\":\"" + option.getValue() + "\""
                + "}";

        return json;
    }

}
