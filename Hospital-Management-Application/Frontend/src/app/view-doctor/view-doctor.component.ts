import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorDetail } from '../doctor-detail';
import { HospitalService } from '../hospital.service';

@Component({
  selector: 'app-view-doctor',
  templateUrl: './view-doctor.component.html',
  styleUrls: ['./view-doctor.component.css']
})
export class ViewDoctorComponent implements OnInit {

  doctor: Doctor[];
  selectedElement: any;

  doctorDetail: DoctorDetail = new DoctorDetail();

  constructor(private hospitalService: HospitalService) { }

  ngOnInit(): void {
    this.getAllListOfCustomer();
    this.selectedElement;
  }

  getAllListOfCustomer(){
    this.hospitalService.getAllDoctor().subscribe(data =>{
      this.doctor=data;
      console.log(data);
    })
  }

  onOptionSelected(value: String){
    this.selectedElement = value;
    console.log(this.selectedElement);
    this.getDoctorDetails(this.selectedElement);
  }

  getDoctorDetails(value: String){
    this.hospitalService.getDoctorDetails(this.selectedElement).subscribe(data =>{
      this.doctorDetail = data;
      console.log(data)
    })
  }

}
