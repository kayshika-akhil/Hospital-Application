package com.mindtree.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mindtree.doctor.entity.Doctor;
import com.mindtree.doctor.entity.DoctorDetails;
import com.mindtree.doctor.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	public DoctorService doctorService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/register")
	Doctor addDoc(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}
	
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping
	List<Doctor> getListOfDoctor(){
		return doctorService.getAllDoctor();
	}
	
	@GetMapping("{name}")
	Doctor getDocName(@PathVariable String name) {
		return doctorService.getDocByName(name);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/details/{name}")
	DoctorDetails getDoctorDetails(@PathVariable String name) {
		
		DoctorDetails doctDetails = new DoctorDetails();
		
		Doctor existDoc = doctorService.getDocByName(name);
		
		Integer count = restTemplate.getForObject("http://localhost:8082/patient/"+name,Integer.class);
		
		doctDetails.setName(existDoc.getName());
		doctDetails.setSpecialist(existDoc.getSpecialist());
		doctDetails.setNoOfPatientAttended(count);
		
		return doctDetails;
		

		
		
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/allnames")
	List<?> getDocsName(){
		return doctorService.getAllDoctorName();
	}

}
