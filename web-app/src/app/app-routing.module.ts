import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {SignInComponent} from "./auth/sign-in/sign-in.component";
import {SignOutComponent} from "./auth/sign-out/sign-out.component";
import {ProfileComponent} from "./profile/profile.component";
import {RegisterComponent} from "./auth/register/register.component";
import {NotFoundComponent} from "./not-found/not-found.component";
import {LazyAuthGuard} from "./lazy-auth.guard";
import {AuthGuard} from "./auth.guard";
import {ToursComponent} from "./tours/tours.component";
import {BookingFormComponent} from "./booking-form/booking-form.component";
import {TourFormComponent} from "./tour-form/tour-form.component";
import {TourFormGuard} from "./tour-form.guard";


const routes: Routes = [
  {path: '', canActivate: [AuthGuard], component: HomeComponent, pathMatch: 'full'},
  {path: 'signin', component: SignInComponent},
  {path: 'signout', component: SignOutComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'tour/save', component: TourFormComponent, canDeactivate: [TourFormGuard], data: {
      breadCrumb: 'tour'
    }
  },
  {
    path: 'profile', canActivate: [AuthGuard], data: {
      breadCrumb: 'profile'
    }
    , component: ProfileComponent
  },
  {
    path: 'tour', canActivate: [AuthGuard], data: {
      breadCrumb: 'tour'
    }
    , component: ToursComponent
  },
  {
    path: 'booking', canActivate: [AuthGuard], data: {
      breadCrumb: 'booking'
    }
    , component: BookingFormComponent
  },
  {
    path: 'booking/:id', canLoad: [LazyAuthGuard], data: {
      breadCrumb: 'booking'
    }
    , loadChildren: () => import('./booking-details/booking-details.module').then(mod => mod.BookingDetailsModule)
  },
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
