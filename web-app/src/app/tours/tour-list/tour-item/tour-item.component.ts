import {AfterViewChecked, ChangeDetectionStrategy, Component, Input, OnDestroy, OnInit} from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-tour-item',
  templateUrl: './tour-item.component.html',
  styleUrls: ['./tour-item.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
  // animations: [
  //   trigger('wildState', [
  //     transition('hide => show', [
  //       animate(1000, keyframes([
  //         style({
  //           transform: 'translateY(-200px)',
  //           opacity: 0,
  //           offset: 0
  //         }),
  //         style({
  //           transform: 'translateX(-100px)',
  //           opacity: 0.5,
  //           offset: 0.4
  //         }),
  //         style({
  //           transform: 'translateX(-40px)',
  //           opacity: 1,
  //           offset: 0.8
  //         }),
  //         style({
  //           transform: 'translateX(0px)',
  //           opacity: 1,
  //           offset: 1
  //         })
  //       ]))
  //     ]),
  //     transition('show => hide', [
  //       animate(500, style({
  //         transform: 'translateX(100px)',
  //         opacity: 0
  //       }))
  //     ])
  //   ])
  //
  // ]

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
