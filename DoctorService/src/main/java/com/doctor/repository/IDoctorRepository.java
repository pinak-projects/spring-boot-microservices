package com.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.entity.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer > {

}
