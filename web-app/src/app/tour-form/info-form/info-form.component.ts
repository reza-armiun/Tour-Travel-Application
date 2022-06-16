import { Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TourFormService} from "../tour-form.service";
import {BehaviorSubject, Observable, Subscription} from "rxjs";

@Component({
  selector: 'app-info-form',
  templateUrl: './info-form.component.html',
  styleUrls: ['./info-form.component.scss']
})
export class InfoFormComponent implements OnInit, OnDestroy {
  sub: Subscription | undefined;
  form: FormGroup;


  get imgUrl() {
    return this.form.get('imgUrl');
  }


  constructor(private fb: FormBuilder, private tourFormService: TourFormService) {
   this.form = tourFormService.infoForm;

  }

  ngOnInit(): void {
  }


  onSubmit() {
    if(this.form.invalid) return;

    this.tourFormService.nextStep();
  }

  ngOnDestroy(): void {
      this.sub?.unsubscribe();
  }
}
