import {
  AfterViewChecked, ChangeDetectionStrategy,
  Component, ElementRef, OnChanges,
  OnDestroy,
  OnInit, QueryList, SimpleChanges, ViewChildren
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
        style({
          transform: 'translateX(-200px)',
          opacity: 0,
          offset: 0
        }),
        style({
          transform: 'translateX(-100px)',
          opacity: 0.5,
          offset: 0.4
        }),
        style({
          transform: 'translateX(-40px)',
          opacity: 1,
          offset: 0.8
        }),
        style({
          transform: 'translateX(0px)',
          opacity: 1,
          offset: 1
        })
      ]))
    ]),
      transition('* => void', [
          animate(500, style({
            transform: 'translateX(100px)',
            opacity: 0
          }))
      ]),
    ]),

    trigger('customAnimation', [
      transition('* => new', [
        animate("1700ms", keyframes([
          style({
            transform: 'translateY({{heightSize}}px)',
            display: '{{display}}'
          }),
        ]))
      ], {params : { heightSize: "100", display: 'initial' }})
    ]),
    trigger('newTourAnimation', [
      transition('* => new', [
        // animate("1700ms", keyframes([
        //   style({
        //     transform: 'translateY({{heightSize}}px)',
        //     display: '{{display}}'
        //   }),
        // ]))
      ], {params : { heightSize: "100", display: 'initial' }}),
      transition('* => void', [
        style({
        })
      ], {params : { heightSize: "100", display: 'initial' }})
    ])
  ]
})
export class TourListComponent implements OnInit, OnDestroy,AfterViewChecked, OnChanges {
  currentTourList: any[] = [];
  newTourList: any[] = []
  visible = false;
  filteredTourList$: Observable<any> | undefined;
  sub: Subscription | undefined;
  wildState = 'hide';

  animateTransition = false;
  @ViewChildren('toursElements')toursElements : QueryList<ElementRef> | undefined;
  hideOldTours = false;
  showNewTours = false;

  constructor(private tourStore: ToursStore) {}
   differenceWith(arr1: any[], arr2: any[]) {
     return arr1
       .filter(x => !arr2.map(val => val['id']).includes(x['id']))
       .concat(arr2.filter(x => !arr1.map(val => val['id']).includes(x['id'])));
  }

  ngOnInit(): void {
    this.sub = this.tourStore.loadAllTours().subscribe();


    this.filteredTourList$ = this.tourStore.loadFilteredTours().pipe(

      filter((tours) => {
        if(this.differenceWith(tours, this.currentTourList).length > 0) {
          return true;
        }
        this.newTourList = tours;
        this.newTourList.forEach((tour, index) => {
          this.newTourList[index].heightSize = this.getDistFromTop(index) - this.getDistFromTop(tour.prevIndex);
        })
        setTimeout(() => {
          if(tours.length) {
            this.animateTransition =true;
          }
        }, 200)
        return false;
      }),
      tap(tours => {
         this.currentTourList = tours;
      })
    );

  }

  ngAfterViewChecked(): void {

    this.visible = true;
  }


  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

  sortByHighestPrice() {

  }

  sortByLowestPrice() {
      this.tourStore.sortByLowestPrice();
  }

  sortByHighestRating() {
    this.tourStore.sortByHighestPrice();
  }

  sortByLowestRating() {

  }

  ngOnChanges(changes: SimpleChanges): void {

  }




  onHideTours(event: any) {
    // console.log('event ', event)
    if(event.toState == "new") {
        this.hideOldTours = true;
        this.showNewTours= true;

        this.animateTransition = false;
    }
  }

  getDistFromTopPx(i: number) {
    return (i * 186) + 'px'
  }
  getDistFromTop(i: number) {
    return i * 186;
  }



  getTourNewHeight(id: number) {
    return this.newTourList
      .find(tour => tour.id == id)?.heightSize || 0;
  }

  onHideNewTours(event: any) {
    console.log(event)
    if(event.toState == "new") {
      this.hideOldTours = false;
      this.showNewTours= false;

      this.animateTransition = false;
    }
  }
}






