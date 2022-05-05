package com.memduhtutus.tryingbilgym;

public class Event {
    int alreadyJoined;
    String name;
    String SportType;
    matchmakingHour hour;

    public Event(int alreadyJoined, String name, String SportType, matchmakingHour matchMakingHour) {
        this.alreadyJoined = alreadyJoined;
        this.name = name;
        this.SportType = SportType;
        this.hour = matchMakingHour;
    }


}