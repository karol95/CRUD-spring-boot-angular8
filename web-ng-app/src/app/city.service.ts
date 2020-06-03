import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};


@Injectable({
  providedIn: 'root'
})
export class CityService {
  private baseUrl = 'http://localhost:8090/example/v1/cities';

  constructor(private http: HttpClient) { }

  getCity(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  // tslint:disable-next-line: ban-types
  createCity(city: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, city);
  }

  // tslint:disable-next-line: ban-types
  updateCity(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteCity(id: number): Observable<any> {
    httpOptions.headers.append("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    return this.http.delete(`${this.baseUrl}/${id}`,httpOptions);
  }

  getCitiesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }


}
