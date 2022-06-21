import { Directive, ElementRef, Input, OnInit} from "@angular/core";
import {
  animate,
  AnimationBuilder,
  AnimationMetadata,
  AnimationPlayer,
  keyframes, style,
  transition
} from "@angular/animations";


@Directive({
  selector: '[appListItem]',
})
export class ListItemDirective implements OnInit{
  @Input() index: number = 0;
  @Input() set(show: boolean) {
    if (this.player) {
      this.player.destroy();
    }

    const metadata = show ? this.displacement() : this.hide();

    const factory = this.builder.build(metadata);
    const player = factory.create(this.el.nativeElement);

    player.play();
  }
  player: AnimationPlayer | undefined;

  constructor(private builder: AnimationBuilder,private el: ElementRef) {
  }

  ngOnInit(): void {
  }
  private displacement(): AnimationMetadata[] {
    return [
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
      ], {params: {heightSize: "0", scaleP: '1.0'}})
    ];
  }

  private hide(): AnimationMetadata[] {
    return [
        animate(1000, keyframes([
          style({
            opacity: '0',
            border: '20px solid red',
          }),
        ]))
    ];
  }


}
