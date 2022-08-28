package com.mindtree.doctor.controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.doctor.controller.DoctorController;
import com.mindtree.doctor.entity.Doctor;
import com.mindtree.doctor.service.DoctorService;

@RunWith(SpringRunner.class)
@WebMvcTest(DoctorController.class)
public class DoctorControllerTest {
	
	@MockBean
	private DoctorService doctorService;
	
	@Autowired
	private MockMvc mockmvc;
	
	
	ObjectMapper mapper  = new ObjectMapper();
	
	@Test
	void saveDoctorTest() throws JsonProcessingException, Exception {
		Doctor d = new Doctor();
		
		d.setId(1);
		d.setName("sachin");
		d.setAge(24);
		d.setGender("Male");
		d.setSpecialist("Surgeon");
		
		when(doctorService.addDoctor(any(Doctor.class))).thenReturn(d);
		mockmvc.perform(post("/doctor/register").content(mapper.writeValueAsString(d)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	
	void getAllDoctor() throws JsonProcessingException, Exception {
        Doctor d = new Doctor();
		
		d.setId(1);
		d.setName("sachin");
		d.setAge(24);
		d.setGender("Male");
		d.setSpecialist("Surgeon");
		
		
        Doctor d1 = new Doctor();
		
		d1.setId(2);
		d1.setName("raj");
		d1.setAge(24);
		d1.setGender("Male");
		d1.setSpecialist("Surgeon");
		
		List<Doctor> ld = new ArrayList<>();
		ld.add(d1);
		ld.add(d);
		
		Mockito.when(doctorService.getAllDoctor()).thenReturn(ld);
		mockmvc.perform(get("/doctor").content(mapper.writeValueAsString(ld)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

}
