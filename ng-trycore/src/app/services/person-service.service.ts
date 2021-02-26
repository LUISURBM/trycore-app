import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from '../model/person';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonServiceService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'https://8080-gold-quokka-l3ztlw2j.ws-us03.gitpod.io/persons';
  }

  public findAll(): Observable<Person[]> {
    return this.http.get<Person[]>(this.usersUrl);
  }

  public save(user: Person) {
    return this.http.post<Person>(this.usersUrl, user);
  }
}
