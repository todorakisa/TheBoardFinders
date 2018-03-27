package com.example.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
<<<<<<< HEAD
    public String index(){
        return "home/index";
=======
    public String index()
    {
        return "/home/index";
>>>>>>> 1dfbf674d45e21d5e1b92d6ad5d4eb285e341d05
    }
}
