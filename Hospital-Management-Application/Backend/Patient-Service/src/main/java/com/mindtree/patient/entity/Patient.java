package com.mindtree.patient.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String visitedDoc;
	
	private LocalDate visitedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVisitedDoc() {
		return visitedDoc;
	}

	public void setVisitedDoc(String visitedDoc) {
		this.visitedDoc = visitedDoc;
	}

	public LocalDate getVisitedDate() {
		return visitedDate;
	}

	public void setVisitedDate(LocalDate visitedDate) {
		this.visitedDate = visitedDate;
	}

	public Patient(int id, String name, String visitedDoc, LocalDate visitedDate) {
		super();
		this.id = id;
		this.name = name;
		this.visitedDoc = visitedDoc;
		this.visitedDate = visitedDate;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

	

}
