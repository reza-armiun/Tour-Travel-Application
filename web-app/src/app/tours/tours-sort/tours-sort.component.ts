import { Component, OnInit } from '@angular/core';
import {SORT, ToursStore} from "../../stores/tours.store";

@Component({
  selector: 'app-tours-sort',
  templateUrl: './tours-sort.component.html',
  styleUrls: ['./tours-sort.component.scss']
})
export class ToursSortComponent implements OnInit {
  selectedItem = SORT.NONE;

  constructor(private tourStore: ToursStore) { }

  ngOnInit(): void {
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

}
