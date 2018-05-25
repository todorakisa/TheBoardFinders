package com.example.app.ServiceImpl;

import com.example.app.Config.Errors;
import com.example.app.Service.EventService;
import com.example.app.entity.Event;
import com.example.app.entity.User;
import com.example.app.model.RegistrationEvent;
import com.example.app.model.RegistrationModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private com.example.app.repository.EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EventServiceImpl() {
        super();
    }

    @Override
    public void register(RegistrationEvent registrationEvent) {
        Event event = this.modelMapper.map(registrationEvent, Event.class);
        String encryptedPassword = this.bCryptPasswordEncoder.encode(registrationEvent.getPassword());

        this.eventRepository.save(event);

    }

    public Event loadUserByUsername(String name) throws UsernameNotFoundException {
        Event event = this.eventRepository.findOneByUsername(name);

        if(event == null){
            throw new UsernameNotFoundException(Errors.INVALID_CREDENTIALS);
        }

        return event;
    }
}
