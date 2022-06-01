import { Component, OnInit } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {AuthService} from "../../auth/auth.service";
import {SidebarService} from "../sidebar/sidebar.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  signedin$: BehaviorSubject<boolean> | null;

  constructor(private authService: AuthService, private sidebarService: SidebarService) {
    this.signedin$ = authService.signedin$;
  }

  ngOnInit(): void {
  }

  showSidebar() {
    this.sidebarService.openSidebar();
  }
}
