import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { HospitalService } from '../hospital.service';
import { Patient } from '../patient';

@Component({
  selector: 'app-view-patient',
  templateUrl: './view-patient.component.html',
  styleUrls: ['./view-patient.component.css']
})
export class ViewPatientComponent implements OnInit {

  doctors: Doctor[];
  noSuchData: string;

  patient: Patient = new Patient();
  id: any;

  constructor(private hospitalService: HospitalService) { }

  ngOnInit(): void {
  }

  getDocById(){
    this.hospitalService.getPatientById(this.id).subscribe(data =>{
      if(data === null){
        this.noSuchData = "No such patient there in the database.";
      }else{
        this.patient=data;
      }
    })

  }

  onSubmit(){
    this.getDocById();

  }

}
