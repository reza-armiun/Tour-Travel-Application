import {Component, Input, OnInit} from '@angular/core';
import {Food, FoodOrder} from "../../../model/FoodOrder";
import {Activity} from "../../../model/Activity";

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent implements OnInit {
  @Input()activities: Activity[] | undefined = [];

  get activityData () {
    return  this.activities ?? [];
  }



  displayedColumns: string[] = ['name', 'type', 'startAt', 'endAt'];

  constructor() { }

  ngOnInit(): void {
  }

}
