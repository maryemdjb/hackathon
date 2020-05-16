import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {map, share} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  authUrl = 'http://localhost:8080/reservation/dores';

  constructor(private http: HttpClient, public router: Router) { }
  reserveForm(debut, fin, id_client, id_article): Observable<string> {
    return this.http
      .post<string>(this.authUrl, {id_article, id_client, debut, fin}, {
        headers: new HttpHeaders(),
        observe: 'response'
      } )
      .pipe(
        share(), // <========== YOU HAVE TO SHARE THIS OBSERVABLE TO AVOID MULTIPLE REQUEST BEING SENT SIMULTANEOUSLY
        map(res => {
          console.log(res);
         
         // localStorage.setItem('token', token);
          return res.body;
        })
      );
  }
}
