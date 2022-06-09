import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {ToursStore} from "../../stores/tours.store";

@Component({
  selector: 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls: ['./tour-list.component.css']
})
export class TourListComponent implements OnInit, OnDestroy {
  tourList$: Observable<any> | undefined;
  filteredTourList$: Observable<any> | undefined;
  sub: Subscription |undefined;

  constructor(private tourStore: ToursStore) { }

  ngOnInit(): void {
    this.sub = this.tourStore.loadAllTours().subscribe();

    this.tourList$ = this.tourStore.tours$;
    this.filteredTourList$ = this.tourStore.loadFilteredTours();
    // this.tourList$ = this.loadingService.showLoadingUntilCompletion(this.tourService.getTourList());
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

}






