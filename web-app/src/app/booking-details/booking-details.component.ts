import {Component, OnDestroy, OnInit} from '@angular/core';
import {Booking, BookingService, Traveler} from "./booking.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs";




@Component({
  selector: 'app-booking-details',
  templateUrl: './booking-details.component.html',
  styleUrls: ['./booking-details.component.css']
})
export class BookingDetailsComponent implements OnInit, OnDestroy {
  paramsSub: Subscription | undefined;
  sub: Subscription | undefined;
  booking: Booking | undefined;
  travelers: Traveler[] = [];
  displayedColumns = ['name', 'email', 'nationalId', 'phone' , 'address'];

  constructor(private bookingService: BookingService, private activatedRoute: ActivatedRoute, private  router: Router) { }

  ngOnInit(): void {
    this.paramsSub = this.activatedRoute.params.subscribe((params) => {
      const id = params['id'];
      if(id) {
        this.sub = this.bookingService.getBooking(id).subscribe(booking => {
          this.booking = booking;
          this.travelers = booking.travelers;
        });

      }
    })
  }

  ngOnDestroy() {
    this.paramsSub?.unsubscribe();
    this.sub?.unsubscribe();
  }

}
