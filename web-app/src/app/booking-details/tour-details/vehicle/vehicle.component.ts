import {Component, Input, OnInit} from '@angular/core';
import {Vehicle, VehicleOrder} from "../../../model/VehicleOrder";

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {
  @Input()vehicleOrders: VehicleOrder[] | undefined = [];

  get vehicles () : Vehicle[] {
    if(this.vehicleOrders)
      return  this.vehicleOrders?.map(or => or.vehicle);
    else
      return [];
  }
  displayedColumns: string[] = ['name', 'type', 'ticketNumber','departure', 'arrival', 'from', 'to' , 'price'];

  constructor() { }

  ngOnInit(): void {
  }

}
