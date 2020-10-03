package com.doctor.service;

import java.util.List;

import com.doctor.entity.Doctor;

public interface IDoctorService {

	Doctor saveDoctor(Doctor doctor);

	List<Doctor> getDoctorsList();
}
