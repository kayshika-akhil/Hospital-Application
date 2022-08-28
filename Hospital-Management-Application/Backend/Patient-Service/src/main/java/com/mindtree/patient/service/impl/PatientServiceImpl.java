package com.mindtree.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindtree.patient.entity.Patient;
import com.mindtree.patient.repository.PatientRepository;
import com.mindtree.patient.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public int getCountOfAttendedPatient(String nameOfDoctor) {
		return patientRepository.getNoOfPatientAttended(nameOfDoctor);
	}

	@Override
	public Patient getPatientById(int id) {
		return patientRepository.findById(id).orElse(null);
	}

}
