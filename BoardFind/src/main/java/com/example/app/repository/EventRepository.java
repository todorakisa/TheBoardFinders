package com.example.app.repository;
import com.example.app.entity.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findOneByName(String name);
    List<Event> findAll();
}
