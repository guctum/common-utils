package com.uctum.common.utils.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ChuckService {
    public String getChuckNorrisFact() {
        StringBuilder fact = new StringBuilder();
        try {
            String url = "https://api.chucknorris.io/jokes/random";
            UtilsService.getFromUrl(fact, url);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return fact.toString();
    }
}
