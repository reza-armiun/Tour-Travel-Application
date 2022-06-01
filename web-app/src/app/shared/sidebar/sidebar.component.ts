import { Component, OnInit } from '@angular/core';
import {SidebarService} from "./sidebar.service";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  showSidebar$ : Observable<boolean> | undefined;
  constructor(private sidebarService: SidebarService, private router: Router) { }

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
