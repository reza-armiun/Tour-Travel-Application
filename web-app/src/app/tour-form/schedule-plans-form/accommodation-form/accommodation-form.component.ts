import { Component, OnInit } from '@angular/core';
import {FormGroup} from "@angular/forms";
import {TourFormService} from "../../tour-form.service";

@Component({
  selector: 'app-accommodation-form',
  templateUrl: './accommodation-form.component.html',
  styleUrls: ['./accommodation-form.component.scss']
})
export class AccommodationFormComponent implements OnInit {
  form: FormGroup;
  constructor(private tourFormService: TourFormService) {
    this.form = tourFormService.accommodationForm;
  }

  ngOnInit(): void {
  }

}
