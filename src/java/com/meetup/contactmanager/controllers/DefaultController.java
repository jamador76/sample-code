package com.meetup.contactmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(ModelMap map) {
        return "index";
    }
}