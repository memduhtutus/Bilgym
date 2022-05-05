package com.memduhtutus.tryingbilgym;

public class Event {
    int alreadyJoined;
    String name;
    String SportType;
    matchmakingHour hour;
    int quota;

    public Event(int alreadyJoined, String name, String SportType, matchmakingHour matchMakingHour, int quota) {
        this.alreadyJoined = alreadyJoined;
        this.name = name;
        this.SportType = SportType;
        this.hour = matchMakingHour;
        this.quota = quota;
    }

    public int getQuota(){
        return this.quota;
    }


}