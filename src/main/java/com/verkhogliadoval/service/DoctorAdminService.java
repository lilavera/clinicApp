package com.verkhogliadoval.service;


import com.verkhogliadoval.entity.*;
import com.verkhogliadoval.repository.DoctorRepository;
import com.verkhogliadoval.repository.SpecializationRepository;
import com.verkhogliadoval.repository.TimetableRepository;
import com.verkhogliadoval.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DoctorAdminService {
private final DoctorRepository doctorRepository;
private final SpecializationRepository specializationRepository;
private final TimetableRepository timetableRepository;
private final VisitRepository visitRepository;

 @PersistenceContext
 private EntityManager em;

@Autowired
public DoctorAdminService(DoctorRepository doctorRepository, SpecializationRepository specializationRepository, TimetableRepository timetableRepository, VisitRepository visitRepository){
    this.doctorRepository = doctorRepository;
    this.specializationRepository = specializationRepository;
    this.timetableRepository = timetableRepository;
    this.visitRepository = visitRepository;
}

public Doctor findById(Long id){

   return doctorRepository.getOne(id);
}

public List<Doctor> findAll(){
    return doctorRepository.findAll();
}

public Doctor saveDoctor(Doctor doctor){

    return doctorRepository.save(doctor);
}

public boolean checkIfDoctorExists(Doctor doctor){
    List<Doctor> doctorFromDB = doctorRepository.findDoctorByFirstNameAndLastName(doctor.getFirstName(),doctor.getLastName());

    if(doctorFromDB.size()==0) {
        return false;
    }
    return true;
}

public List<Doctor>doctors (){
    return em.createQuery("SELECT d FROM Doctor d",Doctor.class).getResultList();
}

public void deleteDoctor(Long id){
    doctorRepository.deleteById(id);
}

public List<Specialization> findAllSpecialization(){
    return specializationRepository.findAll();
}


    public Doctor saveDoctorWithParameters(String name,String lastname,Specialization specialization){

        return doctorRepository.save(new Doctor(name,lastname,specialization));
    }

public TimeTable saveTimetable(Doctor doctor, int day, LocalTime start, LocalTime end){

    return timetableRepository.save(new TimeTable(doctor,day,start,end));
}

public Visit saveVisit(Doctor doctor, Specialization specialization, LocalDate visitDate, LocalTime visitTime, User user){
    return visitRepository.save(new Visit(visitDate,visitTime,user,doctor,specialization));
}



}
