package com.example.app.ServiceImpl;
import com.example.app.Repository.EventRepository;
import com.example.app.Service.EventService;
import com.example.app.entity.Event;
import com.example.app.model.RegistrationEvent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EventServiceImpl() {
        super();
    }

    @Override
    public void register(RegistrationEvent registrationEvent) {
        Event event = this.modelMapper.map(registrationEvent, Event.class);
        event.setGames(registrationEvent.getGames());
        event.setDescription(registrationEvent.getDescription());
        event.setLatitude(registrationEvent.getLatitude());
        event.setLongitude(registrationEvent.getLongitude());
        event.setName(registrationEvent.getName());
        event.setPlayers(registrationEvent.getPlayers());
        event.setDate(registrationEvent.getDate());
        this.eventRepository.save(event);
    }
}
