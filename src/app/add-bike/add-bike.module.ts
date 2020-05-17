import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddBikeRoutingModule } from './add-bike-routing.module';
import {AddBikeComponent} from './add-bike.component';
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import {AddBikeService} from './add-bike.service';

@NgModule({
  declarations: [AddBikeComponent],
  imports: [
    CommonModule,
    AddBikeRoutingModule,
    OwlDateTimeModule,
     OwlNativeDateTimeModule,
     FormsModule, 
     ReactiveFormsModule,
     HttpClientModule
  ],
  providers :[AddBikeService]
})
export class AddBikeModule { }
