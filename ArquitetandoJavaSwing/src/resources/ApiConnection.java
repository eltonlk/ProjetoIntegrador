/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author nyko-
 */
public class ApiConnection {

//    public static final String HOST = "http://localhost:8080";;
    public static final String HOST = "https://eltonlk-projeto-integrador.herokuapp.com";

    /**
     *
     * @param path
     * @param genericType
     * @return
     * @throws java.net.MalformedURLException
     * @throws java.net.ProtocolException
     * * @throws IOException
     */
    public Object getList(String path, GenericType genericType) throws MalformedURLException, ProtocolException, IOException {
        URL url = new URL(HOST + path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", AuthenticateUser.getToken());

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        StringBuilder builder = new StringBuilder();

        while ((output = br.readLine()) != null) {
            builder.append(output);
        }

        Object deserialize = new Genson().deserialize(builder.toString(), genericType);

        conn.disconnect();

        return deserialize;
    }

    /**
     *
     * @param path
     * @param objectClass
     * @return
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException
     */
    public Object get(String path, Class objectClass) throws MalformedURLException, ProtocolException, IOException {
        URL url = new URL(HOST + path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", AuthenticateUser.getToken());

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        StringBuilder builder = new StringBuilder();

        while ((output = br.readLine()) != null) {
            builder.append(output);
        }

        Object deserialize = new Genson().deserialize(builder.toString(), objectClass);

        conn.disconnect();

        return deserialize;
    }

    /**
     *
     * @param path
     * @param json
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException
     */
    public void post(String path, String json) throws MalformedURLException, ProtocolException, IOException {
        URL url = new URL(HOST + path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", AuthenticateUser.getToken());

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes());
        os.flush();

        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        conn.disconnect();
    }

    /**
     *
     * @param path
     * @param json
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException
     */
    public void put(String path, String json) throws MalformedURLException, ProtocolException, IOException {
        URL url = new URL(HOST + path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", AuthenticateUser.getToken());

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes());
        os.flush();

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        conn.disconnect();
    }

    /**
     *
     * @param path
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException
     */
    public void delete(String path) throws MalformedURLException, ProtocolException, IOException {
        URL url = new URL(HOST + path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("DELETE");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", AuthenticateUser.getToken());

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        conn.disconnect();
    }

}
