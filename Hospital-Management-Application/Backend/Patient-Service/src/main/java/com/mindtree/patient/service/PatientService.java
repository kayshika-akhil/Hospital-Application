package com.mindtree.patient.service;

import org.springframework.http.ResponseEntity;

import com.mindtree.patient.entity.Patient;

public interface PatientService {
	
	Patient addPatient(Patient patient);
	
	int getCountOfAttendedPatient(String nameOfDoctor);
	
	Patient getPatientById(int id);

}
