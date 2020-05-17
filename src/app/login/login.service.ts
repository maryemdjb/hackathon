import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {map, share} from 'rxjs/operators';

export class User {
  username: string;
  email: string;
  password: string;
  accessToken: string;
}

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  authUrl = 'http://localhost:8080/api/auth/signin';

  constructor(private http: HttpClient, public router: Router) {
  }

  getToken(): string {
    return localStorage.getItem('token');
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/login']);
  }

  loginForm(username, password): Observable<string> {
    return this.http
      .post<string>(this.authUrl, {username, password}, {
        headers: new HttpHeaders(),
        observe: 'response'
      } )
      .pipe(
        share(), // <========== YOU HAVE TO SHARE THIS OBSERVABLE TO AVOID MULTIPLE REQUEST BEING SENT SIMULTANEOUSLY
        map(res => {
          console.log(res);
          const token = res.headers.get('accessToken');
          localStorage.setItem('token', token);
          return token;
        })
      );
  }
}
