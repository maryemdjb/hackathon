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
  reserveForm(debut, fin, id_client, id_article): Observable<any> {
    return this.http
      .post(this.authUrl, {id_article, id_client, debut, fin}, {
        headers: new HttpHeaders(),
        observe: 'response'
      } )
      
  }
  // notifEmail(receiver, nom, email_user){
  //   return this.http
  //   .post('http://localhost:8080/sendEmail', {receiver, nom, email_user}, {
  //     headers: new HttpHeaders(),
  //     observe: 'response'
  //   }).toPromise
    
  // }
}
