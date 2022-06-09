import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnDestroy,
  OnInit,
  Output,
  SimpleChanges,
  ViewChild
} from '@angular/core';
import {ModalBackgroundService} from "../../modal-background/modal-background.service";
import {BehaviorSubject, Subscription} from "rxjs";

@Component({
  selector: 'app-search-dropdown',
  templateUrl: './search-dropdown.component.html',
  styleUrls: ['./search-dropdown.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SearchDropdownComponent implements OnInit, OnDestroy , OnChanges{
  sub: Subscription | undefined;
  backgroundVisible: boolean = false;
  isOpen$ = new BehaviorSubject(false);
  @Input()options: string[] = [];
  @Input() placeholder: string | undefined;
  @Input() initialValue: string | undefined = '';
  filteredOptions: string[] = [] ;
  @Output() selectedValue = new EventEmitter<string>();
  @ViewChild('input') input: any;
  @ViewChild('options') optionsEl: any;
  highlightedEl: HTMLElement | undefined;

  highlightedOption = 0;

  constructor(private modelBackgroundService: ModalBackgroundService) { }

  ngOnInit(): void {
    this.sub = this.modelBackgroundService.showBlackBackground$
      .subscribe(showBackground => {
      this.backgroundVisible = showBackground;
      if(!showBackground) this.isOpen$.next(false);
    });
  }

  showOptions() {
    this.isOpen$.next(true);
    this.modelBackgroundService.showBackground();
  }

  closeOptions() {
    this.isOpen$.next(false);
    this.modelBackgroundService.hideBackground();
  }

  onInputChange() {
    let searchString = this.input.nativeElement.value;
    this.filteredOptions = this.options.filter(value => value.toLowerCase().includes(searchString.toLowerCase()))
  }

  setValue(val: string) {
    this.selectedValue.emit(val)
    this.closeOptions();
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.filteredOptions = this.options;
  }


  onKeyDown(event: KeyboardEvent) {
    if(event.key === 'Enter') {
      event.preventDefault();
      let value = this.filteredOptions[this.highlightedOption];
      this.selectedValue.emit(value)
      this.closeOptions();
      return;
    }
    if(event.key === 'ArrowUp' ){
      if(this.highlightedOption > 0)
      this.highlightedOption--;
      this.highlightedEl && this.highlightedEl.scrollIntoView({behavior: "smooth"})
      this.isOpen$.next(true)
    }else if(event.key === 'ArrowDown') {
      if(this.highlightedOption < this.filteredOptions.length -1)
      this.highlightedOption++;
      this.highlightedEl && this.highlightedEl.scrollIntoView({behavior: "smooth"})
      this.isOpen$.next(true)
    }else
      if(event.key === 'Escape') {
      this.closeOptions();
      return;
    } else if(event.key === 'Tab') {
      this.closeOptions();
      return;
    }else this.highlightedOption  = 0;
    this.isOpen$.next(true)
  }

  onOptionMouseenter(index: number) {
    this.highlightedOption = index;
  }


  setHighlightedEl(element: HTMLDivElement) {
    this.highlightedEl = element;
    return true;
  }

  stopBubbling(event: Event) {
    event.stopPropagation();
  }
}
