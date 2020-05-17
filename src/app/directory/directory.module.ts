import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DirectoryRoutingModule } from './directory-routing.module';
import {DirectoryComponent} from './directory.component';
import {HomeModule} from '../home/home.module';
import {DirectoryService} from './directory.service';
import {HttpClientModule} from '@angular/common/http';
import {MatDialogModule} from '@angular/material/dialog';
import {OwlDateTimeModule, OwlNativeDateTimeModule} from 'ng-pick-datetime';
import {MatStepperModule} from '@angular/material/stepper';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material';
import { ModalComponent } from './modal/modal.component';
;

@NgModule({
  declarations: [DirectoryComponent, ModalComponent],
  imports: [
    CommonModule,
    DirectoryRoutingModule,
    HomeModule,
    HttpClientModule,
    MatDialogModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    MatStepperModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatButtonModule,

  ],
  providers: [DirectoryService],
  entryComponents: [ModalComponent]

})
export class DirectoryModule { }
