import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddBikeRoutingModule } from './add-bike-routing.module';
import {AddBikeComponent} from './add-bike.component';


@NgModule({
  declarations: [AddBikeComponent],
  imports: [
    CommonModule,
    AddBikeRoutingModule
  ]
})
export class AddBikeModule { }
