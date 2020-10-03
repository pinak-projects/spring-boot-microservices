package com.patient.service;

import java.util.List;

import com.patient.entity.Patient;

public interface IPatientService {

	Patient savePatient(Patient patient);

	List<Patient> getPatientsList();
}
