import {Component, OnDestroy, OnInit} from '@angular/core';
import {BookingService} from "../booking.service";
import {Subscription} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {SchedulePlan, Tour} from "../../model/Tour";

@Component({
  selector: 'app-tour-details',
  templateUrl: './tour-details.component.html',
  styleUrls: ['./tour-details.component.css']
})
export class TourDetailsComponent implements OnInit, OnDestroy {
  sub: Subscription | undefined;
  tour: Tour | undefined;
  schedulePlans: SchedulePlan[] = [];
  constructor(private bookingService: BookingService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.sub = this.bookingService.tour$.subscribe(tour => {
      if(!tour) {
        let id = this.activatedRoute.snapshot.params['id'];
        this.bookingService.loadTour(id);
      }
      else {
        this.tour = tour;
        this.schedulePlans = tour?.schedulePlans;
      }
      console.log('tour ', tour);
    })
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

}
