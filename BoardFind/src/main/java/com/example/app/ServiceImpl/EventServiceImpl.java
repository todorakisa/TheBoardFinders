package com.example.app.ServiceImpl;
import com.example.app.Config.Errors;
import com.example.app.entity.User;
import com.example.app.repository.EventRepository;
import com.example.app.repository.UserRepository;
import com.example.app.Service.EventService;
import com.example.app.entity.Event;
import com.example.app.model.RegistrationEvent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EventServiceImpl() {
        super();
    }

    @Override
    public void register(RegistrationEvent registrationEvent) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Event event = this.modelMapper.map(registrationEvent, Event.class);
        event.setGames(registrationEvent.getGamesToParse());
        event.setDescription(registrationEvent.getDescription());
        event.setLatitude(registrationEvent.getLatitude());
        event.setLongitude(registrationEvent.getLongitude());
        event.setName(registrationEvent.getName());
        event.setPlayers(registrationEvent.getPlayers());
        event.setDate(registrationEvent.getDate());
        System.out.println(name);
        event.setOwner(this.userRepository.findOneByUsername(name));
        this.eventRepository.save(event);
    }

}
