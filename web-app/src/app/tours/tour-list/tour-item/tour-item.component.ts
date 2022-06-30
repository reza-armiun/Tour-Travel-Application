import {
  ChangeDetectionStrategy, ChangeDetectorRef,
  Component,
  Input, OnChanges,
  OnInit, SimpleChanges
} from '@angular/core';
import {animate, keyframes, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-tour-item',
  templateUrl: './tour-item.component.html',
  styleUrls: ['./tour-item.component.css'],
  // changeDetection: ChangeDetectionStrategy.OnPush,
  animations: [

  ],
})
export class TourItemComponent implements OnInit {
  @Input() tour :any ;
  loadingImage = true;

  constructor() {
  }

  ngOnInit(): void {}


  onStartLoading() {
    this.loadingImage = true;
  }

  onFinishedLoading() {
    this.loadingImage = false;
  }


}
