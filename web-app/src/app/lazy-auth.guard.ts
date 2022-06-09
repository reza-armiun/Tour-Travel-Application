import { Injectable } from '@angular/core';
import {
  CanLoad,
  Route, Router,
  UrlSegment,
} from '@angular/router';
import {delay, first, Observable, skipWhile, take, tap,} from 'rxjs';
import {AuthService} from "./auth/auth.service";

@Injectable({
  providedIn: 'root'
})
export class LazyAuthGuard implements CanLoad {
  constructor(private authService: AuthService) {}

  canLoad(
    route: Route,
    segments: UrlSegment[]
  ): Observable<boolean> | Promise<boolean> | boolean {
    return this.authService.signedin$.pipe(
      // first(),
      // tap(signin => {
      //   console.log('lazy auth guard ', signin);
      //   if(!signin) this.router.navigateByUrl('/signin');
      // })
      skipWhile(value => !value),
      take(1),
    );
  }
}
