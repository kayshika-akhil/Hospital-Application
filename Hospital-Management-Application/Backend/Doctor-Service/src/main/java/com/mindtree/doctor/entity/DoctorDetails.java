package com.mindtree.doctor.entity;


public class DoctorDetails {
	
	private String name;
	private String specialist;
	private Integer noOfPatientAttended;
	
	
	public DoctorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorDetails(String name, String specialist, Integer noOfPatientAttended) {
		super();
		this.name = name;
		this.specialist = specialist;
		this.noOfPatientAttended = noOfPatientAttended;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public Integer getNoOfPatientAttended() {
		return noOfPatientAttended;
	}
	public void setNoOfPatientAttended(Integer count) {
		this.noOfPatientAttended = count;
	}
	
	
		

}
