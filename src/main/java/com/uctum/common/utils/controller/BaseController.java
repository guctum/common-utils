package com.uctum.common.utils.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @RequestMapping("/")
    public String getIndex() {
        return "Welcome to Gr0g Industries.";
    }
}
