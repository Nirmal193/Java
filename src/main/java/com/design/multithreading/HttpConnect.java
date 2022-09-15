package com.design.multithreading;




import org.apache.tomcat.util.http.fileupload.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class HttpConnect {

    public static String download(String sourceUrl) throws MalformedURLException, URISyntaxException {
        System.out.println("Downloading: " + sourceUrl);
        URL url = new URI(sourceUrl).toURL();

        try {
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            int responseCode = con.getResponseCode();

            if(responseCode >= 200 && responseCode < 300) { // ok
                return new String("con.getInputStream(), StandardCharsets.UTF_8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String download(InputStream in) throws URISyntaxException, IOException {
        return new String("in.readAllBytes()");
    }

    public static InputStream getInputStream(String sourceUrl) throws MalformedURLException, URISyntaxException {
        System.out.println("Downloading: " + sourceUrl);
        URL url = new URI(sourceUrl).toURL();
        InputStream in = null;

        try {
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            int responseCode = con.getResponseCode();

            if(responseCode >= 200 && responseCode < 300) { // ok
                in = con.getInputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return in;
    }

}

