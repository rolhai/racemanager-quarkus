import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DriverService } from '../../service/driver-service';
import { Driver } from '../../service/driver';
import {Observable, of} from "rxjs";
import { catchError } from "rxjs/operators";

@Component({
    selector: 'app-driver-detail',
    templateUrl: './driver-detail.component.html',
    styleUrls: ['./driver-detail.component.scss'],
    standalone: false
})
export class DriverDetailComponent implements OnInit {

  drivers?: Observable<Driver[]>;

  selectedDriver?: Driver;

  constructor(private driverService: DriverService) { 
  }

  ngOnInit() {
    this.loadDrivers();
  }

  onSelect(driver: Driver): void {
    this.selectedDriver = driver;
  }

  private loadDrivers() : void {
    this.drivers = this.driverService.getDrivers().pipe(
      catchError((err) => {
        console.error("load drivers failed: ", err);
        return of();
      })
    );
  }
}