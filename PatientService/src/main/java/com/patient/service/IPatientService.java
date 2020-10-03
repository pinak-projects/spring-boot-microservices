package com.example.patient.service;

import java.util.List;

import com.example.patient.entity.Patient;

public interface IPatientService {

	Patient savePatient(Patient patient);

	List<Patient> getPatientsList();
}
