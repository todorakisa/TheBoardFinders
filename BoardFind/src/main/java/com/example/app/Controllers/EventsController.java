package com.example.app.Controllers;

import com.example.app.model.view.EventCreateRequestModel;
import com.example.app.service.event.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventsController {
    private final EventService eventsService;

    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String create_event(Model model)
    {
        model.addAttribute("viewModel",new EventCreateRequestModel());
        return "events/create_event";
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public String create_event(EventCreateRequestModel viewModel,Model model){

        if(this.eventService.create_event(viewModel.getDate(), viewModel.getDescription(), viewModel.getLocation(), viewModel.getName(), viewModel.getReleaseOn()))
            return "events_list";
        model.addAttribute("viewModel",viewModel);
        return "events/create_event";
    }
}