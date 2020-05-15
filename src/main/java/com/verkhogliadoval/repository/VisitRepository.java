package com.verkhogliadoval.repository;

import com.verkhogliadoval.entity.Doctor;
import com.verkhogliadoval.entity.TimeTable;
import com.verkhogliadoval.entity.User;
import com.verkhogliadoval.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface VisitRepository extends JpaRepository<Visit,Long> {

TimeTable findAllByDoctorAndAndVisitDateAndVisitTime(LocalDate visitDate, LocalTime visitTime,  Doctor doctor);
TimeTable findByDoctorAndUserAndVisitDateAndVisitTime(LocalDate visitDate, LocalTime visitTime,  Doctor doctor,User user);
TimeTable findByVisitTime(LocalTime visitTime);
TimeTable findByVisitDate(LocalDate visitDate);


}
