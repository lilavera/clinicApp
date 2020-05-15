package com.verkhogliadoval.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long timeTableId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private int dayOfWeek;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime shiftStart;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime shiftEnd;

    public TimeTable(Doctor doctor, int dayOfWeek, LocalTime shiftStart, LocalTime shiftEnd) {
        this.doctor = doctor;
        this.dayOfWeek = dayOfWeek;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
    }

    public TimeTable() {
    }

    public long getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(long timeTableId) {
        this.timeTableId = timeTableId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(LocalTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public LocalTime getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(LocalTime shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    public String getDayOfWeekText(){
        return DayOfWeek.getDayOfWeek(dayOfWeek);
    }

    @Override
    public String toString() {
        return "Zmiana: " +
                "\nLekarz:"  + doctor.getFullName() +
                ", \nDzień tygodnia: " + DayOfWeek.getDayOfWeek(dayOfWeek) +
                ", \nPoczątek zmiany:" + shiftStart +
                ", \nKoniec zmiany:" + shiftEnd;
    }
}
