import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {SignInComponent} from "./auth/sign-in/sign-in.component";
import {SignOutComponent} from "./auth/sign-out/sign-out.component";
import {ProfileComponent} from "./profile/profile.component";
import {RegisterComponent} from "./auth/register/register.component";
import {NotFoundComponent} from "./not-found/not-found.component";
import {BookingDetailsComponent} from "./booking-details/booking-details.component";
import {TourDetailsComponent} from "./booking-details/tour-details/tour-details.component";
import {LazyAuthGuard} from "./lazy-auth.guard";
import {AuthGuard} from "./auth.guard";


const routes: Routes = [
  {path: '',canActivate: [AuthGuard],  component: HomeComponent, pathMatch: 'full'},
  {path: 'signin', component: SignInComponent},
  {path: 'signout', component: SignOutComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'profile', canActivate: [AuthGuard],  component: ProfileComponent},
  {path: 'booking/:id' , canLoad: [LazyAuthGuard]
    , loadChildren: () => import('./booking-details/booking-details.module').then(mod => mod.BookingDetailsModule)},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
