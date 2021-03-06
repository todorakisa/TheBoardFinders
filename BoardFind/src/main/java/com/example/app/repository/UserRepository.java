package com.example.app.repository;

import com.example.app.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUsername(String username);
    List<User> findAll();
}
