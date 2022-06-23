import {
  AfterContentInit,
  AfterViewChecked,
  ChangeDetectorRef,
  Component, ContentChildren,
  ElementRef, EventEmitter, Input, OnChanges,
  OnInit, Output,
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
      transition('none => start', [
        animate("900ms ease", keyframes([
          style({
            transform: 'translateY({{heightSize}}px) ',
          }),
          style({
            transform: 'translateY({{heightSize}}px) scale({{scaleP}})',
          }),
          style({
            transform: 'translateY(0px) scale(1.0)',
          }),
        ]))
      ], {params: {heightSize: "0", scaleP: '1.0'}}),
      transition('initial => start', [
        animate("900ms ease", keyframes([
          style({
            transform: 'translateY({{heightSize}}px) ',
          }),
          style({
            transform: 'translateY({{heightSize}}px) scale({{scaleP}})',
          }),
          style({
            transform: 'translateY(0px) scale(1.0)',
          }),
        ]))
      ], {params: {heightSize: "0", scaleP: '1.0'}})
    ]),

  ]
})
export class ListWithDisplacementComponent implements OnInit, OnChanges, AfterContentInit, AfterViewChecked {
  @Input('items') items: any [] = [];
  @Input('compare')  compare: ((o1: any, o2: any) => boolean) = (o1:any, o2:any) => {
    return o1 == o2;
  };

  @Output('onAnimationstart') onAnimationstart = new EventEmitter();
  @Output('onAnimationend') onAnimationend = new EventEmitter();

  itemsOffsetTop: number[] = [];
  prevItemsIndex: number[] = [];
  @ContentChildren(ListItemDirective) itemsEl: QueryList<ListItemDirective> | undefined;
  viewItems: ElementRef[] | undefined  = [];
  @ViewChildren('listItem') itemsRef: QueryList<ElementRef> | undefined;

  displacement = 'initial';

  constructor(private cd: ChangeDetectorRef) {
    cd.detach();
  }



  ngOnChanges(changes: SimpleChanges): void {
    if(this.displacement == 'start') return;
    let changeList = changes['items'];
    if (changeList.previousValue && changeList.currentValue)
      this.setNewItems(changeList.previousValue, changeList.currentValue);
  }

  private setNewItems(prevList: any[], newList: any[]) {
    newList.forEach(item => {
      let prevIndex = prevList.findIndex(it => this.compare(it, item));
      // if(prevIndex>=0)
      this.prevItemsIndex.push(prevIndex);
    })
    setTimeout(() => {
      if(this.prevItemsIndex.length)
        this.displacement = 'start';
    })
  }


  ngAfterContentInit(): void {
    this.viewItems = this.itemsEl?.map(item => item.el);
    this.cd.detectChanges()
  }



  ngAfterViewChecked(): void {
    this.itemsRef?.forEach(item => {
        let offsetTop = item.nativeElement.offsetTop;
        // console.log('offsetTop', offsetTop)
        this.itemsOffsetTop.push(offsetTop);
      })
      this.cd.detectChanges()
  }


  ngOnInit(): void {}

  getOffsetDiff(i: number) {
    let prevIndex = this.prevItemsIndex[i];
    let prevOffsetTop = this.itemsOffsetTop[prevIndex];
    let currentOffsetTop = this.itemsRef?.get(i)?.nativeElement.offsetTop;
    let offsetDiff = currentOffsetTop - prevOffsetTop;
    // console.log('index ', i, 'prevItemsIndex ', this.prevItemsIndex, 'prevIndex ' , prevIndex ,
    //   'prevOffsetTop ', prevOffsetTop, 'currentOffsetTop ', currentOffsetTop , 'offsetDiff ', offsetDiff);
    this.viewItems = this.itemsEl?.map(item => item.el);
    return isNaN(offsetDiff) ? 0 : offsetDiff;
  }

  onDisplacementDone(event: any) {
    if(event.toState == 'start' &&( event.fromState == 'none' || event.fromState == 'initial')) {
      this.displacement = 'none';
      this.prevItemsIndex = [];
      this.itemsOffsetTop = [];
      this.onAnimationend.emit();
    }
  }

  getScale(i: number) : string {
    let prevIndex = this.prevItemsIndex[i];
    let prevOffsetTop = this.itemsOffsetTop[prevIndex];
    let currentOffsetTop = this.itemsRef?.get(i)?.nativeElement.offsetTop;
    let offset = currentOffsetTop - prevOffsetTop;
      if(offset > 0) return '1.01';
      if(offset === 0) return '1';
      if(offset < 0) return '0.99'
      return '1';
  }

  onDisplacementStart(event: any) {
    if(event.toState == 'start'){
      this.onAnimationstart.emit();
    }
  }


}
