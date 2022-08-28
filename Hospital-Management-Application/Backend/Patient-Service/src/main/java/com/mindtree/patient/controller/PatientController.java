package com.mindtree.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.patient.entity.Patient;
import com.mindtree.patient.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	
	@Autowired
	private PatientService patientService;
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/register")
	public Patient getPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
	
	
	@GetMapping("{nameOfDoc}")
	public int getCountOfAttendedPatient(@PathVariable String nameOfDoc) {
		return patientService.getCountOfAttendedPatient(nameOfDoc);
		
	}
	
	@GetMapping("/id/{id}")
	public Patient getById(@PathVariable int id) {
		return patientService.getPatientById(id);
	}

}
