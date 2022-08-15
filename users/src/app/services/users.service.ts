import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private URL = environment.API_URL;

  constructor(private http: HttpClient) { }

  public getUsers(): Observable<any> {
    return this.http.get(`${this.URL}/users`);
  }

  public getUserStatus(): Observable<any> {
    return this.http.get(`${this.URL}/status`);
  }

  public saveUser(user: any): Observable<any> {
    return this.http.post(`${this.URL}/users`, user);
  }

}
