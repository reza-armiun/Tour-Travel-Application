import { Component, OnInit } from '@angular/core';
import {FormArray, FormControl, FormGroup, Validators} from "@angular/forms";
import {TourFormService} from "../../tour-form.service";
import {Food} from "../../../model/FoodOrder";

export const newFoodFormGroup = (food?: any) => new FormGroup({
  name: new FormControl(food?.name ?? '', [Validators.required,]),
  type: new FormControl(food?.type ?? '', [Validators.required,]),
  discount: new FormControl(food?.discount ?? '', [Validators.required,]),
  ingredients: new FormControl(food?.ingredients ?? '', [Validators.required,]),
  price: new FormControl(food?.price ?? '', [Validators.required,]),
  cookTime: new FormControl(food?.cookTime ??'', [Validators.required,]),
}, );




@Component({
  selector: 'app-foods-form',
  templateUrl: './foods-form.component.html',
  styleUrls: ['./foods-form.component.scss']
})
export class FoodsFormComponent implements OnInit {
  form: FormGroup;
  displayedColumns: string[] = ['name' , 'type', 'discount', 'ingredients', 'price', 'cookTime', 'actions'];
  foodsData: Food[] = [];
  editMode =false;
  currentFormIndex = 0;
  constructor(private tourFormService: TourFormService) {
    this.form = tourFormService.foodsForm;
    this.foodsData = this.foods ? this.foods.value.slice(0, this.foods.length - 1) : [];
    this.currentFormIndex = this.foods.length - 1 ;
  }

  get foods(): FormArray{
    return this.form.get('foods') as FormArray;
  }

  ngOnInit(): void {
  }

  addFood() {
    if(this.foods.invalid) return;
      this.foodsData =  [...this.form.value['foods']];
      const newFood = newFoodFormGroup();
      this.currentFormIndex++ ;
      this.foods.push(newFood);

  }

  removeFood(i: number) {
    this.editMode = false;
    this.foodsData.splice(i, 1);
    this.foodsData = [...this.foodsData];
    this.foods.removeAt(i);
    if(this.foods.length > 0 )
      this.currentFormIndex = this.foods.length - 1;
  }
  editFoodHandler() {
    this.editMode = false;
    this.foodsData = this.foods.value.slice(0, this.foods.length - 1);
    this.currentFormIndex = this.foods.length - 1;
  }

  enableEditFoodMode(i: number) {
    this.currentFormIndex = i
    this.editMode = true;
  }
}
