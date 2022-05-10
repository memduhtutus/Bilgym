package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CancelAppointmentScreen extends AppCompatActivity {
    RadioGroup radioGroupHours, radioGroupDays;
    RadioButton radioButtonHour, radioButtonDay;
    String txtHour, txtDay;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private HashMap<String, Object> mData;
    private FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_screen);
        radioGroupHours = findViewById(R.id.radioGroupHours);
        radioGroupDays = findViewById(R.id.radioGroupDays);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void buttonApplyHourClicked(View view){
        int radioId = radioGroupHours.getCheckedRadioButtonId();
        radioButtonHour = findViewById(radioId);
        Toast.makeText(CancelAppointmentScreen.this,
                "Selected Hour: " + radioButtonHour.getText(), Toast.LENGTH_SHORT).show();
    }

    public void buttonApplyDayClicked(View view){
        int radioId = radioGroupDays.getCheckedRadioButtonId();
        radioButtonDay = findViewById(radioId);
        Toast.makeText(CancelAppointmentScreen.this,
                "Selected Day: " + radioButtonDay.getText(), Toast.LENGTH_SHORT).show();
    }

    public void buttonCancelAppointmentClicked(View view){

        mUser = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference("Reservations").child(mUser.getUid());
        mDatabase.removeValue()
                .addOnCompleteListener(CancelAppointmentScreen.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(CancelAppointmentScreen.this, "Reservation is successfully deleted.", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(CancelAppointmentScreen.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        Intent intent = new Intent(CancelAppointmentScreen.this, MainScreen.class);
        startActivity(intent);
        finish();
    }
}