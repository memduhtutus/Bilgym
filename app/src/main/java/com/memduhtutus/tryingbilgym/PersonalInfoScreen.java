package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PersonalInfoScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_screen);
    }

    public void doneClicked(View view){

        Intent intent = new Intent(PersonalInfoScreen.this, MainScreen.class);
        startActivity(intent);
        finish();
    }
}