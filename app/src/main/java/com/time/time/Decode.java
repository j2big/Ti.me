package com.time.time;

/**
 * Created by Afolabi on 12/21/2015.
 */
public class Decode {

    int day, month, year;
    String s_day, s_month, s_year;

    public String decodeDay(int day) {
        switch (day) {
            case 1:
                s_day = "Sun.";
                break;
            case 2:
                s_day = "Mon.";
                break;
            case 3:
                s_day = "Tues.";
                break;
            case 4:
                s_day = "Wed.";
                break;
            case 5:
                s_day = "Thur.";
                break;
            case 6:
                s_day = "Fri.";
                break;
            case 7:
                s_day = "Sat.";
                break;
        }
        return s_day;
    }

    public String decodeMonth(int month) {
        return null;
    }

    public String decodeYear(int year) {
        return null;
    }

}
