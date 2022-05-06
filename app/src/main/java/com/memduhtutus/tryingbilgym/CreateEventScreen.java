package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.memduhtutus.tryingbilgym.databinding.ActivityCreateEventScreenBinding;

public class CreateEventScreen extends AppCompatActivity {
    private ActivityCreateEventScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_screen);
    }

    public void eventDoneClicked(View view){
        String sportType = binding.editTextEventSportType.getText().toString();
        int alreadyJoined = Integer.parseInt(binding.editTextEventAlreadyJoined.getText().toString());
        int peopleLooking = Integer.parseInt(binding.editTextEventQuota.getText().toString());
        String hour = binding.editTextEventHour.getText().toString();

        matchmakingHour mh = new matchmakingHour(hour);
        MatchmakingScreen ms = new MatchmakingScreen();
        FirebaseUser u = FirebaseAuth.getInstance().getCurrentUser();
        Event e = new Event(alreadyJoined, sportType, mh, peopleLooking);
        ms.createNewEvent(u, e);
        MatchmakingScreen.events.add(e);
    }
}