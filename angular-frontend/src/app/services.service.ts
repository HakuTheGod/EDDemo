import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root' // Ensure the service is provided in the root
})
export class ServicesService {
  private apiUrl = 'http://localhost:8080/api/users'; // Adjust URL as necessary
  private postUserUrl = 'http://localhost:8080/api/user';

  constructor(private httpClient: HttpClient) { }

  getUsers(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.apiUrl);
  }

  addUser(user: any): Observable<any> {
    return this.httpClient.post<any>(this.postUserUrl, user);
  }
}
