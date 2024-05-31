import { Injectable } from '@angular/core';
import { Bronik } from '../interfaces/Bronik';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BronikService {
  list = new BehaviorSubject<Bronik[]>([]);
  url: string = "http://localhost:8080/lab6/api/Broniks";

  constructor(private http: HttpClient) { }

  getBroniks(): Observable<Bronik[]> {
    return this.http.get<Bronik[]>(this.url);
  }

  postBronik(bronik: Bronik): Observable<Bronik[]> {
    return this.http.post<Bronik[]>(this.url, bronik);
  }

  putBronik(bronik: Bronik): Observable<Bronik[]> {
    return this.http.put<Bronik[]>(`${this.url}/${bronik.id}`, bronik);
  }

  deleteBronik(bronik: Bronik): Observable<Bronik[]> {
    return this.http.delete<Bronik[]>(`${this.url}/${bronik.id}`);
  }
}
