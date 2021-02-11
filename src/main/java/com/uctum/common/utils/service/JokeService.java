package com.uctum.common.utils.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class JokeService {
    private Logger logger = LoggerFactory.getLogger(Slf4j.class);

    public String getJoke() {
        StringBuilder joke = new StringBuilder();
        try {
            String url = "https://icanhazdadjoke.com";
            UtilsService.getFromUrl(joke, url);
        } catch (IOException e) {
            log.debug(e.getLocalizedMessage());
//            e.getLocalizedMessage();
        }
        log.debug(joke.toString());
        return joke.toString();
    }

    public String getJoke(String searchParam) {
        StringBuilder joke = new StringBuilder();
        try {
            String url = "https://icanhazdadjoke.com/search?term=" + searchParam + "&page=1&limit=1";
            UtilsService.getFromUrl(joke, url);
        } catch (IOException e) {
            log.debug(e.getLocalizedMessage());
//            e.getLocalizedMessage();
        }
        log.debug(joke.toString());
        return joke.toString();
    }
}
