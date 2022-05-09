package com.memduhtutus.tryingbilgym;
import java.util.HashMap;
import java.util.Map;
public class Reservation {
    public static gymHour[] hours = new gymHour[]{new gymHour("10:30-11:30"),new gymHour("11:30-12:30"),new gymHour("12:30-13:30")};
    public static boolean[] availability;

    String day; //0 = today, 1 = tomorrow
    String specificHour;

    public Reservation(String day , String specificHour){
        this.day = day;
        this.specificHour = specificHour;
    }

    public String getDay(){
        return day;
    }

    public String getSpecificHour(){
        return specificHour;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("day", day);
        result.put("Hour", specificHour);

        return result;
    }
}
