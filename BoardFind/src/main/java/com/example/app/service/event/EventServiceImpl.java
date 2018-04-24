package com.example.app.service.event;

import com.example.app.model.entity.Event;
import com.example.app.model.entity.User;
import com.example.app.repository.EventRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.user.UserService;

import java.time.LocalDate;
import java.util.Date;

public class EventServiceImpl implements EventService{
        private final EventRepository eventRepository;

        public EventServiceImpl(EventRepository eventRepository) {
            this.eventRepository = eventRepository;
        }

        @Override
        public boolean create_event(Date date, String description, String location, String name, LocalDate release)
        {
            Event event = new Event();
            event.setDate(date);
            event.setDescription(description);
            event.setLocation(location);
            event.setName(name);
            event.setReleaseOn(release);

            return this.eventRepository.save(event).getId() != null;
    }
}
