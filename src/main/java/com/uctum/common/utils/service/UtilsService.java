package com.uctum.common.utils.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UtilsService {
    static void getFromUrl(StringBuilder searchObject, String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "grog industries");
        connection.setRequestProperty("Accept", "text/plain");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;

        while ((inputLine = bufferedReader.readLine()) != null) {
            searchObject.append(inputLine);
        }

        bufferedReader.close();
    }
}
