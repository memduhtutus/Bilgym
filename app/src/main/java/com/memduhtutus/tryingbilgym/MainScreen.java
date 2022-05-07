package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainScreen extends AppCompatActivity {
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        auth = FirebaseAuth.getInstance();
    }
    public void gymAppoClicked(View view){

        Intent intent = new Intent(MainScreen.this, GymAppointmentScreen.class);
        startActivity(intent);
    }

    public void persProgClicked(View view){
        Intent intent = new Intent(MainScreen.this, PersonalTrainerScreen.class);
        startActivity(intent);
    }
    public void matchmakingClicked(View view){
        Intent intent = new Intent(MainScreen.this, MatchmakingScreen.class);
        startActivity(intent);
    }
    public void aboutUsClicked(View view){

        Intent intent = new Intent(MainScreen.this, AboutUs.class);
        startActivity(intent);

    }
    public void setButtonClicked(View view){

        Intent intent = new Intent(MainScreen.this, SetScreen.class);
        startActivity(intent);

    }
    public void logOutClicked (View view){
        Intent intent = new Intent(MainScreen.this,WelcomeScreen.class);
        startActivity(intent);
        finish();

    }
}