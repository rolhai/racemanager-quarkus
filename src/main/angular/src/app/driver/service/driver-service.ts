import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Driver } from './driver';


@Injectable({
  providedIn: 'root'
})
export class DriverService {

  constructor(private http: HttpClient) {
  }

  getDrivers(): Observable<Driver[]> {
    return this.http.get<Driver[]>(`/api/drivers/`);
  }
}
