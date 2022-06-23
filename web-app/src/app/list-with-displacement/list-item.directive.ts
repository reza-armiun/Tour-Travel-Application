import { Directive, ElementRef, Input, OnInit} from "@angular/core";

@Directive({
  selector: '[appListItem]',
})
export class ListItemDirective implements OnInit{
  @Input() index: number = 0;

  constructor(public el: ElementRef) {}

  ngOnInit(): void {
  }

}
