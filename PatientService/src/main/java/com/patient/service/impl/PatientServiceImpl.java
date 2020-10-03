package com.patient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.entity.Patient;
import com.patient.repository.IPatientRepository;
import com.patient.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepository patientRepository;
	
	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getPatientsList() {
		return patientRepository.findAll();
	}

}
