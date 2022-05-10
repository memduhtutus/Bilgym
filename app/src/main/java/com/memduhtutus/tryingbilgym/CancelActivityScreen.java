package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
public class CancelActivityScreen extends AppCompatActivity {
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
        /*if(/*eğer randevusu varsa){
            //şu tarihte randevunuz var.
            //setText ile yapacağız. textAboutCancel id si text metninin
        }
        else{
            //eğer randevusu yoksa daha önceden
            // textAboutCancel metnini yapıcaz ki daha önce randevun yok knk.
        }*/
    }

    public void buttonApplyHourClicked(View view){
        int radioId = radioGroupHours.getCheckedRadioButtonId();
        radioButtonHour = findViewById(radioId);
        Toast.makeText(CancelActivityScreen.this,
                "Selected Hour: " + radioButtonHour.getText(), Toast.LENGTH_SHORT).show();
    }

    public void buttonApplyDayClicked(View view){
        int radioId = radioGroupDays.getCheckedRadioButtonId();
        radioButtonDay = findViewById(radioId);
        Toast.makeText(CancelActivityScreen.this,
                "Selected Day: " + radioButtonDay.getText(), Toast.LENGTH_SHORT).show();
    }

    public void buttonCancelAppointmentClicked(View view){

        mUser = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference("Reservations").child(mUser.getUid());
        mDatabase.removeValue()
                .addOnCompleteListener(CancelActivityScreen.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(CancelActivityScreen.this, "Reservation is successfully deleted.", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(CancelActivityScreen.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        Intent intent = new Intent(CancelActivityScreen.this, MainScreen.class);
        startActivity(intent);
        finish();
    }
}