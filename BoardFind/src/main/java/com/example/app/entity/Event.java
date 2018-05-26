package com.example.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @OneToMany(targetEntity = Event.class, mappedBy="name", fetch=FetchType.EAGER)
    private List<String> games;
    @OneToMany(targetEntity = Event.class, mappedBy="name", fetch=FetchType.EAGER)
    private List<User> players;
    private double latitude;
    private double longitude;
    private String description;
    private User owner;

    public User getOwner(){
        return owner;
    }
    public void setOwner(User owner){
        this.owner = owner;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public double getLatitude(){
        return latitude;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLongitude(){
        return longitude;
    }
    public void setLongitude( double longitude){
        this.longitude = longitude;
    }

    public String getName(){
        return name;
    }
    public void setName( String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getGames() {
        return games;
    }

    public void setGames(List<String> games) {
        this.games = games;
    }

    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }

}
