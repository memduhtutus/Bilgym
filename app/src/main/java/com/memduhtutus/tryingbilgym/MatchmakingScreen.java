package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MatchmakingScreen extends AppCompatActivity implements HandleEvent {
    static ArrayList<Event> events;
    public void MatchMakingScreen(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchmaking_screen);
    }
    public void availableEventsClicked(View view){
        Intent intent =  new Intent(MatchmakingScreen.this, AvailableEventScreen.class);
        startActivity(intent);
    }
    public void createNewEventClicked(View view){
        Intent intent =  new Intent(MatchmakingScreen.this, CreateEventScreen.class);
        startActivity(intent);
    }

    @Override
    public void createNewEvent(FirebaseUser u, Event e) {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        MainActivity ma = new MainActivity(db);
        String uid = FirebaseAuth.getInstance().getUid();
        ma.createEvent(0, e.getSportType(), e.getHour(), e.getQuota());
        events.add(e);

    }

    @Override
    public boolean joinEvent(User u, Event e) {
        if(e.getAlreadyJoined() < e.getQuota()){
            e.alreadyJoined++;
            u.joinedEvents.add(e);
            e.quota--;
            //buton join'den cancela çevrilecek
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelEventAppt(User u, Event e) {
        e.alreadyJoined--;
        u.joinedEvents.remove(e);
        e.quota--;
        return true;
    }
}