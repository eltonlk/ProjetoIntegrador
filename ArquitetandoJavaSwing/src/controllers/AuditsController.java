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
import sources.Audit;

/**
 *
 * @author nyko-
 */
public class AuditsController {
    public ArrayList<Audit> list() {
        ArrayList<Audit> audits = new ArrayList<>();

        try {
            ArrayList<Audit> auditsObjects = (ArrayList<Audit>) new ApiConnection().getList("/audits", new GenericType<ArrayList<Audit>>() {
            });

            for (Audit auditObject : auditsObjects) {
                audits.add(auditObject);
            }
        } catch (MalformedURLException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return audits;
    }
}
