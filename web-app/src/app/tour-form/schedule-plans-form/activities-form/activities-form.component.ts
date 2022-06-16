import { Component, OnInit } from '@angular/core';
import {Activity} from "../../../model/Activity";
import {CdkDragDrop, moveItemInArray} from "@angular/cdk/drag-drop";
import {TourFormService} from "../../tour-form.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

interface ActivityType {
  name: string;
  value: string;
}

const newActivityFormGrp = () => new FormGroup({
  name: new FormControl(''),
  type: new FormControl(''),
  startAt: new FormControl(''),
  endAt: new FormControl(''),
})


@Component({
  selector: 'app-activities-form',
  templateUrl: './activities-form.component.html',
  styleUrls: ['./activities-form.component.scss']
})
export class ActivitiesFormComponent implements OnInit {
  form: FormGroup = newActivityFormGrp();

  types: ActivityType [] = [
    {name: 'Desertification', value: 'DESERTIFICATION'},
    {name: 'Museum Visitation', value: 'MUSEUM_VISITATION'},
    {name: 'Mountaineering', value: 'MOUNTAINEERING'},
    {name: 'Walking', value: 'WALKING'},
    {name: 'Swimming', value: 'SWIMMING'},
  ];

  private activityList: Activity[] = [];
  activityInfos: any[] = this.activityList.map(value => ({name: value.name, type: value.type}));
  scheduleList: any[] = this.activityList.map(value => ({startAt: value.startAt, endAt: value.endAt}));

  constructor(private tourFormService: TourFormService, private fb: FormBuilder) {
    this.activityList = tourFormService.activities;
    this.activityInfos = this.activityList.map(value => ({name: value.name, type: value.type}));
    this.scheduleList = this.activityList.map(value => ({startAt: value.startAt, endAt: value.endAt}));

    // tourFormService.getActivitiesCallback(this.activities);
  }

  ngOnInit(): void {
  }

  get activities(): Activity[] {
    return this.activityInfos?.map((info, index) => {
      const schedule = this.scheduleList[index];
      return ({name: info.name, type: info.type
        , startAt: schedule.startAt, endAt: schedule.endAt });
    });
  }

  dropScheduleList(event: CdkDragDrop<any>) {
    moveItemInArray(this.scheduleList , event.previousIndex, event.currentIndex);
    this.tourFormService.setActivities(this.activities);
  }

  dropInfoList(event: CdkDragDrop<any>) {
    moveItemInArray(this.activityInfos , event.previousIndex, event.currentIndex);
    this.tourFormService.setActivities(this.activities);
  }

  onAddActivity() {
    if(this.form.invalid) return;
    const newActivity = this.form.value;
    this.form.reset();
    this.form = newActivityFormGrp();
    this.activityList.push(newActivity);
    this.activityInfos= this.activityList.map(value => ({name: value.name, type: value.type}));
    this.scheduleList= this.activityList.map(value => ({startAt: value.startAt, endAt: value.endAt}));


    this.tourFormService.setActivities(this.activities);
  }
}
