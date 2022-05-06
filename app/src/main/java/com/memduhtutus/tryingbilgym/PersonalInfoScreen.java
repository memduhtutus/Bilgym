package com.memduhtutus.tryingbilgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.memduhtutus.tryingbilgym.databinding.ActivityPersonalInfoScreenBinding;
import com.memduhtutus.tryingbilgym.databinding.ActivitySignUpScreenBinding;

public class PersonalInfoScreen extends AppCompatActivity {
    private @NonNull ActivityPersonalInfoScreenBinding binding;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_screen);
        binding = ActivityPersonalInfoScreenBinding.inflate(getLayoutInflater());

        editText1 = findViewById(R.id.editTextTextPersonName8);
        editText2 = findViewById(R.id.editTextTextPersonName6);
        editText3 = findViewById(R.id.editTextTextPersonName7);
        editText4 = findViewById(R.id.editTextTextPersonName5);

        textView1 = findViewById(R.id.textView5);
        textView2 = findViewById(R.id.textView13);
        textView3 = findViewById(R.id.textView14);
        textView4 = findViewById(R.id.textView15);

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
        Intent intent = new Intent(PersonalInfoScreen.this, MainScreen.class);
        startActivity(intent);
        finish();

        if(    editText1.getText().toString().matches("") || editText1.getText().toString().matches("") ||
                editText1.getText().toString().matches("") || editText1.getText().toString().matches("") ){
            Toast.makeText(getApplicationContext(),"Spaces cannot be empty", Toast.LENGTH_LONG).show();
        }
        else{
            int userAge = Integer.parseInt(editText1.getText().toString());
            textView1.setText("Your age: " + userAge);
            sharedPreferences.edit().putInt("storedAge", userAge).apply();

            String gender = String.valueOf(editText2.getText());
            textView2.setText("Your Gender: " + gender);
            sharedPreferences.edit().putString("storedGender", gender).apply();

            int height = Integer.parseInt(editText3.getText().toString());
            textView3.setText("Your Height: " + height);
            sharedPreferences.edit().putInt("storedHeight", height).apply();

            int weight = Integer.parseInt(editText3.getText().toString());
            textView4.setText("Your Weight: " + weight);
            sharedPreferences.edit().putInt("storedWeight", weight).apply();
        }
    }
}