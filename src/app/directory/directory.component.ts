import { Component, OnInit } from '@angular/core';
import {Article, DirectoryService} from './directory.service';
import {Router} from '@angular/router';
import {MatDialog, MatDialogConfig} from '@angular/material';
import {ReservationComponent} from '../reservation/reservation.component';
import {ModalComponent} from './modal/modal.component';

@Component({
  selector: 'app-directory',
  templateUrl: './directory.component.html',
  styleUrls: ['./directory.component.scss']
})
export class DirectoryComponent implements OnInit {
  private listBikes: Article[];

  constructor(private directory: DirectoryService,
              private router: Router,
              public matDialog: MatDialog) {
  }

  ngOnInit() {
    //   this.getBikes();
  }

  getBikes() {
    this.directory.getAll().subscribe((data) => {
      console.log(data);
      this.listBikes = data;
    });
  }

  reserver() {
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = 'modal-component';
    dialogConfig.height = '350px';
    dialogConfig.width = '600px';
    const modalDialog = this.matDialog.open(ModalComponent, dialogConfig);
  }
}
