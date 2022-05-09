package com.memduhtutus.tryingbilgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.view.View;

public class AvailableEventScreen extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FirebaseUser mUser;
    private TextView txtAvailableEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_event_screen);
        mAuth = FirebaseAuth.getInstance();
    }

    public void showEventsClicked(View view){
        mUser = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference("Events");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String result = "";
                txtAvailableEvents = findViewById(R.id.textViewAvailableEvents);
                for(DataSnapshot snp : snapshot.getChildren()){
                    result += snp.getKey() + "\n";
                    String values = snp.getValue().toString();
                    String[] valuesArr = values.split(",");

                    for(String val : valuesArr){
                        result += val + "\n";
                    }
                }
                txtAvailableEvents.setText(result);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AvailableEventScreen.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}