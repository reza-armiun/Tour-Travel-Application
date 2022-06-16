import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";
import {LoadingService} from "../../shared/loading/loading.service";
import {MatchPassword} from "../../shared/validators/MatchPassword";
import {UniqueUsernameValidator} from "../../shared/validators/UniqueUsernameValidator";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  subs: Subscription | undefined;

  statusChecks: boolean = false;


  constructor( private authService: AuthService
              , private router: Router
              , private loadingService: LoadingService
              , private matchPassword: MatchPassword
              , private uniqueUsernameValidator: UniqueUsernameValidator) {
  }



  authForm = new FormGroup({
    name: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
      Validators.maxLength(20),
      Validators.pattern(/^[a-z0-9]+$/)
    ]),
    email: new FormControl('', [
      Validators.required,
      Validators.email
    ]),
    username: new FormControl('', {updateOn: 'blur', validators: [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(20),
        Validators.pattern(/^[a-z0-9]+$/)
      ], asyncValidators: [this.uniqueUsernameValidator.validate.bind(this.uniqueUsernameValidator)]}, ),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(4),
      Validators.maxLength(20)
    ]),
    rePassword: new FormControl('', {updateOn: 'submit', validators: [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(20),
      ]}, )
  }, {validators: [
      this.matchPassword.validate
    ]});


  get name() { return  this.authForm.get('name'); }
  get email() { return  this.authForm.get('email'); }
  get username() { return  this.authForm.get('username'); }
  get password() { return  this.authForm.get('password'); }
  get rePassword() { return  this.authForm.get('rePassword'); }

  ngOnDestroy(): void {
    this.subs?.unsubscribe();
  }

  ngOnInit() {
  }

  onSubmit() {
    if (this.authForm.invalid) {
      return;
    }
    this.subs = this.loadingService.showLoadingUntilCompletion(this.authService.signup(this.authForm.value)).subscribe({
      next: ( value) => {
        this.router.navigateByUrl("/signin");
      },
      error: ({error}) => {
          this.authForm.setErrors({invalidInput: true});
      }
    });
  }

  enableStatusChecks() {
     this.statusChecks = true;
     return true;
  }

  disableStatusChecks() {
     this.statusChecks = false;
    return true;
  }
}
