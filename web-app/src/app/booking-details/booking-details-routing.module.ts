import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {BookingDetailsComponent} from "./booking-details.component";
import {TourDetailsComponent} from "./tour-details/tour-details.component";


const routes: Routes = [
  {path: '', component: BookingDetailsComponent, data: {
      breadCrumb: null
    } , pathMatch: 'full'},
  {path: 'tour/:id', component: TourDetailsComponent, data: {
      breadCrumb: 'tour'
    }},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookingDetailsRoutingModule {

}
