package com.patient.controller;

import java.net.URI;
import java.text.MessageFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.patient.entity.Patient;
import com.patient.service.IPatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(name = "/patients")
public class PatientController {

	@Autowired
	private IPatientService patientService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerPatient(@Valid @RequestBody Patient patientRequest) {
		log.info("registerPatient");
		final Patient savedPatient = patientService.savePatient(patientRequest);
		if (savedPatient.getPatientId() < 1) {
			throw new RuntimeException("Error in saving patient, please try again");
		}
		URI location = URI.create(MessageFormat.format("/patients/{}", savedPatient.getPatientId()));
		return ResponseEntity.created(location).body("Patient registered successfully");
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Patient> getPatients() {
		log.info("getPatients");
		return patientService.getPatientsList();
	}
}
