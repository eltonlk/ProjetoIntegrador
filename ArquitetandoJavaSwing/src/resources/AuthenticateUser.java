/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author nyko-
 */
public class AuthenticateUser {

    private static String token;

    public static boolean authenticate(String login, String password) {
        try {
            String input = "{ \"username\":\"" + login + "\", \"password\":\"" + password + "\" }";

            URL url = new URL(ApiConnection.HOST + "/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            StringBuilder builder = new StringBuilder();

            while ((output = br.readLine()) != null) {
                builder.append(output);
            }

            token = builder.toString();

            conn.disconnect();
        } catch (ProtocolException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (IOException ex) {
            LogManager.doLog(ex.getMessage());
        } catch (Exception ex) {
            LogManager.doLog(ex.getMessage());
        }

        return isAuthenticated();
    }

    public static boolean isAuthenticated() {
        return token != null && token.length() > 0;
    }

    public static String getToken() {
        return AuthenticateUser.token;
    }
}
