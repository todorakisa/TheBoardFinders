package com.example.app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @ElementCollection
    @CollectionTable(name = "games_at_event", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "games")
    private List<String> games = new ArrayList<>();

    @ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "event_users",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> players = new HashSet<>();

    private double latitude;
    private double longitude;
    private String description;
    private String date;
    private User owner;
    private String gamesToParse;
    private String usersToParse;


    public String getGamesToParse() {
        return gamesToParse;
    }

    public void setGamesToParse(String gamesToParse) {
        this.gamesToParse = gamesToParse;
    }

    public String getUsersToParse() {
        return usersToParse;
    }

    public void setUsersToParse(String usersToParse) {
        this.usersToParse = usersToParse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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

    public void setGames(String gamesData) {
        String[] array = gamesData.split(",");
        for (String g:array) {
            this.games.add(g);
        }
    }

    public Set<User> getPlayers() {
        return players;
    }

    public void setPlayers(String playersData) {
        String[] array = playersData.split(",");
        for (String p:array) {
            User user = new User();
            user.setEmail(p);
            this.players.add(user);
        }
    }

}
