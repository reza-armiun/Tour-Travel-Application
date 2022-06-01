import { Component, OnInit } from '@angular/core';
import {AuthService} from "../auth/auth.service";
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  signedin$: BehaviorSubject<boolean> | undefined;
  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.signedin$ = this.authService.signedin$;
  }

}
