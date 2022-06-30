import {Injectable} from "@angular/core";
import {StepperItem} from "./tour-form.component";
import {BehaviorSubject, Observable, shareReplay, tap} from "rxjs";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Activity} from "../model/Activity";
import {newFoodFormGroup} from "./schedule-plans-form/foods-form/foods-form.component";
import {newVehicleFormGroup} from "./schedule-plans-form/vehicles-form/vehicles-form.component";
import {MessagesService} from "../shared/messages/messages.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";


interface State {
  infoForm: FormGroup;
  tourismMgForm: FormGroup;
  schedulePlanInfoForm: FormGroup;
  accommodationForm: FormGroup;
  foodsForm: FormGroup;
  vehiclesForm: FormGroup;
  activities: Activity[];
  activeItem: StepperItem;
}

@Injectable({
  providedIn: 'root'
})
export class TourFormService {
  stepperList:  StepperItem[] = [
    {name: 'Tour Information', icon: 'info' , form: 'info'},
    {name: 'Tourism Manager', icon: 'person_pin',  form: 'tourismManager'},
    {name: 'Schedule plans', icon: 'schedule', form: 'schedulePlans'},
  ];
  private activeItemSub$ = new BehaviorSubject<StepperItem>({name: 'Tour Information', icon: 'info'});
  activeItem$: Observable<StepperItem> = this.activeItemSub$.asObservable().pipe(
    shareReplay(),
    tap(value => {
      let newObj = {};
      for(let key in this.state) {
        // @ts-ignore
        if(this.state[key] instanceof FormGroup)
          // @ts-ignore
          newObj[key]=this.state[key].value;
        // @ts-ignore
        else if(key == 'activities') newObj[key] = this.state[key];
        else
          // @ts-ignore
          newObj[key]= value;
      }
      const stateStr = JSON.stringify(newObj);
      localStorage.setItem("tour-form", stateStr);
    })
  );


