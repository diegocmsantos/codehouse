package com.clearbases.codehouse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by diego on 6/16/17.
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String loginForm(){
        return "loginForm";
    }

}
