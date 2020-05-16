import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import {HomeComponent} from './home.component';
import {HeaderComponent} from '../shared/header/header.component';
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';


@NgModule({
  declarations: [HomeComponent, HeaderComponent],
  exports: [
    HeaderComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule
  ]
})
export class HomeModule { }
