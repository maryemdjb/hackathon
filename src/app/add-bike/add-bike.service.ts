import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {map, share} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AddBikeService {
  authUrl = 'http://localhost:8080/article/deposer/image';

  constructor(private http: HttpClient, public router: Router) {
  }

postFile(fileToUpload: File): Observable<any> {
  const endpoint = 'your-destination-url';
  const formData: FormData = new FormData();
  formData.append('file', fileToUpload);
  return this.http
    .post(this.authUrl, formData)
}
postArticle(nom,location,prix,marque,etat): Observable<any> {
  const endpoint = 'http://localhost:8080/article/deposer';
  
  return this.http
    .post(endpoint, {nom,location,prix,marque,etat})
}}