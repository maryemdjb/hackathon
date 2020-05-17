import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
export interface Article {
  id: string;
  nom: string;
  images: string[];
  dispo: string;
  prix: string;
}
@Injectable({
  providedIn: 'root'
})
export class DirectoryService {
  private allBikes = 'http://localhost:8080/article/all';

  constructor(private http: HttpClient) { }


  getAll(): Observable<Article[]> {
    // console.log(this.httpOptions);
    return this.http
      .get<Article[]>(this.allBikes );

  }
}
