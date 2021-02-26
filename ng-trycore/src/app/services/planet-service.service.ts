import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Planet } from '../model/planet';

@Injectable({
  providedIn: 'root'
})
export class PlanetServiceService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'https://8080-gold-quokka-l3ztlw2j.ws-us03.gitpod.io/planets';
  }

  public findAll(): Observable<Planet[]> {
    return this.http.get<Planet[]>(this.usersUrl);
  }

  public save(user: Planet) {
    return this.http.post<Planet>(this.usersUrl, user);
  }
}
