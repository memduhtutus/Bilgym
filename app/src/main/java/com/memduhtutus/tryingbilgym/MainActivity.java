package com.memduhtutus.tryingbilgym;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity {
    private DatabaseReference mDatabase;
    public MainActivity(DatabaseReference database) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }
    public void createNewUser(String name, String bilkentMail, int bilID, String password, PersonalInfoScreen pi, ArrayList<String> selectedMuscles){
        User user = new User(name, bilkentMail, bilID, password, pi, selectedMuscles);
        mDatabase.child("users").child(name).setValue(user);
    }

    public void writeNewUserWithTaskListeners(String name, String bilkentMail, int bilID, String password, PersonalInfoScreen pi, ArrayList<String> selectedMuscles) {
        User user = new User(name, bilkentMail, bilID, password, pi, selectedMuscles);

        mDatabase.child("users").child(name).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
    }

    public void createEvent(int alreadyJoined, String name, String SportType, matchmakingHour hour, int quota, User u) {

        String key = mDatabase.child("events").push().getKey();
        Event e = new Event(alreadyJoined, name, SportType, hour, quota);
        Map<String, Object> eventValues = e.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/events/" + key, eventValues);
        childUpdates.put("/user-events/" + u.getUserName() + "/" + key, eventValues);

        mDatabase.updateChildren(childUpdates);
    }

    private void createNewReservation(User u, int day, gymHour hour){
        String key = mDatabase.child("reservations").push().getKey();
        Reservation reserv = new Reservation(day, hour);
        Map<String, Object> reservValues = reserv.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/reservations/" + key, reservValues);
        childUpdates.put("/user-reservations/" + u.getUserName() + "/" + key, reservValues);

        mDatabase.updateChildren(childUpdates);
    }

}
