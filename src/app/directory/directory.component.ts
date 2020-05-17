import { Component, OnInit } from '@angular/core';
import {Article, DirectoryService} from './directory.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-directory',
  templateUrl: './directory.component.html',
  styleUrls: ['./directory.component.scss']
})
export class DirectoryComponent implements OnInit {
private listBikes: Article[];
  constructor(private directory: DirectoryService,
              private router: Router) {
  }

  ngOnInit() {
    this.getBikes();
  }

  getBikes() {
    this.directory.getAll().subscribe((data) => {
      console.log(data);
      this.listBikes = data;
    });
  }

  reserver() {
    this.router.navigate(['/reservation']);  }
}
