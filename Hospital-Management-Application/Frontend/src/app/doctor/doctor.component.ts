import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { HospitalService } from '../hospital.service';
import  Swal  from 'sweetalert2';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  doctor: Doctor = new Doctor();

  constructor(private hospitalService: HospitalService) { }

  ngOnInit(): void {
  }

  saveDoctor(){
    this.hospitalService.sendDoctorData(this.doctor).subscribe(data =>{
      console.log(data);
    });
  }


  afterSubmiting(){
    Swal.fire('Thank You',"You submitted Successfully",'success');
  }

  onSubmit(){
    this.saveDoctor();
    this.afterSubmiting();

  }

}
