package com.verkhogliadoval.entity;

import java.util.HashMap;
import java.util.Map;

public class DayOfWeek {
    private static final Map<Integer, String> daysOfWeek = new HashMap<>();
    static {
        daysOfWeek.put(1, "Monday");
        daysOfWeek.put(2,"Tuesday");
        daysOfWeek.put(3, "Wednesday");
        daysOfWeek.put(4, "Thursday");
        daysOfWeek.put(5, "Friday");
        daysOfWeek.put(6, "Saturday");
        daysOfWeek.put(7, "Sunday");
    }

    public static Map<Integer, String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public static String getDayOfWeek(Integer day) {
        return daysOfWeek.get(day);
    }

}
