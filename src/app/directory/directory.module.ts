import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DirectoryRoutingModule } from './directory-routing.module';
import {DirectoryComponent} from './directory.component';
import {HomeModule} from '../home/home.module';
import {DirectoryService} from './directory.service';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [DirectoryComponent],
  imports: [
    CommonModule,
    DirectoryRoutingModule,
    HomeModule,
    HttpClientModule
  ],
  providers: [DirectoryService]
})
export class DirectoryModule { }
