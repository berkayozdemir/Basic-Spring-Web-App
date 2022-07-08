package com.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @RequestMapping(value = {"","/","/login"},method = {RequestMethod.GET, RequestMethod.POST})
    public String displayLogin(@RequestParam(value = "error", required = false) String error, Model model) {

        String errorMessage = null;
        if(error != null) {
            errorMessage = "Username or Password is incorrect !!";
        }

    return "login.html";
}

}
