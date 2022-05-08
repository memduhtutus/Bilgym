package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.view.View.OnClickListener;

import java.util.HashMap;
import java.util.Map;

public class GetAppointmentScreen extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    String txtHour;
    private Button buttonApply;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private HashMap<String, Object> mData;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_appointment_screen);
        radioGroup = findViewById(R.id.radioGroupHours);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        /*buttonApply = findViewById(R.id.buttonApplyHour);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                Toast.makeText(GetAppointmentScreen.this,
                        "Selected Hour: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public void buttonApplyHourClicked(View view){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(GetAppointmentScreen.this,
                "Selected Hour: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    public void buttonGetAppointmentClicked(View view){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        txtHour = radioButton.getText().toString();
        mData = new HashMap();
        mUser = mAuth.getCurrentUser();
        mData.put("User:", mUser.getUid());

        mDatabase.child("Reservations").child(txtHour)
                .setValue(mData)
                .addOnCompleteListener(GetAppointmentScreen.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                            Toast.makeText(GetAppointmentScreen.this, "Appointment is successfully created.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(GetAppointmentScreen.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /*public void addListenerOnButton() {
        btnDisplay = (Button) findViewById(R.id.buttonApplyHour);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(GetAppointmentScreen.this,
                        "Selected Hour: " + radioButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });
    }*/
}