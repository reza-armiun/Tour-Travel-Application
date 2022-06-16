import {Component, Input, OnDestroy} from '@angular/core';
import {
  AbstractControl,
  ControlValueAccessor,
  FormBuilder, FormControl,
  FormGroup, NG_VALIDATORS, NG_VALUE_ACCESSOR,
  ValidationErrors,
  Validator, Validators
} from "@angular/forms";
import {Subscription} from "rxjs";



@Component({
  selector: 'app-address-form',
  templateUrl: './address-form.component.html',
  styleUrls: ['./address-form.component.scss'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      multi: true,
      useExisting: AddressFormComponent
    },
    {
      provide: NG_VALIDATORS,
      multi: true,
      useExisting: AddressFormComponent
    },
  ]
})
export class AddressFormComponent implements ControlValueAccessor, OnDestroy, Validator {
  @Input()title: string = 'Address';
  form: FormGroup = this.fb.group({
    street: [null, [Validators.required]],
    postalCode: [null, [Validators.required]],
    city:  new FormGroup({
      name: new FormControl(''),
      zipCode: new FormControl(''),
      country: new FormGroup({
        name: new FormControl(''),
        countryCode: new FormControl('')
      })
    })
  });



  onTouched: Function = () => {};

  onChangeSubs: Subscription[] = [];


  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
  }

  registerOnChange(onChange: any): void {
    const sub = this.form.valueChanges.subscribe(onChange);
    this.onChangeSubs.push(sub);
  }

  registerOnTouched(onTouched: any): void {
    this.onTouched = onTouched;
  }

  validate(control: AbstractControl): ValidationErrors | null {
    if (this.form.valid) {
      return null;
    }
    return null;

  }

  setDisabledState(disabled: boolean) {
    if (disabled) {
      this.form.disable();
    }
    else {
      this.form.enable();
    }
  }


  writeValue(value: any): void {
    if (value) {
      this.form.setValue(value, {emitEvent: false});
    }
  }

  addControlErrors(allErrors: any, controlName:string) {

    const errors = {...allErrors};

    const controlErrors = this.form.controls[controlName].errors;

    if (controlErrors) {
      errors[controlName] = controlErrors;
    }

    return errors;
  }

}
