import {
  AfterContentChecked,
  ChangeDetectionStrategy,
  ChangeDetectorRef,
  Component,
  ContentChildren,
  ElementRef,
  Input,
  OnChanges,
  QueryList,
  SimpleChanges
} from "@angular/core";
import {ListItemDirective} from "./list-item.directive";
import {BehaviorSubject} from "rxjs";


@Component({
  selector: 'app-list-displacement',
  // changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: "list-wrapper.component.html"
})
export class ListWrapperComponent implements OnChanges, AfterContentChecked{
  // @Input('items') items: any[] = [];

  @ContentChildren(ListItemDirective) itemsEl: QueryList<ElementRef> | undefined;
  viewItems: any[] | undefined = [];

   showContent$ =  new BehaviorSubject(false);

  constructor(private  cd: ChangeDetectorRef) {
    cd.detach();
  }

  ngAfterContentChecked(): void {
    console.log('items el', this.itemsEl);
    this.cd.reattach();
    // let changeList = changes['items'];
    if (this.itemsEl?.length) {
      // this.viewItems = changeList.currentValue;
      this.viewItems = this.itemsEl?.map(item => item.nativeElement);
      this.cd.reattach();
    } else {
      // let newItems = changeList.currentValue;
      this.throttle();
      // this.throttle(newItems);
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.showContent$.next(true)
    // let changeList = changes['items'];
    // if (!this.items.length) {
    //   this.viewItems = changeList.currentValue;
    //   this.cd.detectChanges();
    // } else {
    //   let newItems = changeList.currentValue;
    //   this.throttle(newItems)
    // }
  }


  private _flush = false;

  // throttle(items: any) {
  throttle() {
    this.showContent$.next(false)

    // this.cd.detach();
    // let newItems = items ;

    if (!this._flush) {
      this._flush = true;
      setTimeout(() => {
        // this.viewItems = newItems;

        // this.cd.reattach();
        // this.showContent$.next(true)
        this.showContent$.next(true)
        this._flush = false;
      }, 5000);
    }
  }




}
