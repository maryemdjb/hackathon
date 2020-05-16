import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddBikeRoutingModule } from './add-bike-routing.module';
import {AddBikeComponent} from './add-bike.component';
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';


@NgModule({
  declarations: [AddBikeComponent],
  imports: [
    CommonModule,
    AddBikeRoutingModule,
    OwlDateTimeModule,
     OwlNativeDateTimeModule
  ]
})
export class AddBikeModule { }
