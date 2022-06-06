import { Injectable } from '@angular/core';
import {
  CanLoad,
  Route, Router,
  UrlSegment,
} from '@angular/router';
import {Observable, skipWhile, take, tap} from 'rxjs';
import {AuthService} from "./auth/auth.service";

@Injectable({
  providedIn: 'root'
})
export class LazyAuthGuard implements CanLoad {
  constructor(private authService: AuthService, private router: Router) {}

  canLoad(
    route: Route,
    segments: UrlSegment[]
  ): Observable<boolean> | Promise<boolean> | boolean {
    return this.authService.signedin$.pipe(
      skipWhile(value => value === null),
      take(1)
    );
  }
}
