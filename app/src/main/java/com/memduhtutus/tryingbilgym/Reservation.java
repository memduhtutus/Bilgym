package com.memduhtutus.tryingbilgym;

import java.util.HashMap;
import java.util.Map;

public class Reservation {
    static gymHour[] hours = new gymHour[]{new gymHour(3,"10:30-11:30"),new gymHour(3,"11:30-12:30"),new gymHour(3,"12:30-13:30")};
    static boolean[] availability;

    User u;
    int day; //0 = today, 1 = tomorrow
    gymHour specificHour;

    public Reservation(User u, int day , gymHour specificHour){
        this.u = u;
        this.day = day;
        this.specificHour = specificHour;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("user", u);
        result.put("day", day);
        result.put("hour", specificHour);

        return result;
    }
}
