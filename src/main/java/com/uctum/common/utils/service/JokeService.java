package com.uctum.common.utils.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@Slf4j
public class JokeService {
    private Logger logger = LoggerFactory.getLogger(Slf4j.class);

    public String getJoke() {
        StringBuilder joke = new StringBuilder();
        try {
            String url = "https://icanhazdadjoke.com";
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Discord bot for jokes");
            connection.setRequestProperty("Accept", "text/plain");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = bufferedReader.readLine()) != null) {
                joke.append(inputLine);
            }

            bufferedReader.close();
        } catch (IOException e) {
            log.debug(e.getLocalizedMessage());
//            e.getLocalizedMessage();
        }
        log.debug(joke.toString());
        return joke.toString();
    }
}
