import {Component, Input, OnInit} from '@angular/core';
import {Vehicle, VehicleOrder} from "../../../model/VehicleOrder";
import {Food, FoodOrder} from "../../../model/FoodOrder";

@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.css']
})
export class FoodComponent implements OnInit {
  @Input()foodOrders: FoodOrder[] | undefined = [];

  get vehicles () : Food[] {
    if(this.foodOrders)
      return  this.foodOrders?.map(or => or.food);
    else
      return [];
  }

  displayedColumns: string[] = ['name', 'type', 'ingredients', 'price', 'cookTime'];

  constructor() { }

  ngOnInit(): void {
  }

}
