package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GymAppointmentScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_appointment_screen);
    }
    public void getAppointmentClicked(View view){
        Intent intent = new Intent(GymAppointmentScreen.this, GetAppointmentScreen.class);
        startActivity(intent);
    }
    public void cancelAppointmentClicked(View view){
        Intent intent = new Intent(GymAppointmentScreen.this, GetAppointmentScreen.class);
        startActivity(intent);
    }
}