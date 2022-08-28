import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorComponent } from './doctor/doctor.component';
import { HomeComponent } from './home/home.component';
import { PatientComponent } from './patient/patient.component';
import { ViewDoctorComponent } from './view-doctor/view-doctor.component';
import { ViewPatientComponent } from './view-patient/view-patient.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'doctor', component: DoctorComponent},
  {path: 'patient', component: PatientComponent},
  {path: 'viewdoctor', component: ViewDoctorComponent},
  {path: 'viewpatient', component: ViewPatientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
