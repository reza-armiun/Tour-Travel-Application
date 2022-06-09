import {Component, Input, OnInit} from '@angular/core';
import {AccommodationOrder} from "../../../model/AccommodationOrder";

@Component({
  selector: 'app-accommodation',
  templateUrl: './accommodation.component.html',
  styleUrls: ['./accommodation.component.css']
})
export class AccommodationComponent implements OnInit {
  @Input() accommodationOrder: AccommodationOrder | undefined ;
  constructor() { }

  ngOnInit(): void {
  }

}
