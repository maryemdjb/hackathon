import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { ReservationRoutingModule } from './reservation-routing.module';
import {ReservationComponent} from './reservation.component';
import {MatStepperModule} from '@angular/material/stepper';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';

@NgModule({
  declarations: [ReservationComponent],
  imports: [
    CommonModule,
    ReservationRoutingModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    MatStepperModule,
    MatFormFieldModule,
    FormsModule,
     ReactiveFormsModule
  ]
})
export class ReservationModule { }
