import {
  AfterContentChecked,
  AfterViewChecked,
  ChangeDetectorRef,
  Component, ContentChildren,
  ElementRef, Input, OnChanges,
  OnInit,
  QueryList,
  SimpleChanges,
  ViewChildren
} from '@angular/core';
import {animate, keyframes, style, transition, trigger} from "@angular/animations";
import {ListItemDirective} from "./list-item.directive";

@Component({
  selector: 'app-list-with-displacement',
  templateUrl: './list-with-displacement.component.html',
  styleUrls: ['./list-with-displacement.component.css'],
  animations: [
    trigger('displacement', [
      transition('* => move', [
        animate("1200ms", keyframes([
          style({
            position: 'relative',
            zIndex: '12',
            transform: 'translateY({{heightSize}}px) scale({{scaleP}})',
          }),
          style({
            position: 'relative',
            transform: 'translateY(0px) scale(1.0)',
            zIndex: '12'
          }),
        ]))
      ], {params: {heightSize: "0", scaleP: '1.0'}}),
      // transition('* => fade', [
      //   animate(1000, keyframes([
      //     style({
      //       opacity: '0',
      //       border: '20px solid red',
      //     }),
      //   ]))
      // ], )
    ]),

  ]
})
export class ListWithDisplacementComponent implements OnInit, AfterViewChecked, OnChanges, AfterContentChecked {
  @Input('items') items: any [] = [];
  itemsOffsetTop: number[] = [];
  prevItemsIndex: number[] = [];
  // @ViewChildren(ListItemDirective) itemsEl: QueryList<ElementRef> | undefined;
  @ContentChildren(ListItemDirective) itemsEl: QueryList<ElementRef> | undefined;
  displacement = 'none';

  constructor(private cd: ChangeDetectorRef) {
    cd.detach();
  }

  ngAfterContentChecked(): void {

  }

  ngOnChanges(changes: SimpleChanges): void {
    let changeList = changes['items'];
    if (!changeList.previousValue) {
      this.cd.detectChanges();
    }
    if (changeList.previousValue && changeList.currentValue)
      this.setNewItems(changeList.previousValue, changeList.currentValue);
  }

  private setNewItems(prevList: any[], newList: any[]) {
    newList.forEach(item => {
      let prevIndex = prevList.findIndex(it => it == item);
      this.prevItemsIndex.push(prevIndex);
    })
    setTimeout(() => {
      this.displacement = 'move';
    })
  }

  ngAfterViewChecked(): void {
      this.itemsEl?.forEach(item => {
        let offsetTop = item.nativeElement.offsetTop;
        this.itemsOffsetTop.push(offsetTop);
      })
    this.cd.detectChanges();
  }



  comparator(o1:any, o2:any) {
    return o1 == o2;
  }

  ngOnInit(): void {

  }
  getPrevOffset(i: number) {
    let prevIndex = this.prevItemsIndex[i];
    let prevOffsetTop = this.itemsOffsetTop[prevIndex];
    let currentOffsetTop = this.itemsEl?.get(i)?.nativeElement.offsetTop;
    // console.log('item ', this.items[i],' prevIndex', prevIndex, ' index', i, ' current offset ', currentOffsetTop, ' prev offset ', prevOffsetTop  )
    return currentOffsetTop - prevOffsetTop;
  }

  onDisplacementDone(event: any) {
    if(event.toState == 'move') {
      this.displacement = 'none';
      this.prevItemsIndex = [];
      this.itemsOffsetTop = [];
    }
  }

}
