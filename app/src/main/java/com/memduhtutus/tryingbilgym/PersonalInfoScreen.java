package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.memduhtutus.tryingbilgym.databinding.ActivityPersonalInfoScreenBinding;


public class PersonalInfoScreen extends AppCompatActivity {
    EditText editTextAge,editTextGender,editTextHeight,editTextWeight;


    TextView textView1,textView2,textView3,textView4;

    ActivityPersonalInfoScreenBinding binding;
    SharedPreferences sharedPreferences;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = binding.getRoot();
        setContentView(view);
        binding = ActivityPersonalInfoScreenBinding.inflate(getLayoutInflater());
        auth = FirebaseAuth.getInstance();

        editTextAge = binding.editTextAge; //editTextTextPersonName8
        editTextGender = binding.editTextGender;
        editTextHeight = binding.editTextHeight;
        editTextWeight = binding.editTextWeight;

        textView1 = binding.textViewAge;
        textView2 = binding.textViewGender;
        textView3 = binding.textViewHeight;
        textView4 = binding.textViewWeight;

        sharedPreferences = this.getSharedPreferences("com.memduhtutus.tryingbilgym", Context.MODE_PRIVATE);

        int storedAge = sharedPreferences.getInt("storedAge",0);
        if(storedAge==0){
            textView1.setText("Your age: ");
        }
        else{
            textView1.setText("Your Age: " + storedAge);
        }

        String storedGender = sharedPreferences.getString("storedGender", "-");
        if(storedGender.equals("")){
            textView2.setText("Your Gender: ");
        }
        else{
            textView2.setText("Your Gender: " + storedGender);
        }

        int storedHeight = sharedPreferences.getInt("storedHeight",0);
        if(storedHeight==0){
            textView3.setText("Your Height: ");
        }
        else{
            textView3.setText("Your Height: " + storedHeight);
        }

        int storedWeight = sharedPreferences.getInt("storedWeight",0);
        if(storedWeight==0){
            textView4.setText("Your Weight: ");
        }
        else{
            textView4.setText("Your Weight: " + storedWeight);
        }
    }

    public void doneClicked(View view){


        if(    editTextAge.getText().toString().matches("") || editTextGender.getText().toString().matches("") ||
                editTextHeight.getText().toString().matches("") || editTextWeight.getText().toString().matches("") ){
            Toast.makeText(getApplicationContext(),"Spaces cannot be empty", Toast.LENGTH_LONG).show();
        }
        else{
            int userAge = Integer.parseInt(textView1.getText().toString());
            sharedPreferences.edit().putInt("storedAge", userAge).apply();
            textView1.setText("Your age: " + userAge);

            String gender = String.valueOf(textView2.getText());
            sharedPreferences.edit().putString("storedGender", gender).apply();
            textView2.setText("Your Gender: " + gender);

            int height = Integer.parseInt(textView3.getText().toString());
            sharedPreferences.edit().putInt("storedHeight", height).apply();
            textView3.setText("Your Height: " + height);

            int weight = Integer.parseInt(textView4.getText().toString());
            sharedPreferences.edit().putInt("storedWeight", weight).apply();
            textView4.setText("Your Weight: " + weight);

        }
        Intent intent = new Intent(PersonalInfoScreen.this, MainScreen.class);
        startActivity(intent);
        finish();
    }
}