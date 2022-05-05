package com.memduhtutus.tryingbilgym;

public class Event {
    int alreadyJoined;
    String name;
    String SportType;
    matchmakingHour hour;
    User U;

    public Event(int alreadyJoined, String name, String SportType, matchmakingHour matchMakingHour, User U) {
        this.alreadyJoined = alreadyJoined;
        this.name = name;
        this.SportType = SportType;
        this.hour = matchMakingHour;
        this.U = U;
    }
}