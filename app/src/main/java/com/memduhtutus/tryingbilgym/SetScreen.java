package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class SetScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_screen);

    }
    public void setBodyInfoClicked(View view){
        Intent intent = new Intent(SetScreen.this, PersonalInfoScreen.class);
        startActivity(intent);
        finish();
    }

    public void setPasswordClicked(View view){
        Intent intent = new Intent(SetScreen.this, SettingPassword.class);
        startActivity(intent);
        finish();
    }
}