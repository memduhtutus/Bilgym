package com.memduhtutus.tryingbilgym;

import java.util.ArrayList;

public class User {
    String name;
    String bilkentMail;
    int bilID;
    String password;
    PersonalInfoScreen pi;
    ArrayList<String> selectedMuscles;
    ArrayList<Event> joinedEvents;
    ArrayList<Reservation> joinedReservations;

    public User(){

    }

    public User(String name, String bilkentMail, int bilID, String password, PersonalInfoScreen pi, ArrayList<String> selectedMuscles){
        this.name = name;
        this.bilkentMail = bilkentMail;
        this.bilID = bilID;
        this.password = password;
        this.pi = new PersonalInfoScreen();
        this.selectedMuscles = new ArrayList<>();
        this.joinedEvents = new ArrayList<>();
        this.joinedReservations = new ArrayList<>();
    }

    public String getUserName(){
        return this.name;
    }
}
