import { Component, OnInit } from '@angular/core';
import {TourFormService} from "./tour-form.service";
import {Observable} from "rxjs";



export interface  StepperItem  {
  name: string;
  icon: string;
  form?: string;
}

@Component({
  selector: 'app-tour-form',
  templateUrl: './tour-form.component.html',
  styleUrls: ['./tour-form.component.scss'],
})
export class TourFormComponent implements OnInit {
  stepperList:  StepperItem[] = [];
  activeItem$: Observable<StepperItem> ;
  constructor(private tourFormService: TourFormService) {
    this.stepperList = tourFormService.stepperList;
    this.activeItem$ = tourFormService.activeItem$;
  }

  ngOnInit(): void {
  }

  checkInfoForm() {
    if(this.tourFormService.infoForm.invalid) {
      this.tourFormService.infoForm.markAllAsTouched();
      return true;
    }
    return false;
  }
  checkTourismMgForm() {
    if(this.tourFormService.tourismMgForm.invalid) {
      this.tourFormService.tourismMgForm.markAllAsTouched();
      return true;
    }
    return false;
  }

  onClickItem(index: number, item: StepperItem) {
    if(index > 0) {
      let form = this.tourFormService.stepperList[index -1 ].form;
      let invalid  = false;
      if(form == 'info') {
        invalid = this.checkInfoForm();
        if(invalid) return;
      }else if(form == 'tourismManager') {
        invalid = this.checkInfoForm();
        invalid = invalid || this.checkTourismMgForm();
        if(invalid) return;
      }
    }
    this.tourFormService.setActiveItem(index, item);
  }
}
