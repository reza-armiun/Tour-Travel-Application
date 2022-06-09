import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Countries, countries, CountryWithCities} from "./countries";
import {countryWithCities} from "./countryWithCities";
import {Observable} from "rxjs";
import {
  AbstractControl,
  ControlValueAccessor,
  NG_VALIDATORS,
  NG_VALUE_ACCESSOR,
  ValidationErrors,
  Validator
} from "@angular/forms";

@Component({
  selector: 'app-country-dropdown',
  templateUrl: './country-dropdown.component.html',
  styleUrls: ['./country-dropdown.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      multi: true,
      useExisting: CountryDropdownComponent
    },
    {
      provide: NG_VALIDATORS,
      multi: true,
      useExisting: CountryDropdownComponent
    },
  ]
})
export class CountryDropdownComponent implements OnInit,ControlValueAccessor, Validator {
  countries = Object.keys(countryWithCities);
  selectedCountry: string | undefined;
  initialValue: string = ''

  @Output() countrySelected = new EventEmitter<string>();


  onChange = (value: string) => {};

  onTouched = () => {};

  touched = false;

  disabled = false;

  constructor() { }

  ngOnInit(): void {
  }



  selectCountry(country: string) {
    this.markAsTouched();
    this.selectedCountry = country;
    this.onChange(country);
    this.countrySelected.emit(country);
  }

  markAsTouched() {
    if (!this.touched) {
      this.onTouched();
      this.touched = true;
    }
  }

  registerOnChange(onChange: any): void {
    this.onChange = onChange;
  }

  registerOnTouched(onTouched: any): void {
    this.touched = onTouched;
  }

  setDisabledState(disabled: boolean) {
    this.disabled = disabled;
  }

  validate(control: AbstractControl): ValidationErrors | null {
    const country = control.value;
    if (countries.includes(country)) {
      return {
        mustBeCorrect: true
      }
    }
    return  null;
  }

  writeValue(country: string): void {
    this.selectedCountry = country;
    this.initialValue = country;
    this.countrySelected.emit(country);
  }
}
