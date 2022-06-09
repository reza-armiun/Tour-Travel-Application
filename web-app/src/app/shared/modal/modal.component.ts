import {Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges} from '@angular/core';
import {ModalBackgroundService} from "../modal-background/modal-background.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css'],
})
export class ModalComponent implements OnInit, OnDestroy, OnChanges {
  @Input() show: boolean  = false;
  @Output() onClose = new EventEmitter<void>() ;
  sub: Subscription | undefined;

  constructor(private modalBackgroundService: ModalBackgroundService) { }


  ngOnInit(): void {
      this.modalBackgroundService.showBlackBackground$.subscribe(value => {
        if(!value) {
          this.onClose.emit();
          this.show = false;
        }
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

  ngOnChanges(changes: SimpleChanges): void {
    if(this.show) this.showBackground();
    else this.closeBackground();
  }
}
