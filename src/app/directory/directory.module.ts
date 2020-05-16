import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DirectoryRoutingModule } from './directory-routing.module';
import {DirectoryComponent} from './directory.component';
import {HomeModule} from '../home/home.module';


@NgModule({
  declarations: [DirectoryComponent],
  imports: [
    CommonModule,
    DirectoryRoutingModule,
    HomeModule
  ]
})
export class DirectoryModule { }
