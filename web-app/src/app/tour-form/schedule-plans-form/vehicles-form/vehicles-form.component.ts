import { Component, OnInit } from '@angular/core';
import {FormArray, FormControl, FormGroup, Validators} from "@angular/forms";
import {TourFormService} from "../../tour-form.service";
import {Vehicle} from "../../../model/VehicleOrder";

export const newVehicleFormGroup = (vehicle?: any) => new FormGroup({
  name: new FormControl(vehicle?.name ?? '', [Validators.required,]),
  type: new FormControl(vehicle?.type ?? '', [Validators.required,]),
  discount: new FormControl(vehicle?.discount ?? '', [Validators.required,]),
  price: new FormControl(vehicle?.price ?? '', [Validators.required,]),
  from: new FormControl(vehicle?.from ?? '', [Validators.required,]),
  to: new FormControl(vehicle?.to ?? '', [Validators.required,]),
  ticketNumber: new FormControl(vehicle?.ticketNumber ?? '', [Validators.required,]),
  departure: new FormControl(vehicle?.departure ?? '', [Validators.required,]),
  arrival: new FormControl(vehicle?.arrival ?? '', [Validators.required,]),

});


@Component({
  selector: 'app-vehicles-form',
  templateUrl: './vehicles-form.component.html',
  styleUrls: ['./vehicles-form.component.scss']
})
export class VehiclesFormComponent implements OnInit {
  form: FormGroup;
  displayedColumns = ['name', 'type' , 'price', 'from', 'to', 'ticketNumber', 'departure', 'arrival', 'actions'];
  vehiclesData: Vehicle[] = [];
  editMode = false;
  currentFormIndex = 0;
  constructor(private tourFormService: TourFormService) {
    this.form = tourFormService.vehiclesForm;
    this.vehiclesData = this.vehicles ? this.vehicles.value.slice(0, this.vehicles.length - 1) : [];
    this.currentFormIndex = this.vehicles.length - 1;
  }
  ngOnInit(): void {
  }

  get vehicles(): FormArray {
    return  this.form.get('vehicles') as FormArray;
  }
  addVehicle() {
    if(this.vehicles.invalid ) return;

    this.vehiclesData = [...this.form.value['vehicles']];
    const newVehicle = newVehicleFormGroup();
    this.currentFormIndex++ ;
    this.vehicles.push(newVehicle);
  }

  removeVehicle(i: number) {
    this.editMode = false;
    this.vehiclesData.splice(i, 1);
    this.vehiclesData = [...this.vehiclesData];
    this.vehicles.removeAt(i);
    if(this.vehicles.length > 0)
      this.currentFormIndex = this.vehicles.length - 1;
  }

  editVehicleHandler() {
    this.editMode = false;
    this.vehiclesData = this.vehicles.value.slice(0, this.vehicles.length - 1);
    this.currentFormIndex = this.vehicles.length - 1;
  }
  enableEditVehicleMode(i: number) {
    this.currentFormIndex = i;
    this.editMode = true;
  }


}
