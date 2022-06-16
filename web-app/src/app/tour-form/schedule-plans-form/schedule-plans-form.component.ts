import { Component, OnInit } from '@angular/core';
import {SchedulePlan} from "../../model/Tour";
import {StepperItem} from "../tour-form.component";
import {TourFormService} from "../tour-form.service";




@Component({
  selector: 'app-schedule-plans-form',
  templateUrl: './schedule-plans-form.component.html',
  styleUrls: ['./schedule-plans-form.component.scss']
})
export class SchedulePlansFormComponent implements OnInit {
  displayedColumns: string[] = ['name', 'startTime', 'arrivalTime', 'source', 'destination', 'actions'];
  plansData: SchedulePlan[] = [];
  stepperList:  StepperItem[] = [
    {name: 'Plan Information', icon: 'details'},
    {name: 'Accommodation', icon: 'local_hotel'},
    {name: 'Foods', icon: 'restaurant_menu'},
    {name: 'Vehicles', icon: 'directions_car'},
    {name: 'Activities', icon: 'av_timer'},

  ];
  activeItem: StepperItem = {name: 'Plan Information', icon: 'details'};

  constructor(private tourFormService: TourFormService) { }

  ngOnInit(): void {
  }

  removePlan(i: number) {

  }

  enableEditPlanMode(i: number) {

  }

  onClickItem(item: StepperItem) {
    this.activeItem = item;
  }

    onBack() {
        this.tourFormService.prevStep();
    }

  onSubmit() {
    this.tourFormService.saveTour();
  }
}
