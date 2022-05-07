package com.memduhtutus.tryingbilgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.memduhtutus.tryingbilgym.databinding.ActivityCreateEventScreenBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;



public class PersonalInfoScreen extends AppCompatActivity {
    private EditText editAge, editGender, editHeight, editWeight;
    private String txtGender;
    private int txtAge, txtHeight, txtWeight;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private HashMap<String, Object> mData;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_screen);

        editAge = (EditText) findViewById(R.id.editTextUserAge);
        editGender = (EditText) findViewById(R.id.editTextUserGender);
        editHeight = (EditText) findViewById(R.id.editTextUserHeight);
        editWeight = (EditText) findViewById(R.id.editTextUserWeight);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

    }

    public void doneClicked(View view){
        Intent intent = new Intent(PersonalInfoScreen.this, MainScreen.class);
        startActivity(intent);
        finish();

        txtAge = Integer.parseInt(editAge.getText().toString());
        txtGender = editGender.getText().toString();
        txtHeight = Integer.parseInt(editHeight.getText().toString());
        txtWeight = Integer.parseInt(editWeight.getText().toString());

        mData = new HashMap();
        mUser = mAuth.getCurrentUser();
        mData.put("User's Age", txtAge);
        mData.put("User's Gender", txtGender);
        mData.put("User's Height", txtHeight);
        mData.put("User's Weight", txtWeight);

        mDatabase.child("Users' Personal Info").child(mUser.getUid())
                .setValue(mData)
                .addOnCompleteListener(PersonalInfoScreen.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                            Toast.makeText(PersonalInfoScreen.this, "Personal info are successfully updated.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(PersonalInfoScreen.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}