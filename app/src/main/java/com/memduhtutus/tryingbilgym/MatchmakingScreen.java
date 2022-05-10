package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;



public class MatchmakingScreen extends AppCompatActivity{
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
}