import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

import {Observable, of, toArray} from "rxjs";
import { catchError } from "rxjs/operators";

import { ButtonModule } from 'primeng/button';

import { DriverService } from '../../service/driver-service';
import { Driver } from '../../service/driver';

@Component({
    selector: 'app-driver-detail',
    templateUrl: './driver-detail.component.html',
    styleUrls: ['./driver-detail.component.scss'],
    imports: [ButtonModule],
    standalone: true
})
export class DriverDetailComponent implements OnInit {

  drivers: Driver[] = [];

  selectedDriver?: Driver;

  constructor(private driverService: DriverService) {
  }

  ngOnInit() {
    this.loadDrivers();
  }

  onSelect(driver: Driver) {
    this.selectedDriver = driver;
  }

  onRefresh() {
    this.loadDrivers();
  }

  private loadDrivers() : void {
    this.driverService.getDrivers()
      .pipe(
        catchError(err => {
          console.error("load drivers failed: ", err);
          return of();
        })
      )
      .subscribe((data: Driver[]) => {
        next: this.drivers = data;
      });
  }
}
