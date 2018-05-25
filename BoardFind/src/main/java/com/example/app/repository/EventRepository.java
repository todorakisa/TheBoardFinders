package com.example.app.repository;

import com.example.app.entity.Event;
import com.example.app.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findOneByUsername(String username);
    List<Event> findAll();
}
