/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author nyko-
 */
public class LogManager {

    private static final Logger logger = Logger.getLogger("Arquitetando");

    public static void doLog(String message) {
        try {
            FileHandler fileHandler = new FileHandler("Arquitetando.log", true);

            logger.addHandler(fileHandler);

            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            logger.warning(message);
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(LogManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
