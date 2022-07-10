import { Component, OnInit } from '@angular/core';
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-tours',
  templateUrl: './tours.component.html',
  styleUrls: ['./tours.component.css']
})
export class ToursComponent implements OnInit {
  xSmall = false;
  breakpointSub: Subscription | undefined;

  constructor(private breakpoints: BreakpointObserver) {
    this.breakpointSub = breakpoints.observe( [Breakpoints.XSmall] ).subscribe(result => {
      this.xSmall = false;
      if(result.breakpoints[Breakpoints.XSmall]) this.xSmall = true;
    })

  }

  ngOnInit(): void {
  }

}
