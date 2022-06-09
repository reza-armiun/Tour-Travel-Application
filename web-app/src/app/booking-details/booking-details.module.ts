import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {TourDetailsComponent} from "./tour-details/tour-details.component";
import {BookingDetailsComponent} from "./booking-details.component";
import {AccommodationComponent} from "./tour-details/accommodation/accommodation.component";
import {VehicleComponent} from "./tour-details/vehicle/vehicle.component";
import {BookingDetailsRoutingModule} from "./booking-details-routing.module";
import {MatTabsModule} from "@angular/material/tabs";
import {MatDividerModule} from "@angular/material/divider";
import {MatCardModule} from "@angular/material/card";
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import { FoodComponent } from './tour-details/food/food.component';
import { ActivityComponent } from './tour-details/activity/activity.component';


@NgModule({
  declarations: [
    TourDetailsComponent,
    BookingDetailsComponent,
    AccommodationComponent,
    VehicleComponent,
    FoodComponent,
    ActivityComponent
  ],
  imports : [
    MatButtonModule,
    MatDividerModule,
    MatCardModule,
    MatTableModule,
    MatTabsModule,
    CommonModule,
    BookingDetailsRoutingModule
  ]
})
export class BookingDetailsModule {

}
