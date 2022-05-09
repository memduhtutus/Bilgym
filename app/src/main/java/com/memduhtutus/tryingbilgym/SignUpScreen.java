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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.memduhtutus.tryingbilgym.databinding.ActivityMainBinding;
import com.memduhtutus.tryingbilgym.databinding.ActivitySignUpScreenBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;

public class SignUpScreen extends AppCompatActivity {
    private ActivitySignUpScreenBinding binding;
    private FirebaseAuth auth;
    private FirebaseUser mUser;
    private DatabaseReference mDatabase;
    private HashMap<String, Object> mData;

    public String name, email, password, bilkentId;
    public User user;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
    }

    public void signUpFinalClicked(View view){

        name = binding.editTextTextPersonName.getText().toString();
        email = binding.EditTextEmailAddress.getText().toString();
        password = binding.editTextTextPassword.getText().toString();
        bilkentId = binding.EditTextBilkentID.getText().toString();
        if(email.equals("") || password.equals("") ||bilkentId.equals("") || name.equals("")){
            Toast.makeText(this, "Spaces cannot be blank.", Toast.LENGTH_LONG).show();
        }
        else {
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    mUser = auth.getCurrentUser();

                    user = new User(name, email, bilkentId, password);
                    mDatabase.child("Users").child(mUser.getUid())
                            .setValue(user)
                            .addOnCompleteListener(SignUpScreen.this, new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                        Toast.makeText(SignUpScreen.this, "Your profile is successfully created.", Toast.LENGTH_SHORT).show();
                                    else
                                        Toast.makeText(SignUpScreen.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

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