package com.memduhtutus.tryingbilgym;

public class Event {
    int alreadyJoined;
    String name;
    String SportType;
    Hour hour;
    User U;

    public Event(int alreadyJoined, String name, String SportType, Hour hour, User U) {
        this.alreadyJoined = alreadyJoined;
        this.name = name;
        this.SportType = SportType;
        this.hour = hour;
        this.U = U;
    }
}