package com.memduhtutus.tryingbilgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.memduhtutus.tryingbilgym.databinding.ActivityMainBinding;
import com.memduhtutus.tryingbilgym.databinding.ActivitySignUpScreenBinding;

public class SignUpScreen extends AppCompatActivity {
    private ActivitySignUpScreenBinding binding;
    private FirebaseAuth auth;

    public String name, email, password, bilkentId;


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
    }

    public void signUpFinalClicked(View view){

        name = binding.editTextTextPersonName.getText().toString();
        email = binding.EditTextEmailAddress.getText().toString();
        password = binding.editTextTextPassword.getText().toString();
        bilkentId = binding.EditTextBilkentID.getText().toString();
        if(email.equals("") || password.equals("") ||bilkentId.equals("") || name.equals("")){
            Toast.makeText(this, "", Toast.LENGTH_LONG).show();
        }
        else {
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(SignUpScreen.this, MainScreen.class);
                    startActivity(intent);
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(SignUpScreen.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
}