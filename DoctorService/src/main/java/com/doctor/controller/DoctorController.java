package com.doctor.controller;

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

import com.doctor.entity.Doctor;
import com.doctor.service.IDoctorService;

@RestController
@RequestMapping(name = "/doctors")
public class DoctorController {

	@Autowired
	private IDoctorService doctorService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerDoctor(@Valid @RequestBody Doctor doctorRequest) {

		final Doctor savedDoctor = doctorService.saveDoctor(doctorRequest);
		if (savedDoctor.getDocId() < 1) {
			throw new RuntimeException("Error in saving doctor, please try again");
		}
		URI location = URI.create(MessageFormat.format("/doctors/{}", savedDoctor.getDocId()));
		return ResponseEntity.created(location).body("Doctor registered successfully");
	}

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Doctor> getDoctors() {
		return doctorService.getDoctorsList();
	}
}
