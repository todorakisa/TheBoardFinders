package com.example.app.Controllers;

import com.example.app.model.UserCreateRequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {

    @RequestMapping(value = "/users/register", method = RequestMethod.GET)
    public String register()
    {
        return "users/register";
    }

    @PostMapping("users/register")
    public String register(UserCreateRequestModel model){
        return "users/register";
    }
}
