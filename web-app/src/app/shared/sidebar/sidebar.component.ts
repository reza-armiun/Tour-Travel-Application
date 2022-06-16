import { Component, OnInit } from '@angular/core';
import {SidebarService} from "./sidebar.service";
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {Profile, ProfileStore} from "../../stores/profile.store";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  showSidebar$ : Observable<boolean> | undefined;
  profile$: Observable<Profile | null>;
  constructor(private sidebarService: SidebarService
              , private router: Router
              , private profileStore: ProfileStore) {
    this.profile$ = profileStore.profile$;
  }

  ngOnInit(): void {
    this.showSidebar$ = this.sidebarService.showSidebar$;

  }

    closeSidebar() {
    this.sidebarService.hideSidebar();
    }

  onSignout() {
    this.router.navigateByUrl('/signout')
      .then(_ => this.sidebarService.hideSidebar());
  }
}
