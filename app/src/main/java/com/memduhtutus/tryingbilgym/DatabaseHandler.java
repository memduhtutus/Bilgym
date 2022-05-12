package com.memduhtutus.tryingbilgym;
import android.text.method.ScrollingMovementMethod;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class DatabaseHandler {
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String eventInfos;

    public DatabaseHandler(DatabaseReference dr, FirebaseAuth fa){
        mDatabase = dr;
        mAuth = fa;
    }

    public DatabaseReference getmDatabase() {
        return mDatabase;
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    // We tried to use this method but somehow it did not work.
    // So we only used DatabaseHandler class with its constructor and objects.
    public String getEventInfos() {
        mDatabase = FirebaseDatabase.getInstance().getReference("Events");
        this.getmDatabase().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                eventInfos = "";
                int i = 1;
                for(DataSnapshot snp : snapshot.getChildren()){
                    eventInfos += "          " + "Event " + i + "\n";
                    String values = snp.getValue().toString();
                    String[] valuesArr = values.split(",");

                    for(String val : valuesArr){
                        eventInfos += "          " + val + "\n";
                    }
                    i++;
                    eventInfos += "\n\n";
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return eventInfos;
    }
}
