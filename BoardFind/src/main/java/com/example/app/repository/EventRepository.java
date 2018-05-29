package com.example.app.repository;
import com.example.app.entity.Event;
import com.example.app.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findOneByNameIgnoreCase(String name);
    List<Event> findAll();
}
