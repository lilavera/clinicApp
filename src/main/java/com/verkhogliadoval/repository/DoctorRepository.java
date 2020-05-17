package com.verkhogliadoval.repository;

import com.verkhogliadoval.entity.Doctor;
import com.verkhogliadoval.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

List<Doctor>  findByDoctorId(long id);
List <Doctor> findDoctorByLastNameEquals(String lastname);
List <Doctor> findDoctorByFirstNameAndLastName(String firstname, String lastname);
List <Doctor> findDoctorBySpecialization_SpecializationId(long specid);
}
