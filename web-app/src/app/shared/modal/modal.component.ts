import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {ModalBackgroundService} from "../modal-background/modal-background.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css'],
})
export class ModalComponent implements OnInit, OnDestroy {
  @Input() show: boolean  = false;
  @Output() onClose = new EventEmitter<void>() ;
  sub: Subscription | undefined;

  constructor(private modalBackgroundService: ModalBackgroundService) { }


  ngOnInit(): void {
      this.modalBackgroundService.showBlackBackground$.subscribe(value => {
        if(!value)
          this.show = false;
      })
  }

  showBackground() {
    this.modalBackgroundService.showBackground();
    return true;
  }

  closeBackground() {
    this.modalBackgroundService.hideBackground();
      this.onClose.emit();
    return false;
  }
  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

  disableBubbling($event: MouseEvent) {
    $event.stopPropagation();
  }
}
