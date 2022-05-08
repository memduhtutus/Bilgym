package com.memduhtutus.tryingbilgym;

import java.util.ArrayList;

public class User {
    String name;
    String bilkentMail;
    String bilID;
    String password;
    ArrayList<Event> joinedEvents;
    ArrayList<Reservation> joinedReservations;

    public User(){

    }

    public User(String name, String bilkentMail, String bilID, String password){
        this.name = name;
        this.bilkentMail = bilkentMail;
        this.bilID = bilID;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getBilkentMail() {
        return bilkentMail;
    }

    public String getBilID() {
        return bilID;
    }
}
