import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {TourFormService} from "../tour-form.service";

@Component({
  selector: 'app-tourism-manager-form',
  templateUrl: './tourism-manager-form.component.html',
  styleUrls: ['./tourism-manager-form.component.scss']
})
export class TourismManagerFormComponent implements OnInit {
  form: FormGroup ;


  constructor( private tourFormService: TourFormService) {
    this.form = tourFormService.tourismMgForm;
  }

  ngOnInit(): void {
  }

  onSubmit() {

    if(this.form.invalid) return;

    this.tourFormService.nextStep()
  }

  onBack() {
    this.tourFormService.prevStep()

  }
}
