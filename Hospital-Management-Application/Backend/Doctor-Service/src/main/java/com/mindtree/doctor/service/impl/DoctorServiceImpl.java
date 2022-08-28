package com.mindtree.doctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.doctor.entity.Doctor;
import com.mindtree.doctor.repository.DoctorRepository;
import com.mindtree.doctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	public DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctor() {
		return doctorRepository.findAll();
		
	}

	@Override
	public Doctor getDocByName(String name) {
		return doctorRepository.getByDoctorName(name);
	}

	@Override
	public List<?> getAllDoctorName() {
		return doctorRepository.getListOfDoctorName();
	}

}
