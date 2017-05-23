package com.clearbases.codehouse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by diego on 5/10/17.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        System.out.println("Entrando na home da casa do codigo");
        return "home";
    }
}
