import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { HospitalService } from '../hospital.service';
import { Patient } from '../patient';
import { DatePipe } from '@angular/common';
import  Swal  from 'sweetalert2';
@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {


  patient: Patient = new Patient();
  doctors: string[];
  

  constructor(private hospitalService: HospitalService) { }

  ngOnInit(): void {
    this.getAllListOfDoctors();
  }


  getAllListOfDoctors(){
    this.hospitalService.getListOfDoctorNames().subscribe(data =>{
      this.doctors=data;
      console.log(data);
    })
  }

  savePatientData(){
    this.hospitalService.sendPatientData(this.patient).subscribe(data =>{
      console.log(data);

    })
  }

  afterSubmiting(){
    Swal.fire('Thank You',"You submitted Successfully",'success');
  }


  onSubmit(){
    this.savePatientData();
    this.afterSubmiting();
  }
}
