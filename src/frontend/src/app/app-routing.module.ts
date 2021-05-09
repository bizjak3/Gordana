import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {SignupComponent} from './components/signup/signup.component';
import { DodajPsaComponent } from './components/dodaj-psa/dodaj-psa.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'dodaj_psa',
    component: DodajPsaComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
