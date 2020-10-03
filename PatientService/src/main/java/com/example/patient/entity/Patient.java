package com.example.patient.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Value;

@Entity
@Table(name = "patient")
@Value
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "patient_id")
	private int patientId;

	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "is_active")
	private boolean active;
	
	@Column(name = "assigned_doctor_id")
	private int docId;
	
	@Transient
	private String docName;
	
	@CreatedDate
	private Date createdOn;
	
	@LastModifiedDate
	private Date modifiedOn;
}
