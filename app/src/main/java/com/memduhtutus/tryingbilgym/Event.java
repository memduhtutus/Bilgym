package com.memduhtutus.tryingbilgym;
import java.util.HashMap;
import java.util.Map;
public class Event {
    int alreadyJoined;
    String SportType;
    String hour;
    int quota;

    public Event(int alreadyJoined, String SportType, String matchMakingHour, int quota) {
        this.alreadyJoined = alreadyJoined;
        this.SportType = SportType;
        this.hour = matchMakingHour;
        this.quota = quota;
    }

    public int getQuota(){
        return this.quota;
    }
    public String getSportType(){return this.SportType;}
    public String getHour(){return this.hour;}
    public int getAlreadyJoined(){return this.alreadyJoined;}


}