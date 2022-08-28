package com.mindtree.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.mindtree.patient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	@Query("Select Count(p) From Patient p where p.visitedDoc= ?1")
	int getNoOfPatientAttended(String nameOfDoctor);

}
