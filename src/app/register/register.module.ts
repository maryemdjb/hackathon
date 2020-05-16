import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { RegisterRoutingModule } from './register-routing.module';
import {RegisterComponent} from './register.component';
import {HttpClientModule} from '@angular/common/http';
import {RegisterService} from './register.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [RegisterComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RegisterRoutingModule,

  ],
  providers: [RegisterService ]
})
export class RegisterModule { }
