import {Component, Inject, LOCALE_ID, OnInit} from '@angular/core';
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

  constructor(private authService: AuthService
              , private sidebarService: SidebarService
              , @Inject(LOCALE_ID) public locale: string) {
    this.signedin$ = authService.signedin$;
  }

  ngOnInit(): void {
  }

  showSidebar() {
    this.sidebarService.openSidebar();
  }


}
