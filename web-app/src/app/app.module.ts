import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SignInComponent } from './auth/sign-in/sign-in.component';
import { SignOutComponent } from './auth/sign-out/sign-out.component';
import { RegisterComponent } from './auth/register/register.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import {AuthService} from "./auth/auth.service";
import {ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { LoadingComponent } from './shared/loading/loading.component';
import { HomeComponent } from './home/home.component';
import {AppRoutingModule} from "./app-routing.module";
import { ProfileComponent } from './profile/profile.component';
import { ToursComponent } from './tours/tours.component';
import { TourListComponent } from './tours/tour-list/tour-list.component';
import {TourItemComponent} from "./tours/tour-list/tour-item/tour-item.component";
import { MessagesComponent } from './shared/messages/messages.component';
import {LoadingService} from "./shared/loading/loading.service";
import {MessagesService} from "./shared/messages/messages.service";
import { SidebarComponent } from './shared/sidebar/sidebar.component';
import { SearchDropdownComponent } from './shared/input/search-dropdown/search-dropdown.component';
import { DropdownComponent } from './shared/input/dropdown/dropdown.component';
import { ModalBackgroundComponent } from './shared/modal-background/modal-background.component';
import { FiltersComponent } from './tours/tours-filters/tours-filters.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {AuthHttpInterceptor} from "./auth/auth-http.interceptor";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatIconModule} from "@angular/material/icon";
import { ModalComponent } from './shared/modal/modal.component';


@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignOutComponent,
    RegisterComponent,
    NavbarComponent,
    LoadingComponent,
    HomeComponent,
    ProfileComponent,
    ToursComponent,
    TourListComponent,
    TourItemComponent,
    MessagesComponent,
    SidebarComponent,
    SearchDropdownComponent,
    DropdownComponent,
    ModalBackgroundComponent,
    FiltersComponent,
    NotFoundComponent,
    ModalComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatProgressSpinnerModule,
    MatIconModule
  ],
  providers: [AuthService, LoadingService, MessagesService
    ,{provide: HTTP_INTERCEPTORS, useClass: AuthHttpInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
