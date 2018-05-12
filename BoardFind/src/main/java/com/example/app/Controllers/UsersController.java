package com.example.app.Controllers;

import com.example.app.model.view.UserCreateRequestModel;
import com.example.app.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/users/register", method = RequestMethod.GET)
    public String register(Model model)
    {
        model.addAttribute("viewModel",new UserCreateRequestModel());
        return "users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String register(UserCreateRequestModel viewModel,Model model){
        //it's ok
        if(this.userService.register(viewModel.getUsername(), viewModel.getPassword(), viewModel.getEmail()))
            return "users/login"; //redirect:/
        //errors
        model.addAttribute("viewModel",viewModel);
        return "users/register";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelandview)
    {
            modelandview.setViewName("/users/login");
           // modelandview.addObject("viewModel",new EventCreateRequestModel());
            return modelandview;
    }
}
