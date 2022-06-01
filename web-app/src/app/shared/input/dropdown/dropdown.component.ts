import {Component, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {ModalBackgroundService} from "../../modal-background/modal-background.service";
import { Subscription, } from "rxjs";

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.css']
})
export class DropdownComponent implements OnInit , OnDestroy{
  backgroundVisible: boolean = false;
  isOpen = false;
  @Input()options: string[] = [];
  filteredOptions: string[] | undefined;
  @Output() selectedValue : string | null = null;

  sub: Subscription | undefined;
  constructor(private modelBackgroundService: ModalBackgroundService) { }

  ngOnInit(): void {
    this.filteredOptions = this.options;
    this.selectedValue = this.options[0];

    this.sub = this.modelBackgroundService.showBlackBackground$.subscribe(showBackground => {
      this.backgroundVisible = showBackground;
      if(!showBackground) this.isOpen =false;
    });
  }

  showOptions() {
    if(this.backgroundVisible) {
      this.modelBackgroundService.hideBackground();
    }
    this.isOpen = true;
    this.modelBackgroundService.showBackground();
  }

  closeOptions() {
    this.isOpen = false;
    this.modelBackgroundService.hideBackground();
  }

  setValue(val: string) {
    this.selectedValue = val;
    this.closeOptions();
  }

  toggleOptions() {
    if(this.isOpen) this.closeOptions();
    else this.showOptions();
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }
}