  private state: State = {
    infoForm: this.fb.group({
      name: ['', [Validators.required]],
      type: ['', [Validators.required]],
      imgUrl: ['', [Validators.required]],
      price: ['', [Validators.required]],
      date: ['', [Validators.required]],
      guide: ['', []],
      description: ['', []],
    }),
    tourismMgForm: this.fb.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required]],
      nationalId: ['', [Validators.required]],
      address: [null],
    }),
    schedulePlanInfoForm:  this.fb.group({
      name: ['', [Validators.required]],
      startTime: ['', [Validators.required]],
      arrivalTime: ['', [Validators.required]],
      source: [null, [Validators.required]],
      destination: [null, [Validators.required]],
    }),
    accommodationForm: this.fb.group({
      name: ['', [Validators.required]],
      type: ['', [Validators.required]],
      discount: ['', [Validators.required]],
      price: ['', [Validators.required]],
      checkIn: ['', [Validators.required]],
      checkOut: ['', [Validators.required]],
    },),
    foodsForm: this.fb.group({
      foods: this.fb.array([
        this.fb.group({
          name: ['', [Validators.required]],
          type: ['', [Validators.required]],
          discount: ['', [Validators.required]],
          ingredients: ['', [Validators.required]],
          price: ['', [Validators.required]],
          cookTime: ['', [Validators.required]],
        })
      ])
    }),
    vehiclesForm: this.fb.group({
      vehicles: this.fb.array([
        this.fb.group({
          name: ['', [Validators.required]],
          type: ['', [Validators.required]],
          discount: ['', [Validators.required]],
          price: ['', [Validators.required]],
          from: ['', [Validators.required]],
          to: ['', [Validators.required]],
          ticketNumber: ['', [Validators.required]],
          departure: ['', [Validators.required]],
          arrival: ['', [Validators.required]],
        })
      ])
    }),
    activities: [],
    activeItem: this.activeItemSub$.value
  }


  get infoForm(): FormGroup {
    return this.state.infoForm;
  }
  get tourismMgForm(): FormGroup{
    return this.state.tourismMgForm;
  }

  get schedulePlanInfoForm():FormGroup {
    return this.state.schedulePlanInfoForm;
  }
  get accommodationForm(): FormGroup {
    return  this.state.accommodationForm;
  }

  get foodsForm(): FormGroup {
    return  this.state.foodsForm;
  }

  get vehiclesForm(): FormGroup {
    return  this.state.vehiclesForm;
  }
  get activities() {
    return this.state.activities;
  }



  constructor(private fb :FormBuilder
              , private messageService: MessagesService
              , private httpClient: HttpClient
              , private router: Router) {
    const tourFormStr  =localStorage.getItem("tour-form");
    if(tourFormStr) {
      const savedState = JSON.parse(tourFormStr);
       Object.entries(this.state)
        .forEach(pair => {
          if(pair[1] instanceof AbstractControl){
            if(pair[0] == 'foodsForm') {
              this.state[pair[0]] = this.fb.group({
                foods: this.fb.array(savedState[pair[0]]?.foods.map((food: any) => {
                    return newFoodFormGroup(food);
                  })
                )
              })
            }
            else if(pair[0] == 'vehiclesForm') {
              this.state[pair[0]] = this.fb.group({
                vehicles: this.fb.array(savedState[pair[0]]?.vehicles.map((vehicle: any) => {
                    return newVehicleFormGroup(vehicle);
                  })
                )
              })
            }
             else {
              pair[1].patchValue(savedState[pair[0]]);
            }
          }
          else if( pair[0] == 'activeItem') {
            this.state[pair[0]] = savedState[pair[0]];
            this.activeItemSub$.next(savedState[pair[0]]);
          }
          else
          { // @ts-ignore

              this.state[pair[0]] = savedState[pair[0]];
            }
          // @ts-ignore
        });
    }
  }




  setActiveItem(index: number, item: StepperItem) {
    this.activeItemSub$.next(item);
  }


  nextStep() {
    const currentIndex = this.stepperList
      .findIndex(value => this.activeItemSub$.getValue().name == value.name);
    if(currentIndex <= this.stepperList.length) {
      this.activeItemSub$.next(this.stepperList[currentIndex + 1]);
    }
  }

  prevStep() {
    const currentIndex = this.stepperList.findIndex(value => this.activeItemSub$.value?.name == value?.name);
    if(currentIndex > 0 ) {
      this.activeItemSub$.next(this.stepperList[currentIndex - 1]);
    }
  }


  clearForm() {
    Object.values(this.state).forEach(item => {
      if(item instanceof AbstractControl)
        item.reset();
      else if(item.length) item = [];
    });
    this.activeItemSub$.next({name: 'Tour Information', icon: 'info'});
    localStorage.removeItem('tour-form');
  }

  setActivities(activities: Activity[]) {
    this.state.activities = activities;
  }

  saveTour() {
    let isInvalid:any = '';
    Object.entries(this.state).forEach(item => {
      if(item[1] instanceof  AbstractControl) {
        if(item[0] == 'foodsForm' ) {
          // @ts-ignore
          let foods:any [] = [...item[1].get('foods').value];
          foods.pop();
          if(!foods.length) isInvalid =false;
        }
        else if(item[0] == 'vehiclesForm' ) {
          // @ts-ignore
          let vehicles:any [] = [...item[1].get('vehicles').value];
          vehicles.pop();
          if(!vehicles.length) isInvalid = false;
        }
        else isInvalid &&= item[1].invalid ;
      }
      if(isInvalid) {
        this.messageService.showErrorForPeriodOfTime(2000, 'Invalid Form Inputs');
        return;
      }});
    let tour = {};
    let schedulePlan = {}
    Object.entries(this.state).forEach(item => {
      if(item[0] == 'activeItem') return;
        if(item[0] == 'infoForm') {
          let info = {...item[1].value};
          tour = {...tour, ...info, date: new Date(info.date).toISOString()};
        }
        if(item[0] == 'tourismMgForm') tour = {...tour, tourismManager: {...item[1].value}};
        if(item[0] == 'accommodationForm') {
          let acc = {...item[1].value};
          schedulePlan = {
            ...schedulePlan, accommodationOrder: {
              discount: acc.discount, date: new Date().toISOString(), accommodation: {
                ...acc, checkIn: new Date(acc.checkIn).toISOString()
                , checkOut: new Date(acc.checkOut).toISOString()
              }
            }
          };
        }
        if(item[0] == 'foodsForm') {
          let foods:any [] = [...item[1].get('foods').value];
          foods.pop();
          foods = foods.map(food  => ({date: new Date().toISOString(), discount: food.discount, food: {...food, ingredients: food.ingredients.split(',') }}));
          schedulePlan = {...schedulePlan, foodOrders: [...foods]};
        }
        if(item[0] == 'vehiclesForm') {
          let vehicles:any [] = [...item[1].get('vehicles').value];
          vehicles.pop();
          vehicles = vehicles.map(vc => ({
            name: vc.name, discount: vc.discount, vehicle: {
              ...vc, departure: new Date(vc.departure).toISOString()
              , arrival: new Date(vc.arrival).toISOString()
            }
          }));
          schedulePlan = {...schedulePlan, vehicleOrders: [...vehicles]};
        }
        if(item[0] == 'activities') {
          let activityList: any[] = item[1].map((ac: any) => ({...ac, startAt: new Date(ac.startAt).toISOString()
            ,endAt: new Date(ac.endAt).toISOString() }));
          schedulePlan = {...schedulePlan, activities: [...activityList]};
        }

        if(item[0] == 'schedulePlanInfoForm') {
          let planInfo = {...item[1].value};
          schedulePlan = {
            ...schedulePlan, ...planInfo, startTime: new Date(planInfo.startTime).toISOString()
            , arrivalTime: new Date(planInfo.arrivalTime).toISOString()
          };
        }
    })
    tour = {...tour, schedulePlans: [schedulePlan]}
    console.log('tour', tour)
    this.httpClient.post('/v1/tour', tour)
      .subscribe(savedId => {
        this.messageService.showSuccessForPeriodOfTime(4000, 'Tour Saved Successfully' );
      this.router.navigateByUrl('/');
    })

  }
}
