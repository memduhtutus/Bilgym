package com.memduhtutus.tryingbilgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import com.memduhtutus.tryingbilgym.databinding.ActivityAvailableEventScreenBinding;
import com.memduhtutus.tryingbilgym.databinding.ActivityPersonalInfoScreenBinding;

public class AvailableEventScreen extends AppCompatActivity {
    private @NonNull ActivityAvailableEventScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_event_screen);
        binding = ActivityAvailableEventScreenBinding.inflate(getLayoutInflater());
    }

    public void showEventsClicked(View view){
        String eventText = "";
        for(int i=0; i < MatchmakingScreen.events.size(); i++){
            eventText += MatchmakingScreen.events.get(i).toMap();
            binding.availableEvents.setText(eventText);
        }
    }

}