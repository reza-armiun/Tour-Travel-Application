import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable, shareReplay, tap} from "rxjs";
import {Tour} from "../model/Tour";


export interface Traveler {
  name: string;
  email: string;
  nationalId: number;
  phone: string;
  address: string;
}
export interface Booking {
  id: string;
  date: Date;
  description: string;
  tour: Tour;
  travelers: Traveler[];
}
@Injectable({
  providedIn: 'root'
})
export class BookingService {
  constructor(private httpClient: HttpClient) {}

  private tourSub$  = new BehaviorSubject<any>(null);
  tour$ = this.tourSub$.asObservable().pipe(
    shareReplay()
  );


  getBooking(id: string) {
    return this.httpClient.get<Booking>(`/v1/booking/${id}`).pipe(
      tap(booking => this.tourSub$.next(booking?.tour)),
    );
  }


  loadTour(id: string) {
     this.httpClient.get(`/v1/tour/${id}`).subscribe(
       tour => this.tourSub$.next(tour)
     );
  }

  bookingTour(booking: any, tourId: string): Observable<Booking> {
    console.log(booking);
      return this.httpClient.post<Booking>('/v1/booking', booking , {
        params: {
          'tour-id': tourId
        }
      }
      ).pipe(
        shareReplay(),
      );
  }
}
