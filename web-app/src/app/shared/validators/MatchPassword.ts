import {Injectable} from "@angular/core";
import {AbstractControl, ValidationErrors, Validator} from "@angular/forms";


@Injectable({
  providedIn: 'root'
})
export class MatchPassword implements Validator{
  validate(control: AbstractControl): ValidationErrors | null {
    const {password, rePassword} = control.value;
    if(password === rePassword) return null;

    return {'passwordsNotMatch' : true};
  }

}
