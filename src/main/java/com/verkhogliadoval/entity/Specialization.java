package com.verkhogliadoval.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long specializationId;

    @Column(nullable = false, unique = true)
    private String specializationName;

    @OneToMany(mappedBy = "specialization", fetch = FetchType.EAGER)
    private List<Doctor>  doctors;

    @OneToMany(mappedBy = "specialization")
    private List<Visit> visits;

    public Specialization(String specializationName) {
        this.specializationName = specializationName;
    }

    public Specialization() {
    }

//    @PreRemove
//    private void removeAssociations(){
//        visits = null;
//        doctors = null;
//    }

    public long getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(long specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    @Override
    public String toString() {
        return specializationName;
    }
}
