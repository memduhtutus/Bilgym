package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class AvailableEventScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_event_screen);
    }

    public void AvailableEventsClicked(View view){
        for(int i=0; i < MatchmakingScreen.events.size(); i++){
            MatchmakingScreen.events.get(i).toMap();
        }
    }

}