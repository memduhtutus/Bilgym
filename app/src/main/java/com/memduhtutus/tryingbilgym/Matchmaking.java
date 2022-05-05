package com.memduhtutus.tryingbilgym;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Matchmaking implements HandleEvent {
    ArrayList<Event> events;

    Matchmaking(ArrayList<Event> events){
        this.events = events;
    }

    @Override
    public void createNewEvent(User u, Event e) {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        MainActivity ma = new MainActivity(db);
        ma.createEvent(0, e.getName(), e.getSportType(), e.getHour(), e.getQuota(), u);
        events.add(e);
    }

    @Override
    public boolean joinEvent(User u, Event e) {
        if(e.getAlreadyJoined() < e.getQuota()){
            e.alreadyJoined++;
            u.joinedEvents.add(e);
            //buton join'den cancela çevrilecek
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelEventAppt(User u, Event e) {
        e.alreadyJoined--;
        u.joinedEvents.remove(e);
        return true;
    }
}
