import { Component, OnInit } from '@angular/core';
import {MessagesService} from "../shared/messages/messages.service";

@Component({
  selector: 'app-tours',
  templateUrl: './tours.component.html',
  styleUrls: ['./tours.component.css']
})
export class ToursComponent implements OnInit {

  constructor(private messageService: MessagesService) { }

  ngOnInit(): void {
  }

  showError() {
     this.messageService.showErrorForPeriodOfTime(2000,'Something goes wrong...');
    // this.messageService.showErrors('Something goes wrong...')
  }
}
