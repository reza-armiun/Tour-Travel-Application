import {animate, keyframes, style, transition, trigger} from "@angular/animations";

export let shakeAnimation = trigger('shake' , [
  transition('* => error' , [
    animate("250ms ease", keyframes([
      style({
        transform: 'translate(1px, 1px) rotate(0deg)'
      }),
      style({
        transform: 'translate(-1px, -1px) rotate(-1deg)'
      }),
      style({
        transform: 'translate(-2px, 0px) rotate(1deg)'
      }),
      style({
        transform: 'translate(3px, 2px) rotate(0deg)'
      }),
      style({
        transform: 'translate(1px, -1px) rotate(1deg)'
      }),
      style({
        transform: 'translate(-1px, 1px) rotate(-1deg)'
      })
    ]))
  ])
] );
