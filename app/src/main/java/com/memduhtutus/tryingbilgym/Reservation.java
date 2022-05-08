package com.memduhtutus.tryingbilgym;
import java.util.HashMap;
import java.util.Map;
public class Reservation {
    public static gymHour[] hours = new gymHour[]{new gymHour("10:30-11:30"),new gymHour("11:30-12:30"),new gymHour("12:30-13:30")};
    public static boolean[] availability;

    int day; //0 = today, 1 = tomorrow
    gymHour specificHour;

    public Reservation(int day , gymHour specificHour){
        this.day = day;
        this.specificHour = specificHour;
    }

    public int getDay(){
        return day;
    }

    public gymHour getSpecificHour(){
        return specificHour;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("day", day);
        result.put("Hour", specificHour);

        return result;
    }
}
