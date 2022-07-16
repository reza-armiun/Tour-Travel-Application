import { AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from "./auth/auth.service";
import {filter, Subscription} from "rxjs";
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {$localize} from "@angular/localize/init";


export interface MenuItem {
  label: string;
  url: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit, OnDestroy , AfterViewInit{
  title = "TourArm";
  sub: Subscription | undefined;
  menuItems: MenuItem[] = [];
  items: any[] = [];

  constructor(private authService: AuthService
              , private  router: Router
              , private  activatedRoute: ActivatedRoute, private titleService: Title) {
    // titleService.setTitle($localize`${this.title}`);
  }

  ngAfterViewInit(): void {
    // setInterval(() => {
    //   this.items = this.shuffle(this.items);
    //   // console.log('this.shuffle(this.items)', this.items);
    // }, 5000)
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
    for (let i = 0; i <= 7 ; i++) {
      this.items.push(i);
    }
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




  shuffle(array : any[]) {
    let newArray = [...array];
    let currentIndex = newArray.length,  randomIndex;
    // While there remain elements to shuffle.
    while (currentIndex != 0) {
      // Pick a remaining element.
      randomIndex = Math.floor(Math.random() * currentIndex);
      currentIndex--;
      // And swap it with the current element.
      [newArray[currentIndex], newArray[randomIndex]] = [
        newArray[randomIndex], newArray[currentIndex]];
    }

    return newArray;
  }




}
