package com.example.app.Controllers;
import com.example.app.Service.UserService;
import com.example.app.model.RegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;


   @GetMapping("/register")
    public String getRegisterPage(@ModelAttribute RegistrationModel registrationModel){
       return "users/register";
   }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute RegistrationModel registrationModel, BindingResult bindingResult){
       if(bindingResult.hasErrors()) {
           return "users/register";
       }

       this.userService.register(registrationModel);

       return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "users/login";
    }

}
