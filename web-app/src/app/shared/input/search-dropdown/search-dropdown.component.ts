import {Component, Input, OnInit, Output, ViewChild} from '@angular/core';

@Component({
  selector: 'app-search-dropdown',
  templateUrl: './search-dropdown.component.html',
  styleUrls: ['./search-dropdown.component.css']
})
export class SearchDropdownComponent implements OnInit {
  isOpen = false;
  @Input()options: string[] = [];
  filteredOptions: string[] | undefined;
  @Output() selectedValue : string | null = null;
  @ViewChild('input') input: any;
  constructor() { }

  ngOnInit(): void {
    this.filteredOptions = this.options;
  }

  showOptions() {
    this.isOpen = true;
  }

  closeOptions() {
    this.isOpen = false;
  }

  onInputChange() {
    // console.log(this.input.nativeElement.value);
    let searchString = this.input.nativeElement.value;
    this.filteredOptions = this.options.filter(value => value.toLowerCase().includes(searchString.toLowerCase()))
  }

  setValue(val: string) {
    this.selectedValue = val;
    this.input.nativeElement.value = val;
    this.closeOptions();
  }
}
