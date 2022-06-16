import {Injectable} from "@angular/core";
import {
  BehaviorSubject,
  catchError,
  combineLatest,
  concatMap, filter,
  find,
  map,
  Observable,
  shareReplay,
  tap,
  throwError
} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {LoadingService} from "../shared/loading/loading.service";
import {MessagesService} from "../shared/messages/messages.service";
import {Tour} from "../model/Tour";


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

  private toursSub$ = new BehaviorSubject<any>([]);
  private categoriesFilterSub$ = new BehaviorSubject<string []>([]);
  private reviewsFilterSub$ = new BehaviorSubject<Review []>([]);
  tours$: Observable<any> = this.toursSub$.asObservable().pipe(
    map(tours => tours.map((tour: any) => {
      if(tour.id == 96) tour.price =7000;
      return tour;
    })),
    shareReplay()
  );
  categoriesFilter: Observable<string []> = this.categoriesFilterSub$.asObservable().pipe(
    shareReplay()
  );
  reviewsFilter: Observable<Review []> = this.reviewsFilterSub$.asObservable();


  constructor( private httpClient: HttpClient
              , private loadingService: LoadingService
              , private messageService: MessagesService) {
    // this.loadAllTours();
  }




  getTour(id: string) : Observable<any> {
    return this.tours$.pipe(
      concatMap(tourList => {
        return tourList.length > 0 ? [...tourList] : this.httpClient.get<Tour>(`/v1/tour/${id}`);
      }),
      find(tour => {
        if (tour?.id == id) return tour;
        return null;
      }),
    );
  }

   loadAllTours() {
    const toursObs = this.httpClient
      .get(`/v1/tour`, )
      .pipe(
        tap(tours => this.toursSub$.next(tours)),
        catchError(err => {
          this.messageService.showErrorForPeriodOfTime(2000, 'Failed to fetch tour list');
          return throwError(err);
        }),
        shareReplay()
      );

    return this.loadingService.showLoadingUntilCompletion(toursObs);
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


  sortByLowestPrice() {
    let value = this.toursSub$.getValue();
    this.toursSub$.next(value
      .map((value: any,index: number) => ({...value, prevIndex: index }))
      .sort((a: any, b: any) => +a.price >= +b.price ? 1 : -1)
    );
  }
  sortByHighestPrice() {
    let value = this.toursSub$.getValue();
    this.toursSub$.next(value
      .map((value: any,index: number) => ({...value, prevIndex: index }))
      .sort((a: any, b: any) => +a.price <= +b.price ? 1 : -1)
    );
  }
}
