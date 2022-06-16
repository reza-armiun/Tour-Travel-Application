import { Component, OnInit } from '@angular/core';
import {Review, ToursStore} from "../../stores/tours.store";


const REVIEW_TYPES = {
  superb: {from: 9, to: 10},
  verygood: {from: 8, to: 9},
  good: {from: 7, to: 8},
  pleasant: {from: 6, to: 7},
}

@Component({
  selector: 'app-tours-filters',
  templateUrl: './tours-filters.component.html',
  styleUrls: ['./tours-filters.component.css']
})
export class FiltersComponent implements OnInit {
  categoriesFilter: string[] = [];
  reviewsFilter: Review[] = [];

  constructor(private toursStore: ToursStore) { }

  ngOnInit(): void {
    this.toursStore.setCategories([]);
    this.toursStore.setReviewsFilter([]);
  }

  reviewFiltersHandler(el: HTMLInputElement) {
    const obj  = Object.entries(REVIEW_TYPES).find(([key, value]) => {
      return key === el.name;
    });
    if(!obj) return;
    const review = obj[1];
    if(el.checked) {
      this.reviewsFilter.push(review);
    }else {
      this.reviewsFilter = this.reviewsFilter.filter(rev => rev.from !== review.from && rev.to !== review.to);
    }
    this.toursStore.setReviewsFilter(this.reviewsFilter)
  }

  categoryFiltersHandler(el: HTMLInputElement) {
      if(el.checked) {
        this.categoriesFilter.push(el.name);
      }else {
        this.categoriesFilter = this.categoriesFilter.filter(cat => cat !== el.name);
      }
      this.toursStore.setCategories(this.categoriesFilter);
  }
}
