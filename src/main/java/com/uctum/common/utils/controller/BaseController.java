package com.uctum.common.utils.controller;

import com.uctum.common.utils.service.ChuckService;
import com.uctum.common.utils.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    private JokeService jokeService;

    @Autowired
    private ChuckService chuckService;

    @RequestMapping("/")
    public String getIndex() {
        return "Welcome to Gr0g Industries.";
    }

    @RequestMapping("/joke")
    public String getJoke() {
        return jokeService.getJoke();
    }

    @RequestMapping("/chuck")
    public String getChuckNorrisFact() {
        return chuckService.getChuckNorrisFact();
    }
}
