package com.verkhogliadoval.entity;

import java.util.HashMap;
import java.util.Map;

public class DayOfWeek {
    private static final Map<Integer, String> daysOfWeek = new HashMap<>();
    static {
        daysOfWeek.put(1, "Poniedziałek");
        daysOfWeek.put(2,"Wtorek");
        daysOfWeek.put(3, "Środa");
        daysOfWeek.put(4, "Czwartek");
        daysOfWeek.put(5, "Piątek");
        daysOfWeek.put(6, "Sobota");
        daysOfWeek.put(7, "Niedziela");
    }

    public static Map<Integer, String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public static String getDayOfWeek(Integer day) {
        return daysOfWeek.get(day);
    }

}
