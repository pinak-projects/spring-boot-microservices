package com.doctor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Value;

@Entity
@Table(name = "doctor")
@Value
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "doctor_id")
	private int docId;

	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "is_active")
	private boolean active;
	
	@CreatedDate
	private Date createdOn;
	
	@LastModifiedDate
	private Date modifiedOn;
}
