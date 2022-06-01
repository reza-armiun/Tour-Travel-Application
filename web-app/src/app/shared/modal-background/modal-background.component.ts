import { Component, OnInit } from '@angular/core';
import {ModalBackgroundService} from "./modal-background.service";
import {Observable, of} from "rxjs";

@Component({
  selector: 'app-modal-background',
  templateUrl: './modal-background.component.html',
  styleUrls: ['./modal-background.component.css'],})
export class ModalBackgroundComponent implements OnInit {
  show$: Observable<boolean>  = of(false);
  constructor(private modelBackgroundService: ModalBackgroundService) { }

  ngOnInit(): void {
    this.show$ = this.modelBackgroundService.showBlackBackground$;
  }

  onHide() {
    this.modelBackgroundService.hideBackground();
  }
}
