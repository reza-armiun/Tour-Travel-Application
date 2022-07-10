import {Component, Inject, LOCALE_ID, OnInit} from '@angular/core';
import {SidebarService} from "./sidebar.service";
import {Observable, of} from "rxjs";
import {Router} from "@angular/router";
import {Profile, ProfileStore} from "../../stores/profile.store";
import {animate, keyframes, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
  animations: [
    trigger('animateSidebar', [
      transition('hide => show', [
        animate("280ms", keyframes([
          style({
            width: '0%'
          }),
          style({
            width: '300px'
          }),
        ]))
      ]),
      transition('show => hide', [
        animate(500, keyframes([
          style({
            width: '300px',
            opacity: 1
          }),
          style({
            width: '0%',
            opacity: 0
          }),
        ]))
      ], )
    ])
  ]
})
export class SidebarComponent implements OnInit {
  showSidebar$ : Observable<boolean> = of(false);
  profile$: Observable<Profile | null>;


  constructor(private sidebarService: SidebarService
              , private router: Router
              , private profileStore: ProfileStore
              , @Inject(LOCALE_ID) public locale: string) {
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
