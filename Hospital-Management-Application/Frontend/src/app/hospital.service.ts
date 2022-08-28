import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctor } from './doctor';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  private baseUrl = "http://localhost:8090";

  constructor(private httpClient: HttpClient) { }

  sendDoctorData(doctor: Doctor): Observable<Object>{
    return this.httpClient.post<Object>(this.baseUrl+"/doctor/register",doctor);

  }

  getAllDoctor(): Observable<Doctor[]>{
    return this.httpClient.get<Doctor[]>(this.baseUrl+"/doctor");
  }

  sendPatientData(patient: Patient): Observable<Object>{
    return this.httpClient.post<Object>(this.baseUrl+"/patient/register",patient);
  }

  getListOfDoctorNames(): Observable<any>{
    return this.httpClient.get<any>(this.baseUrl+"/doctor/allnames");
  }

  getDoctorDetails(value: String): Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl+"/doctor/details"}/${value}`);
  }

  getPatientById(id: number): Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl+"/patient/id"}/${id}`);
  }

}
