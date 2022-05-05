package com.memduhtutus.tryingbilgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.memduhtutus.tryingbilgym.databinding.ActivityPersonalInfoScreenBinding;
import com.memduhtutus.tryingbilgym.databinding.ActivitySignUpScreenBinding;

public class PersonalInfoScreen extends AppCompatActivity {
    private FirebaseStorage firebaseStorage;
    private FirebaseAuth auth;
    private @NonNull ActivityPersonalInfoScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonalInfoScreenBinding.inflate(getLayoutInflater());

        firebaseStorage = FirebaseStorage.getInstance();
        auth = FirebaseAuth.getInstance();
    }

    public void doneClicked(View view){
        Intent intent = new Intent(PersonalInfoScreen.this, MainScreen.class);
        startActivity(intent);
        finish();
    }
}