import { Component, OnInit } from '@angular/core';



export interface  StepperItem  {
  name: string;
  icon: string;
}
@Component({
  selector: 'app-tour-form',
  templateUrl: './tour-form.component.html',
  styleUrls: ['./tour-form.component.scss']
})
export class TourFormComponent implements OnInit {
  stepperList:  StepperItem[] = [
    {name: 'Tour Information', icon: 'info'},
    {name: 'Tourism Manger', icon: 'person_pin'},
    {name: 'Schedule plans', icon: 'schedule'},
  ];
  activeItem: StepperItem = {name: 'Tour Information', icon: 'info'};
  constructor() { }

  ngOnInit(): void {
  }

  onClickItem(item: StepperItem) {
    this.activeItem = item;
  }
}
