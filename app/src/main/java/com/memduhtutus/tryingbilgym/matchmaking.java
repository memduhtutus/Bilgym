package com.memduhtutus.tryingbilgym;


import java.util.ArrayList;

public class matchmaking implements HandleEvent {
    ArrayList<Event> events;

    matchmaking(ArrayList<Event> events){
        this.events = events;
    }
}
