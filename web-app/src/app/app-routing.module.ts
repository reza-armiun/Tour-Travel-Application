import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {SignInComponent} from "./auth/sign-in/sign-in.component";
import {SignOutComponent} from "./auth/sign-out/sign-out.component";
import {ProfileComponent} from "./profile/profile.component";
import {RegisterComponent} from "./auth/register/register.component";
import {NotFoundComponent} from "./not-found/not-found.component";


const routes: Routes = [
  {path: '', component: HomeComponent, pathMatch: 'full'},
  {path: 'signin', component: SignInComponent},
  {path: 'signout', component: SignOutComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'profile', component: ProfileComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
