package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.memduhtutus.tryingbilgym.databinding.ActivityLogInScreenBinding;
import com.memduhtutus.tryingbilgym.databinding.ActivitySettingPasswordBinding;

public class SettingPassword extends AppCompatActivity {
    ActivitySettingPasswordBinding binding;
    FirebaseAuth auth;
    FirebaseUser user;
    String  newPassword, correctionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingPasswordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

    }
    public void doneClicked(View view){

        newPassword = binding.newPassword.getText().toString();
        correctionText = binding.correctionText.getText().toString();


        if(!newPassword.equals(correctionText)){
            Toast.makeText(this,"Your inputs are not the same.",Toast.LENGTH_LONG).show();
        }
        else if(newPassword.equals("") || correctionText.equals("")){
            Toast.makeText(this, "Spaces cannot be blank.", Toast.LENGTH_LONG).show();
        }
        else if( newPassword.equals(correctionText)){
            user.updatePassword(newPassword);
            Toast.makeText(this, "Updated successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SettingPassword.this, MainScreen.class);
            startActivity(intent);
        }
    }
}