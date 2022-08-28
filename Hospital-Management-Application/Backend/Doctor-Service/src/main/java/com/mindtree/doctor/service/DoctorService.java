package com.mindtree.doctor.service;

import java.util.List;

import com.mindtree.doctor.entity.Doctor;

public interface DoctorService {
	
	Doctor addDoctor(Doctor doctor);
	
	List<Doctor> getAllDoctor();
	
	Doctor getDocByName(String name);
	
	List<?> getAllDoctorName();
}
