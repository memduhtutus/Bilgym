package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CancelActivityScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_screen);
        /*if(/*eğer randevusu varsa){
            //şu tarihte randevunuz var.
            //setText ile yapacağız. textAboutCancel id si text metninin
        }
        else{
            //eğer randevusu yoksa daha önceden
            // textAboutCancel metnini yapıcaz ki daha önce randevun yok knk.
        }*/
    }
    public void cancelActivityDoneClicked(View view){

        // butona tıklayınca firebaseden randevuyu silicek onun kodunu yazmak kaldı sadece.
        Intent intent = new Intent(CancelActivityScreen.this, MainScreen.class);
        startActivity(intent);
        finish();
    }
}