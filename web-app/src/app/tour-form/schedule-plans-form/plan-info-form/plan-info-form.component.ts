import { Component, OnInit } from '@angular/core';
import {TourFormService} from "../../tour-form.service";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-plan-info-form',
  templateUrl: './plan-info-form.component.html',
  styleUrls: ['./plan-info-form.component.scss']
})
export class PlanInfoFormComponent implements OnInit {
  form: FormGroup;

  constructor(private tourFormService: TourFormService) {
    this.form = tourFormService.schedulePlanInfoForm;
  }

  ngOnInit(): void {
  }


}
