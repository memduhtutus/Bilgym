package com.memduhtutus.tryingbilgym;

public class Reservation {
    public static gymHour[] hours = new gymHour[]{new gymHour(3,"10:30-11:30"),new gymHour(3,"11:30-12:30"),new gymHour(3,"12:30-13:30")};
    public static boolean[] availability;

    int day; //0 = today, 1 = tomorrow
    gymHour specificHour;

    public Reservation( int day , gymHour specificHour){
        this.day = day;
        this.specificHour = specificHour;
    }

    public int getDay(){
        return day;
    }

    public gymHour getSpecificHour(){
        return specificHour;
    }
}
