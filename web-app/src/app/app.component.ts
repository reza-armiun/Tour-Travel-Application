import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from "./auth/auth.service";
import {filter, Subscription} from "rxjs";
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";


export interface MenuItem {
  label: string;
  url: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit, OnDestroy{
  sub: Subscription | undefined;
  menuItems: MenuItem[] = [];

  constructor(private authService: AuthService
              , private  router: Router
              , private  activatedRoute: ActivatedRoute) {
  }
  private createBreadcrumbs(route: ActivatedRoute, url: string = '', breadcrumbs: MenuItem[] = []): MenuItem[] | any {
    const children: ActivatedRoute[] = route.children;

    if (children.length === 0) {
      return breadcrumbs;
    }

    for (const child of children) {
      const routeURL: string = child.snapshot.url.map(segment => segment.path).join('/');
      if (routeURL !== '') {
        url += `/${routeURL}`;
      }

      const label = child.snapshot.data['breadCrumb'];
      if (label != null) {
        breadcrumbs.push({label, url});
      }

      return this.createBreadcrumbs(child, url, breadcrumbs);
    }
  }
  ngOnInit(): void {
    this.sub = this.authService.checkAuth()
      .subscribe(() => {});
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe(() => {
        let breadcrumbs = this.createBreadcrumbs(this.activatedRoute.root);
        return this.menuItems = breadcrumbs;
      });

  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }



}
