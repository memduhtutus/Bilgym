package com.memduhtutus.tryingbilgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Document;

import java.util.HashMap;

public class CreateEventScreen extends AppCompatActivity {
    private EditText editSportType, editAlreadyJoined, editPeopleLooking, editHour;
    private String txtSportType, txtHour;
    private int txtAlreadyJoined, txtPeopleLooking;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FirebaseUser mUser;
    private HashMap<String, Object> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_screen);
        editSportType = (EditText) findViewById(R.id.editTextEventSportType);
        editAlreadyJoined = (EditText) findViewById(R.id.editTextEventAlreadyJoined);
        editPeopleLooking = (EditText) findViewById(R.id.editTextEventQuota);
        editHour = (EditText) findViewById((R.id.editTextEventHour));
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void eventDoneClicked(View view){
        txtSportType = editSportType.getText().toString();
        txtAlreadyJoined = Integer.parseInt(editAlreadyJoined.getText().toString());
        txtPeopleLooking = Integer.parseInt(editPeopleLooking.getText().toString());
        txtHour = editHour.getText().toString();
        DatabaseHandler dh = new DatabaseHandler(mDatabase, mAuth);

        mData = new HashMap();
        mUser = dh.getmAuth().getCurrentUser();
        mData.put("Creator of this event", mUser.getEmail());
        mData.put("Number Of Joined People", txtAlreadyJoined);
        mData.put("Sport Type", txtSportType);
        mData.put("Hour", txtHour);
        mData.put("Left Quota", txtPeopleLooking);

        dh.getmDatabase().child("Events").child(mUser.getUid())
                .setValue(mData)
                .addOnCompleteListener(CreateEventScreen.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                            Toast.makeText(CreateEventScreen.this, "Event is successfully created.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(CreateEventScreen.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        Intent intent = new Intent(CreateEventScreen.this, MatchmakingScreen.class);
        startActivity(intent);
        finish();
    }
}