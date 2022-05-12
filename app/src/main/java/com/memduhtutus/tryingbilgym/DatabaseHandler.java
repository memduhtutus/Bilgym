package com.memduhtutus.tryingbilgym;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseHandler {
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    public DatabaseHandler(DatabaseReference dr, FirebaseAuth fa){
        mDatabase = dr;
        mAuth = fa;
    }

    public DatabaseReference getmDatabase() {
        return mDatabase;
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }
}
