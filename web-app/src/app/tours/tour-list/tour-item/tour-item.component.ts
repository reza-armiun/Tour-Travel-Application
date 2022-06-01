import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-tour-item',
  templateUrl: './tour-item.component.html',
  styleUrls: ['./tour-item.component.css']
})
export class TourItemComponent implements OnInit {
  @Input() tour :any ;

  constructor() { }

  ngOnInit(): void {
  }

}
