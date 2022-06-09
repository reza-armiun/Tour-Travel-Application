import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from "../auth.service";
import {FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";
import { Router} from "@angular/router";
import {Subscription, tap} from "rxjs";
import {LoadingService} from "../../shared/loading/loading.service";
import {MessagesService} from "../../shared/messages/messages.service";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit, OnDestroy {
  subs: Subscription | undefined;
  authSubs: Subscription | undefined;


  authForm = new FormGroup({
    username: new FormControl('', {validators: [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(20),
        Validators.pattern(/^[a-z]+[a-z0-9]*$/)
      ], updateOn: 'blur'}),
    password: new FormControl('', {validators: [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(20)
      ], updateOn: 'submit'})
  });

  get username() {return this.authForm.get('username');}
  get password() {return this.authForm.get('password');}

  constructor(private authService: AuthService, private router: Router, private loadingService: LoadingService, private messageService: MessagesService) {
  }

  ngOnInit() {
    this.authSubs = this.authService.signedin$.subscribe(isSignedIn => {
      if(isSignedIn) this.router.navigateByUrl('');
    });
  }

  onSubmit() {
    if (this.authForm.invalid) {
      return;
    }
    this.subs = this.loadingService.showLoadingUntilCompletion(this.authService.signin(this.authForm.value)).subscribe({
      next: () => {
        this.router.navigate(['./'], )
      },
      error: ({error}) => {
        // if (error.username || error.password) {
          this.authForm.setErrors({credentials: true});
        // }
      }
    });
  }


  ngOnDestroy(): void {
    this.subs?.unsubscribe();
    this.authSubs?.unsubscribe();
  }


}
