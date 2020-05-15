package com.verkhogliadoval.repository;

import com.verkhogliadoval.entity.Doctor;
import com.verkhogliadoval.entity.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalTime;
import java.util.List;

public interface TimetableRepository extends JpaRepository<TimeTable,Long> {
    List<TimeTable> findAllByDayOfWeekAndShiftStartAndShiftEndAndDoctor(int day, LocalTime shiftStart, LocalTime shiftEnd, Doctor doctor);
    TimeTable findAllByShiftStartAndDoctor(LocalTime shiftStart, Doctor doctor);
    TimeTable findAllByShiftEnd(LocalTime shiftEnd,Doctor doctor);
    TimeTable findAllByDoctor(Doctor doctor);
}
