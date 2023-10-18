import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DriverDetailComponent } from './driver/comp/driver-detail/driver-detail.component';

const routes: Routes = [
  { path: "driverDetail", component: DriverDetailComponent },
  { path: "", redirectTo: "/driverDetail", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

