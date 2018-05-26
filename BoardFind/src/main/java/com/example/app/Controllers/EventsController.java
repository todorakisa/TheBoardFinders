package com.example.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventsController {
    @RequestMapping(value = "/eventsAndPeople", method = RequestMethod.GET)
    public String getEventsAndPeoplePage(){
        return "home/eventsAndPeople";
    }
}
