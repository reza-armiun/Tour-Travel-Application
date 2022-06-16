import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ToursStore} from "../stores/tours.store";
import {Observable, Subscription} from "rxjs";
import {Tour} from "../model/Tour";
import {FormArray, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from "@angular/forms";
import { BookingService, Traveler} from "../booking-details/booking.service";
import {ErrorStateMatcher} from "@angular/material/core";

const newTravelerFormGroup = () => new FormGroup({
  name: new FormControl('', {
    validators: [
      Validators.required,
      Validators.minLength(4),
    ]
  } ),
  email: new FormControl('', [
    Validators.required,
    Validators.minLength(4),
    Validators.email
  ]),
  nationalId: new FormControl('', [
    Validators.required,
    Validators.minLength(4),
  ]),
  phone: new FormControl('', [
    Validators.required,
    Validators.minLength(4),
  ]),
}, );

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.css']
})
export class BookingFormComponent implements OnInit, OnDestroy {
  sub: Subscription | undefined;
  tourId: string | undefined;
  tour$: Observable<Tour> | undefined;
  matcher = new MyErrorStateMatcher();
  editMode= false;

  currentFormIndex =  0 ;
  constructor(private activatedRoute: ActivatedRoute
              , private tourStore: ToursStore
              , private bookingService: BookingService
              , private router: Router
              ) { }


  form = new FormGroup({
    description: new FormControl('' , [Validators.maxLength(150)]),
    travelers: new FormArray([
      newTravelerFormGroup()
    ] , )
  } , );
  displayedColumns = ['name' , 'email', 'nationalId', 'phone', 'actions'];
  travelersTableData: Traveler[] = [];

  get travelers() {
    return this.form.get('travelers') as FormArray;
  }
  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe((params) => {
      this.tourId = params['tour-id'];
      this.tour$ = this.tourStore.getTour(params['tour-id']);
    })
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

  addTravelerHandler() {
    if(this.travelers.invalid) return;
    this.travelersTableData = [...this.form.value['travelers']]
     const newTraveler = newTravelerFormGroup();
     this.currentFormIndex++ ;
     this.travelers.push(newTraveler);
  }

  removeTravelerHandler(i: number) {
    this.editMode = false;
    this.travelersTableData.splice(i, 1);
    this.travelersTableData  = [...this.travelersTableData];
    this.travelers.removeAt(i);
    if(this.travelers.length > 0)
      this.currentFormIndex = this.travelers.length - 1;

  }

  enableEditTravelerMode(i: number) {
    this.currentFormIndex = i;
    this.editMode  = true;
  }

  editTravelerHandler() {
    this.editMode = false;
    this.travelersTableData = this.travelers.value.slice(0, this.travelers.length - 1);
    this.currentFormIndex = this.travelers.length - 1;
  }

  bookingHandler() {
    if(this.travelersTableData.length > 0 && this.tourId) {
        this.bookingService.bookingTour({travelers: [...this.travelersTableData] , description: this.form.value?.description } , this.tourId)
          .subscribe(booking => {
            this.router.navigate(['booking', booking.id ], )
            console.log('booked tour ', booking);
          })
    }
  }
}



export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    if (form?.submitted) return  <boolean>control?.invalid;
    return <boolean>(control && (control.touched && control.dirty && control.invalid));  // show error only when dirty and invalid
  }
}
