import {
  ChangeDetectionStrategy, ChangeDetectorRef,
  Component,
  Input, OnChanges,
  OnInit, SimpleChanges
} from '@angular/core';
import {animate, keyframes, style, transition, trigger} from "@angular/animations";
import {Subscription} from "rxjs";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";

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
  small = false;
  xSmall = false;
  breakpointSub: Subscription | undefined;

  constructor(private breakpoints: BreakpointObserver) {
    this.breakpointSub = breakpoints.observe([Breakpoints.Small, Breakpoints.HandsetPortrait] ).subscribe(result => {
      this.small = false;
      this.xSmall = false;
      if(result.breakpoints[Breakpoints.Small]) this.small = true;
      if(result.breakpoints[Breakpoints.HandsetPortrait]) this.xSmall = true;
    })

  }

  ngOnInit(): void {}


  onStartLoading() {
    this.loadingImage = true;
  }

  onFinishedLoading() {
    this.loadingImage = false;
  }


}
