package com.example.app.model;

import com.example.app.Annotations.isPasswordMatching;
import com.example.app.entity.Event;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@isPasswordMatching
public class RegistrationModel {

    @Size(min = 5, max = 100, message = "Username too short")
    private String username;

    @Size(min = 5, max = 150, message = "Password too short")
    private String password;

    private String confirmed_password;
    private String email;
    private Set<Event> events = new HashSet<>();

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmed_password() {
        return confirmed_password;
    }

    public void setConfirmed_password(String confirmed_password) {
        this.confirmed_password = confirmed_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
