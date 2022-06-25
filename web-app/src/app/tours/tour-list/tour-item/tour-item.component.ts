import {
  ChangeDetectionStrategy,
  ChangeDetectorRef,
  Component,
  Input,
  OnInit
} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-tour-item',
  templateUrl: './tour-item.component.html',
  styleUrls: ['./tour-item.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class TourItemComponent implements OnInit {
  @Input() tour :any ;

  constructor(private router: Router, private cd : ChangeDetectorRef) {
  }

  ngOnInit(): void {

  }


  bookTour(event: any, id: any) {
    // this.cd.detectChanges();
    // event.preventDefault();
    // console.log('id ', id)
    //   this.router.navigate(
    //     ['/booking'],
    //     { queryParams: { 'tour-id': id } }
    //   );
  }
}
