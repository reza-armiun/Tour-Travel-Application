import {Injectable} from "@angular/core";
import {
  BehaviorSubject,
  catchError,
  combineLatest,
  concatMap,
  filter, map,
  Observable,
  shareReplay,
  tap,
  throwError
} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {LoadingService} from "../shared/loading/loading.service";
import {MessagesService} from "../shared/messages/messages.service";


//
// interface Country {
//   name: string;
//   countryCode: string;
// }
// interface City {
//   name: string;
//   zipCode: number;
//   country: Country;
// }
// interface Address {
//   street: string;
//   postalCode: string;
//   city: City;
// }
//
// interface TourismManager {
//   name: string;
//   email: string;
//   phone: string;
//   address: Address;
//   nationalId: number;
// }
//
// interface TourItem {
//   name: string;
//   type: string;
//   guid: string;
//   description: string;
//   imageUrl: string;
//   rating: number;
//   price: number;
//   date: string;
//   categories: string[];
//   tourismManager: TourismManager;
// }
// interface Accommodation {
//   name: string;
//   type: String;
//   price: number;
//   time: Date;
//
// }
// interface AccommodationOrder {
//   date: Date;
//   discount: number;
//   accommodation:
// }
//
//
// interface SchedulePlan {
//   name: string;
//   startTime: Date;
//   arrivalTime: Date;
//   source: Address;
//   destination: Address;
//   accommodationOrder: ;
// }

export interface Review {
  from: number;
  to: number;
}

export interface  Filters {
  byCategory: string[];
  byReview: Review [];
}
@Injectable({
  providedIn: 'root'
})
export class ToursStore {
  private rootUrl = 'http://localhost:8080';

  private toursSub$ = new BehaviorSubject<any>([]);
  private categoriesFilterSub$ = new BehaviorSubject<string []>([]);
  private reviewsFilterSub$ = new BehaviorSubject<Review []>([]);
  tours$: Observable<any> = this.toursSub$.asObservable().pipe(
    shareReplay()
  );
  categoriesFilter: Observable<string []> = this.categoriesFilterSub$.asObservable().pipe(
    shareReplay()
  );
  reviewsFilter: Observable<Review []> = this.reviewsFilterSub$.asObservable();


  constructor( private httpClient: HttpClient
              , private loadingService: LoadingService
              , private messageService: MessagesService) {
    this.loadAllTours();
  }


  private loadAllTours() {
    const toursObs = this.httpClient
      .get(`${this.rootUrl}/v1/tour`, )
      .pipe(
        tap(tours => this.toursSub$.next(tours)),
        catchError(err => {
          this.messageService.showErrorForPeriodOfTime(2000, 'Failed to fetch tour list');
          return throwError(err);
        }),
        shareReplay()
      );

    this.loadingService.showLoadingUntilCompletion(toursObs).subscribe();
  }

  setReviewsFilter(reviewsFilter: Review[]) {
    this.reviewsFilterSub$.next(reviewsFilter);
  }

  setCategories(categoriesFilter: string[]) {
    this.categoriesFilterSub$.next(categoriesFilter);
  }




   loadFilteredTours() {
    return  combineLatest([this.tours$, this.categoriesFilterSub$, this.reviewsFilterSub$])
      .pipe(
        map(([tours, categoriesFilter, reviewsFilter]) => {
          if(categoriesFilter.length === 0 && reviewsFilter.length === 0) return  tours;

          const trList = [];

          function filterByReview(tour : any, reviews : Review[]) {
            for(let review of reviews) {
              if(tour.rating >= review.from && tour.rating <= review.to) return true;
            }
            return false;
          }
            for(let tour of tours) {
              if(categoriesFilter.includes(tour.type.toLowerCase())
                || filterByReview(tour ,reviewsFilter) ) {
                trList.push(tour);
              }
            }
            return trList;
        }),
      );

  }


}
