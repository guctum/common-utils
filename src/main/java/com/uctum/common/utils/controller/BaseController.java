package com.uctum.common.utils.controller;

import com.uctum.common.utils.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    private JokeService jokeService;

    @RequestMapping("/")
    public String getIndex() {
        return "Welcome to Gr0g Industries.";
    }

    @RequestMapping("/joke")
    public String getJoke() {
        return jokeService.getJoke();
    }
}
