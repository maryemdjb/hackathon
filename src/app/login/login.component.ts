import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {LoginService} from './login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  model: any = {};


  constructor(private formBuilder: FormBuilder,
              private loginService: LoginService,
              private router: Router) {}

  ngOnInit() {
  }
  login() {
    this.loginService.loginForm(this.model.username, this.model.password)
      .subscribe(response => {
        // console.log(response);
        if (response) {
          localStorage.setItem('isLoggedin', 'true');
          localStorage.setItem('user', this.model.username);
        //  this.router.navigate(['/dashboard']);
          // console.log(this.model.username, this.model.password);
        }
      }, error => {
        console.error(error);
      });
  }
}
