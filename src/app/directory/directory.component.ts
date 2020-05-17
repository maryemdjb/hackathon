import { Component, OnInit } from '@angular/core';
import {Article, DirectoryService} from './directory.service';

@Component({
  selector: 'app-directory',
  templateUrl: './directory.component.html',
  styleUrls: ['./directory.component.scss']
})
export class DirectoryComponent implements OnInit {
private listBikes: Article[];
  constructor(private directory: DirectoryService) {
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
}
