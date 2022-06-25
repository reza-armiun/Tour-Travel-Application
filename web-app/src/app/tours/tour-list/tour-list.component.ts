import {Component, ElementRef, OnDestroy, OnInit, QueryList, ViewChildren} from '@angular/core';
import {distinctUntilChanged, filter, of, Subscription, takeUntil, tap} from "rxjs";
import {SORT, ToursStore} from "../../stores/tours.store";
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
        style({
          opacity: 1,
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
      ], {params : {heightSize: "100", scaleP: '1.0' }}),
      transition('* => void', [
        style({
        })
      ], {params : { heightSize: "100", display: 'initial' }})
    ])
  ]
})
export class TourListComponent implements OnInit, OnDestroy {
  currentTourList: any[] = [];
  newTourList: any[] = []
  sub: Subscription | undefined;
  loadAllSub: Subscription | undefined;
  wildState = 'hide';

  animateTourTransition = false;
  animateNewTourTransition = false;
  showNewTours = false;

  showNewItems = true;

  selectedItem = SORT.NONE;

  compare = (o1: any, o2: any) => {
    return o1.id == o2.id;
  }

  constructor(private tourStore: ToursStore) {}
   differenceWith(arr1: any[], arr2: any[]) {
     return arr1
       .filter(x => !arr2.map(val => val['id']).includes(x['id']))
       .concat(arr2.filter(x => !arr1.map(val => val['id']).includes(x['id'])));
  }

  ngOnInit(): void {
    this.tourStore.animationRunning$.next(false);
    this.sub = this.tourStore.loadAllTours().subscribe();
    this.loadAllSub = this.tourStore.loadFilteredTours().pipe(
      tap( tours => {
        if(!tours.length) {
          return;
        }
        if(!this.tourStore.animationRunning$.getValue()) {
          this.currentTourList = tours;
          // this.showNewItems = false;
          // this.tourStore.animationRunning$.next(true);
        }
      })
      // filter((tours) => {
      //   if(this.tourStore.sortType$.getValue() === SORT.NONE) return true;
      //   console.log(tours);
      //   if(this.showNewTours) {
      //     this.currentTourList = tours;
      //     this.currentTourList.forEach((tour, index) => {
      //         this.currentTourList[index].heightSize = this.getDistFromTop(index) - this.getDistFromTop(tour.prevIndex);
      //     });
      //     console.log('this.newTourList', this.newTourList);
      //     setTimeout(() => {
      //       if(tours.length) {
      //         this.animateNewTourTransition = true;
      //       }
      //     }, 200);
      //   } else {
      //     this.newTourList = tours;
      //     this.newTourList.forEach((tour, index) => {
      //       this.newTourList[index].heightSize = this.getDistFromTop(index) - this.getDistFromTop(tour.prevIndex);
      //     })
      //     setTimeout(() => {
      //       if(tours.length) {
      //         this.animateTourTransition = true;
      //       }
      //     }, 200)
      //   }
      //   return false;
      //
      // }),
      // tap((tours) => {
      //   if(!this.showNewTours){
      //     this.currentTourList = tours;
      //   } else {
      //     this.newTourList = tours;
      //   }
      // })
    ).subscribe();

  }





  ngOnDestroy(): void {
    this.sub?.unsubscribe();
    this.loadAllSub?.unsubscribe();
  }
  checkAnimationRunning() {
    // if(this.animateTourTransition || this.animateNewTourTransition) return true;
    // if(!this.showNewItems) return true;
    if(this.tourStore.animationRunning$.getValue()) return true;
    return false;
  }

  sortByHighestPrice() {
    if(this.checkAnimationRunning()) return;
    this.selectedItem = SORT.HIGHEST_PRICE;
    this.tourStore.sortByHighestPrice();
  }

  sortByLowestPrice() {
    if(this.checkAnimationRunning()) return;
    this.selectedItem = SORT.LOWEST_PRICE;
    this.tourStore.sortByLowestPrice();
  }

  sortByHighestRating() {
    if(this.checkAnimationRunning()) return;
    this.selectedItem = SORT.HIGHEST_RATE;
    this.tourStore.sortByHighestRating();
  }

  sortByLowestRating() {
    if(this.checkAnimationRunning()) return;
    this.selectedItem = SORT.LOWEST_RATE;
    this.tourStore.sortByLowestRating()
  }





  onHideTours(event: any) {
    if(event.toState == "new") {
        this.tourStore.sortType$.next(SORT.NONE) ;
        this.showNewTours= true;
        this.animateTourTransition = false;
    }
  }
  onHideNewTours(event: any) {
    if(event.toState == "new") {
      this.tourStore.sortType$.next(SORT.NONE);
      this.showNewTours= false;
      this.animateNewTourTransition = false;
    }
  }

  // getDistFromTopPx(i: number) {
  //   return (i * 186) + 'px'
  // }
  // getDistFromTop(i: number) {
  //   return i * 186;
  // }


  // getNewTourPosition(id: number) {
  //   return this.newTourList
  //     .find(tour => tour.id == id)?.heightSize || 0;
  // }
  //
  //
  //
  //
  // getTourScale(tourPosition: number) {
  //   if(tourPosition > 0) return '1.01';
  //   if(tourPosition == 0) return '1';
  //   if(tourPosition < 0) return '0.99'
  //   return '1';
  // }
  //
  // getOldTourPosition(id: number) {
  //   return this.currentTourList
  //     .find(tour => tour.id == id)?.heightSize || 0;
  // }


  onAnimationend() {
    this.showNewItems = true;
    this.tourStore.animationRunning$.next(false);
  }

  onAnimationstart() {
    this.tourStore.animationRunning$.next(true);
  }

}






