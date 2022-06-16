import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, CanDeactivate, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {TourFormService} from "./tour-form/tour-form.service";

@Injectable({
  providedIn: 'root'
})
export class TourFormGuard implements CanDeactivate<boolean> {
  constructor(private tourFormService: TourFormService) {}
  canDeactivate(component: boolean
                , currentRoute: ActivatedRouteSnapshot
                , currentState: RouterStateSnapshot
                , nextState?: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    this.tourFormService.clearForm();
    return true; //TODO
  }


}
