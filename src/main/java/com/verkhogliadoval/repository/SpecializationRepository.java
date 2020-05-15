package com.verkhogliadoval.repository;

import com.verkhogliadoval.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpecializationRepository extends JpaRepository<Specialization,Long> {

    @Query(value= "SELECT specialization_id FROM public.specialization where specialization_name = :specialization_name",nativeQuery = true)
    Specialization findIdByName(
            @Param("specialization_name") String specializationName);

   List <Specialization> findSpecializationBySpecializationNameEquals(String name);

    List <Specialization> findBySpecializationId(long id);


}
