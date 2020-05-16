import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {map, share} from 'rxjs/operators';
export class User {
  username: string;
  email: string;
  password: string;
  cin: string;
  phone: string;
}
@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  authUrl = 'http://localhost:8080/api/auth/signup';

  constructor(private http: HttpClient, public router: Router) { }
  registerForm(username, password, cin,phone,email): Observable<string> {
    return this.http
      .post<string>(this.authUrl, {username, email,password,cin,phone}, {
        headers: new HttpHeaders(),
        observe: 'response'
      } )
      .pipe(
        share(), // <========== YOU HAVE TO SHARE THIS OBSERVABLE TO AVOID MULTIPLE REQUEST BEING SENT SIMULTANEOUSLY
        map(res => {
          console.log(res);
          const token = res.headers.get('accessToken');
         // localStorage.setItem('token', token);
          return token;
        })
      );
  }
}
