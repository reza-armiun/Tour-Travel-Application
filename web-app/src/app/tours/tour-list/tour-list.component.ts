import {
  AfterViewChecked, ChangeDetectionStrategy,
  Component,
  ElementRef,
  OnChanges,
  OnDestroy,
  OnInit,
  QueryList,
  SimpleChanges,
  ViewChildren
} from '@angular/core';
import {filter, Observable, Subscription, tap} from "rxjs";
import {ToursStore} from "../../stores/tours.store";
import {animate, keyframes, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls: ['./tour-list.component.scss'],
  // changeDetection: ChangeDetectionStrategy.OnPush,
  animations: [
    trigger('wildState', [
      transition('void => *', [
      animate(1000, keyframes([
        // style({
        //   transform: 'translateX(-200px)',
        //   opacity: 0,
        //   offset: 0
        // }),
        // style({
        //   transform: 'translateX(-100px)',
        //   opacity: 0.5,
        //   offset: 0.4
        // }),
        // style({
        //   transform: 'translateX(-40px)',
        //   opacity: 1,
        //   offset: 0.8
        // }),
        style({
          // transform: 'translateX(0px)',
          opacity: 1,
          // offset: 1
        })
      ]))
    ]),
      transition('* => void', [
          animate(500, style({
            // transform: 'translateX(100px)',
            opacity: 0
          }))
      ]),
    ]),

    trigger('customAnimation', [
      transition('* => new', [
        animate("1200ms", keyframes([
          style({
            transform: 'translateY({{heightSize}}px) scale({{scaleP}})',
          }),
        ]))
      ], {params : { heightSize: "100", scaleP: '1.0' }})
    ]),
    trigger('newTourAnimation', [
      transition('* => new', [
        animate("1200ms", keyframes([
          style({
            transform: 'translateY({{heightSize}}px) scale({{scaleP}})',
          }),
        ]))
      ], {params : { heightSize: "100", scaleP: '1.0' }}),
      transition('* => void', [
        style({
        })
      ], {params : { heightSize: "100", display: 'initial' }})
    ])
  ]
})
export class TourListComponent implements OnInit, OnDestroy, OnChanges {
  currentTourList: any[] = [];
  newTourList: any[] = []
  sub: Subscription | undefined;
  wildState = 'hide';

  animateTourTransition = false;
  animateNewTourTransition = false;
  @ViewChildren('toursElements')toursElements : QueryList<ElementRef> | undefined;
  showNewTours = false;

  constructor(private tourStore: ToursStore) {}
   differenceWith(arr1: any[], arr2: any[]) {
     return arr1
       .filter(x => !arr2.map(val => val['id']).includes(x['id']))
       .concat(arr2.filter(x => !arr1.map(val => val['id']).includes(x['id'])));
  }

  ngOnInit(): void {
    this.sub = this.tourStore.loadAllTours().subscribe();

    this.tourStore.loadFilteredTours().pipe(
      filter((tours) => {
        if(this.differenceWith(tours, this.currentTourList).length > 0) {
          return true;
        }
        if(this.showNewTours) {
          this.currentTourList = tours;
          this.currentTourList.forEach((tour, index) => {
            this.newTourList[index].heightSize = this.getDistFromTop(index) - this.getDistFromTop(tour.prevIndex);
          });
          setTimeout(() => {
            if(tours.length) {
              this.animateNewTourTransition = true;
            }
          }, 200);
        } else {
          this.newTourList = tours;
          this.newTourList.forEach((tour, index) => {
            this.newTourList[index].heightSize = this.getDistFromTop(index) - this.getDistFromTop(tour.prevIndex);
          })
          setTimeout(() => {
            if(tours.length) {
              this.animateTourTransition = true;
            }
          }, 200)
        }
        return false;

      }),
      tap(tours => {
         this.currentTourList = tours;
      })
    ).subscribe();

  }



  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

  sortByHighestPrice() {
    this.tourStore.sortByHighestPrice();
  }

  sortByLowestPrice() {
      this.tourStore.sortByLowestPrice();
  }

  sortByHighestRating() {
    this.tourStore.sortByHighestRating();
  }

  sortByLowestRating() {
    this.tourStore.sortByLowestRating()

  }

  ngOnChanges(changes: SimpleChanges): void {

  }




  onHideTours(event: any) {
    if(event.toState == "new") {
        this.showNewTours= true;

        this.animateTourTransition = false;
    }
  }

  getDistFromTopPx(i: number) {
    return (i * 186) + 'px'
  }
  getDistFromTop(i: number) {
    return i * 186;
  }


  getTourPosition(id: number) {
    return this.newTourList
      .find(tour => tour.id == id)?.heightSize || 0;
  }

  onHideNewTours(event: any) {
    if(event.toState == "new") {
      this.showNewTours= false;
      this.animateNewTourTransition = false;
    }
  }


  getTourScale(tourPosition: number) {
    if(tourPosition > 0) return '1.01';
    if(tourPosition == 0) return '1';
    if(tourPosition < 0) return '0.99'
    return '1';
  }
}






