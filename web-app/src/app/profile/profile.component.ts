import { Component, OnInit } from '@angular/core';
import {Profile, ProfileStore} from "./profile.store";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../auth/auth.service";
import {Subscription} from "rxjs";
import {LoadingService} from "../shared/loading/loading.service";
import {MessagesService} from "../shared/messages/messages.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profile: Profile | undefined;
  showPasswordModal = false;
  passwordFormSub: Subscription | undefined;


  profileForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', [
      Validators.required,
      Validators.minLength(4),
      Validators.maxLength(20),
      Validators.pattern(/^[a-z]+[a-z0-9]*$/)
    ]),
    username: new FormControl('', [
      Validators.required,
      Validators.minLength(4),
      Validators.maxLength(20)
    ]),
    phone: new FormControl('', []),
    email: new FormControl('', [
      Validators.email
    ]),
    nationalId: new FormControl('', []),
    imageUrl: new FormControl('',),
    address: new FormGroup({
      street: new FormControl(''),
      postalCode: new FormControl(''),
      city: new FormControl(''),
      zipCode: new FormControl(''),
      country: new FormControl(''),
      countryCode: new FormControl(''),
    }, [])
  });


  passwordForm = new FormGroup({
    oldPassword: new FormControl('', {validators: [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(20)
      ]}),
    password: new FormControl('', {validators: [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(20)
      ]}),
    rePassword: new FormControl('', {validators: [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(20)
      ]})

  });



  constructor(private profileStore: ProfileStore
              , private authService: AuthService
              , private loadingService: LoadingService
              , private messageService: MessagesService) { }

  ngOnInit(): void {
    this.profileStore.profile$.subscribe(profile => {
      if(profile){
        this.profile= profile;
        this.profileForm.patchValue({...profile}, );
      }
    })
  }

  showFilePicker() {

  }

  setFocusOnField($event: FocusEvent) {
    (<HTMLElement>($event.currentTarget)).parentElement?.classList.toggle('field-focus');
  }
  removeFocusOnField($event: FocusEvent) {
    (<HTMLElement>($event.currentTarget)).parentElement?.classList.toggle('field-focus');
  }

  changePasswordHandler() {
    if (this.passwordForm.invalid) {
      this.showPasswordModal = false;
      return;
    }
    this.loadingService.showLoadingUntilCompletion(this.authService.changePassword({...this.passwordForm.value, username: this.profile?.username}))
      .subscribe({
        next: () => {
          this.passwordForm.reset();
          this.showPasswordModal = false;
          this.messageService.showSuccessForPeriodOfTime(2000, 'Password changed successfully');
        },
        error: ({error}) => {
          this.passwordForm.reset();
          this.passwordForm.setErrors({credentials: true});
          this.messageService.showErrorForPeriodOfTime(2000 , 'Failed to change password');
        },
      })
  }


}
