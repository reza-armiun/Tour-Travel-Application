import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ToursStore} from "../../stores/tours.store";

@Component({
  selector: 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls: ['./tour-list.component.css']
})
export class TourListComponent implements OnInit {
  tourList$: Observable<any> | undefined;
  filteredTourList$: Observable<any> | undefined;

  constructor(private tourStore: ToursStore) { }

  ngOnInit(): void {
    this.tourList$ = this.tourStore.tours$;
    this.filteredTourList$ = this.tourStore.loadFilteredTours();
    // this.tourList$ = this.loadingService.showLoadingUntilCompletion(this.tourService.getTourList());
  }

}
