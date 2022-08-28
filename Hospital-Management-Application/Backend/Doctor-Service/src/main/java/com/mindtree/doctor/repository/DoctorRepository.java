package com.mindtree.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.doctor.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
	
	@Query("Select d From Doctor d where d.name= ?1")
	Doctor getByDoctorName(String name);
	
	@Query("Select d.name From Doctor d")
	List<?> getListOfDoctorName();

}
