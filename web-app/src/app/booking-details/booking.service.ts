import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, shareReplay, tap} from "rxjs";


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
  tour: any;
  travelers: Traveler[];
}
@Injectable({
  providedIn: 'root'
})
export class BookingService {
  private rootUrl = 'http://localhost:8080';
  constructor(private httpClient: HttpClient) {}

  private tourSub$  = new BehaviorSubject<any>(null);
  tour$ = this.tourSub$.asObservable().pipe(
    shareReplay()
  );


  getBooking(id: string) {
    return this.httpClient.get<Booking>(`${this.rootUrl}/v1/booking/${id}`).pipe(
      tap(booking => this.tourSub$.next(booking?.tour)),
    );
  }


  loadTour(id: string) {
     this.httpClient.get(`${this.rootUrl}/v1/tour/${id}`).subscribe(
       tour => this.tourSub$.next(tour)
     );
  }
}
