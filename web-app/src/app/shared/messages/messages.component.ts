import { Component, OnInit } from '@angular/core';
import {MessagesService} from "./messages.service";
import {delay, filter, finalize, Observable, tap} from "rxjs";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  errors$: Observable<string []> | undefined;
  success$: Observable<string | null> | undefined ;
  showErrorMessage = false;
  showSuccessMessage = false;

  constructor(private messageService: MessagesService) { }

  ngOnInit(): void {
    this.errors$ = this.messageService.errors$.pipe(
      tap(() => this.showErrorMessage = true)
    );
    this.success$ = this.messageService.success.pipe(
      tap(() => this.showErrorMessage = true)
    );
  }

  onClose() {
    this.showErrorMessage = false;
  }
}
