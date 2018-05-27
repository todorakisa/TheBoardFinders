package com.example.app.Controllers;

import com.example.app.Service.EventService;
import com.example.app.model.RegistrationEvent;
import com.example.app.model.RegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class EventsController {

    @Autowired
    private EventService eventService;

    @GetMapping("/registerEvent")
    public String getRegisterPage(@ModelAttribute RegistrationEvent registrationEvent){
            return "events/registerEvent";
    }

    @PostMapping("/registerEvent")
    public String registerUser(@Valid @ModelAttribute RegistrationEvent registrationEvent){
        this.eventService.register(registrationEvent);
        return "/events/registerEvent";
    }

    @RequestMapping(value = "/eventsAndPeople", method = RequestMethod.GET)
    public String getEventsAndPeoplePage(){
        return "home/eventsAndPeople";
    }
}
