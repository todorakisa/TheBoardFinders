package com.example.app.service.event;

import java.time.LocalDate;
import java.util.Date;

public interface EventService {
    boolean create_event(Date date, String description, String location, String name, LocalDate release);
}
