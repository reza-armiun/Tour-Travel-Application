import {AfterViewChecked, ChangeDetectionStrategy, Component, Input, OnDestroy, OnInit} from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-tour-item',
  templateUrl: './tour-item.component.html',
  styleUrls: ['./tour-item.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class TourItemComponent implements OnInit, AfterViewChecked, OnDestroy {
  @Input() tour :any ;
  wildState = new BehaviorSubject('hide');

  constructor() {
  }

  ngOnInit(): void {

  }


  ngAfterViewChecked(): void {
    this.wildState.next('show');
  }

  ngOnDestroy(): void {
    this.wildState.next('hide');
  }

}
