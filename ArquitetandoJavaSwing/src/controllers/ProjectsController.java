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
import sources.Project;

/**
 *
 * @author nyko-
 */
public class ProjectsController {

    public ArrayList<Project> list() {
        ArrayList<Project> projects = new ArrayList<>();

        try {
            projects = (ArrayList<Project>) new ApiConnection().getList("/projects", new GenericType<ArrayList<Project>>() {
            });
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return projects;
    }

    public Project find(int id) {
        Project project = null;

        try {
            project = (Project) new ApiConnection().get("/projects/" + id, Project.class);
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return project;
    }

    public String create(Project project) {
        try {
            String json = projectToJson(project);

            new ApiConnection().post("/projects", json);

            return "";
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel gravar o projeto.";
    }

    public String update(int id, Project project) {
        try {
            String json = projectToJson(project);

            new ApiConnection().put("/projects/" + id, json);

            return "";
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel gravar o projeto.";
    }

    public String delete(int id) {
        try {
            new ApiConnection().delete("/projects/" + id);

            return "";
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return "Não foi possivel excluir o projeto";
    }

    private String projectToJson(Project project) {
        String json = "{\"name\":\"" + project.getName() + "\""
                + "}";

        return json;
    }
}
