package com.memduhtutus.tryingbilgym;
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

    public int getQuota(){
        return this.quota;
    }
    public String getName(){ return  this.name;}
    public String getSportType(){return this.SportType;}
    public matchmakingHour getHour(){return this.hour;}
    public int getAlreadyJoined(){return this.alreadyJoined;}

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Number Of Joined People", alreadyJoined);
        result.put("name", name);
        result.put("Sport Type", SportType);
        result.put("Hour", hour);
        result.put("Left Quota", quota);

        return result;
    }


}