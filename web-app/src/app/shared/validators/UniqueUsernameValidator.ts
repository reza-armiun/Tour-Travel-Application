import {Injectable} from "@angular/core";
import {AbstractControl, AsyncValidator, ValidationErrors} from "@angular/forms";
import {catchError, delay, map, Observable, of, tap} from "rxjs";
import {AuthService} from "../../auth/auth.service";


@Injectable({
  providedIn: 'root'
})
export class UniqueUsernameValidator implements AsyncValidator{
  constructor(private authService: AuthService) {}
  validate(control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> {
    return this.authService.usernameExist(control.value).pipe(
      delay(1000),
      map(isTaken =>  isTaken ? {'notUniqueUsername': true} : null),
      catchError(_ => of(null))
    );
  }

}
