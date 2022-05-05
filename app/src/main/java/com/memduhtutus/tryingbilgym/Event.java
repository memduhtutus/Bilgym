package com.memduhtutus.tryingbilgym;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("alreadyJoined", alreadyJoined);
        result.put("name", name);
        result.put("Sport Type", SportType);
        result.put("hour", hour);

        return result;
    }

    public int getAlreadyJoined(){
        return this.alreadyJoined;
    }

    public String getName(){
        return this.name;
    }

    public String getSportType(){
        return this.SportType;
    }

    public matchmakingHour getHour(){
        return this.hour;
    }

    public int getQuota(){
        return this.quota;
    }
}