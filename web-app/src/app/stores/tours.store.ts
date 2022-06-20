import {Injectable} from "@angular/core";
import {
  BehaviorSubject,
  catchError,
  combineLatest,
  concatMap, distinctUntilChanged, filter,
  find,
  map,
  Observable, of,
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

export enum SORT {
  HIGHEST_PRICE,
  LOWEST_PRICE,
  HIGHEST_RATE,
  LOWEST_RATE,
  NONE
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
  private sortedTours: any[] = [];
  sortType$ = new BehaviorSubject<SORT>(SORT.NONE);


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
        tap(tours => {
          this.toursSub$.next(tours);
          // @ts-ignore
          this.sortedTours = tours;
        }),
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
    return  combineLatest([this.tours$, this.categoriesFilterSub$, this.reviewsFilterSub$, this.sortType$])
      .pipe(
        map(([tours, categoriesFilter, reviewsFilter, sortType]) => {
          if(categoriesFilter.length === 0 && reviewsFilter.length === 0 && sortType === SORT.NONE) {
            if(this.sortedTours.length == tours.length) return this.sortedTours;
            else {
              this.sortedTours = tours;
              return tours;
            }
          }

          let trList = [];

          function filterByReview(tour : any, reviews : Review[]) {
            for(let review of reviews) {
              if(tour.rating >= review.from && tour.rating <= review.to) return true;
            }
            return false;
          }
          for(let tour of this.sortedTours) {
              if(categoriesFilter.includes(tour.type.toLowerCase())
                || filterByReview(tour ,reviewsFilter) ) {
                trList.push(tour);
              }
            }
          if(!trList.length) trList = [...this.sortedTours];
          if(sortType !== SORT.NONE) {
              switch (sortType) {
                case SORT.LOWEST_PRICE: {
                  trList = trList
                    .map((value: any,index: number) => ({...value, prevIndex: index }))
                    .sort((a: any, b: any) => +a.price - +b.price);
                  break;
                }
                case SORT.HIGHEST_PRICE: {
                  trList = trList
                    .map((value: any,index: number) => ({...value, prevIndex: index }))
                    .sort((a: any, b: any) => +b.price - +a.price);
                  break;
                }
                case SORT.LOWEST_RATE: {
                  trList = trList
                    .map((value: any,index: number) => ({...value, prevIndex: index }))
                    .sort((a: any, b: any) => +a.rating - +b.rating);
                  break;
                }
                case SORT.HIGHEST_RATE: {
                  trList = trList
                    .map((value: any,index: number) => ({...value, prevIndex: index }))
                    .sort((a: any, b: any) => +b.rating - +a.rating);
                  break;
                }
                default : {
                  break;
                }
              }
            }

          this.sortedTours = [...trList];
          return trList;
        }),
        distinctUntilChanged((prev, curr) => this.arraysEqual(prev, curr))
      );

  }
   arraysEqual(a: any[], b: any[]) {
    if (a === b) return true;
    if (a == null || b == null) return false;
    if (a.length !== b.length) return false;
    for (let i = 0; i < a.length; ++i) {
      if (a[i].id != b[i].id) return false;
    }
    return true;
  }

  sortByLowestPrice() {
    this.sortType$.next(SORT.LOWEST_PRICE);
  }

  sortByHighestPrice() {
    this.sortType$.next(SORT.HIGHEST_PRICE);
  }

  sortByHighestRating() {
    this.sortType$.next(SORT.HIGHEST_RATE);
  }

  sortByLowestRating() {
    this.sortType$.next(SORT.LOWEST_RATE);
  }
}
