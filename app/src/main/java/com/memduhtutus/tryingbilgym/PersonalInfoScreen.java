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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.memduhtutus.tryingbilgym.databinding.ActivityCreateEventScreenBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;



public class PersonalInfoScreen extends AppCompatActivity {
    private EditText editAge, editGender, editHeight, editWeight;
    private String txtGender;
    private int txtAge, txtHeight, txtWeight;
    double txtBMI;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private HashMap<String, Object> mData;
    private FirebaseUser mUser;
    TextView textViewAge, textViewGender, textViewHeight, textViewWeight, textViewBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_screen);

        editAge = (EditText) findViewById(R.id.editTextUserAge);
        editGender = (EditText) findViewById(R.id.editTextUserGender);
        editHeight = (EditText) findViewById(R.id.editTextUserHeight);
        editWeight = (EditText) findViewById(R.id.editTextUserWeight);
        textViewAge = findViewById(R.id.textViewUserAge);
        textViewGender = findViewById(R.id.textViewUserGender);
        textViewHeight = findViewById(R.id.textViewUserHeight);
        textViewWeight = findViewById(R.id.textViewUserWeight);
        textViewBMI = findViewById((R.id.textViewUserBMI));
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

    }

    public void doneClicked(View view){

        txtAge = Integer.parseInt(editAge.getText().toString());
        txtGender = editGender.getText().toString();
        txtHeight = Integer.parseInt(editHeight.getText().toString());
        txtWeight = Integer.parseInt(editWeight.getText().toString());
        txtBMI = txtWeight / (((double) txtHeight/100) * ((double) txtHeight/100));

        mData = new HashMap();
        mUser = mAuth.getCurrentUser();
        mData.put("Your Age", txtAge);
        mData.put("Your Gender", txtGender);
        mData.put("Your Height", txtHeight);
        mData.put("Your Weight", txtWeight);
        mData.put("Your BMI", String.format("%.2f", txtBMI));

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
    public void buttonShowInfosClicked(View view){
        mUser = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference("Users' Personal Info");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String values;
                String[] valuesArr = new String[5];
                for(DataSnapshot snp : snapshot.getChildren()){
                    if(snp.getKey().equals(mUser.getUid())){
                        values = snp.getValue().toString();
                        valuesArr = values.split(",");
                    }
                }
                textViewAge.setText(valuesArr[0].substring(1));
                textViewGender.setText(valuesArr[1]);
                textViewHeight.setText(valuesArr[2]);
                textViewWeight.setText(valuesArr[3]);
                textViewBMI.setText(valuesArr[4].substring(0, valuesArr[4].length()-1));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(PersonalInfoScreen.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}