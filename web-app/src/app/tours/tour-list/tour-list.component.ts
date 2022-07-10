import {Component, OnDestroy, OnInit, Type} from '@angular/core';
import {Subscription, tap} from "rxjs";
import {SORT, ToursStore} from "../../stores/tours.store";
import {BreakpointObserver, Breakpoints} from "@angular/cdk/layout";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {ProfileImageDialogComponent} from "../../profile/profile-image-dialog/profile-image-dialog.component";
import {FiltersComponent} from "../tours-filters/tours-filters.component";
import {ToursSortComponent} from "../tours-sort/tours-sort.component";




@Component({
  selector: 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls: ['./tour-list.component.scss'],
  // changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TourListComponent implements OnInit, OnDestroy {
  small = false;
  xSmall =false;
  breakpointSub : Subscription | undefined;

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

  constructor(private tourStore: ToursStore, private breakPoints: BreakpointObserver,public dialog: MatDialog) {
    this.breakpointSub = breakPoints.observe([Breakpoints.Small, Breakpoints.XSmall] ).subscribe(result => {
      this.small = false;
      this.xSmall = false;
      if(result.breakpoints[Breakpoints.Small]) this.small = true;
      if(result.breakpoints[Breakpoints.XSmall]) this.xSmall = true;
    })
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
        }
      })
    ).subscribe();

  }





  ngOnDestroy(): void {
    this.sub?.unsubscribe();
    this.loadAllSub?.unsubscribe();
    this.breakpointSub?.unsubscribe();
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




  onAnimationend() {
    this.showNewItems = true;
    this.tourStore.animationRunning$.next(false);
  }

  onAnimationstart() {
    this.tourStore.animationRunning$.next(true);
  }

  showFilters() {
    openComponentDialog(this.dialog, FiltersComponent)
  }

  showCategories() {
    openComponentDialog(this.dialog, ToursSortComponent)
  }
}






export function openComponentDialog(dialog: MatDialog, component: Type<any>) {

  const config = new MatDialogConfig();
  config.minWidth = '100vw';


  // config.autoFocus = true;

  const dialogRef = dialog.open(component, config);

  return dialogRef.afterClosed();
}
