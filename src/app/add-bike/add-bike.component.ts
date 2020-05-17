import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {AddBikeService} from './add-bike.service';

@Component({
  selector: 'app-add-bike',
  templateUrl: './add-bike.component.html',
  styleUrls: ['./add-bike.component.scss']
})
export class AddBikeComponent implements OnInit {
  model: any = {};
  fileToUpload: File = null;
  constructor(private formBuilder: FormBuilder,private addBikeService: AddBikeService,) { }

  ngOnInit() {
  }
  handleFileInput(files: FileList) {
    console.log("cccccccccc");
    
    this.fileToUpload = files.item(0);
    this.addBikeService.postFile(this.fileToUpload).subscribe(res=>{console.log("perfect")});
    

}
add(){


  this.addBikeService.postArticle(this.model.nom, this.model.location,this.model.prix,this.model.marque,this.model.etat)
  .subscribe(res=>{console.log("good");
  })

}

}
