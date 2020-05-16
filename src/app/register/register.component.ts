import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {RegisterService} from './register.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  model: any = {};
  constructor(private formBuilder: FormBuilder ,private registerService: RegisterService, private router:Router ) { }

  ngOnInit() {
  }

  register() {
    this.registerService.registerForm(this.model.username, this.model.password, this.model.cin,this.model.phone,this.model.email)
      .subscribe(response => {
        console.log(response);
        alert("Votre inscription est effectuée avec succès")
       
          
         this.router.navigate(['/home']);
          // console.log(this.model.username, this.model.password);
        
      }, error => {
        console.error(error);
      });
  }

}
