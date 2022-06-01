import {Injectable} from "@angular/core";
import {BehaviorSubject, Observable, shareReplay} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class ModalBackgroundService {
  private showBlackBackgroundSub$ = new BehaviorSubject<boolean>(false);
  showBlackBackground$: Observable<boolean> =  this.showBlackBackgroundSub$.asObservable().pipe(
    shareReplay()
  );


  showBackground() {
    this.showBlackBackgroundSub$.next(true);
  }

  hideBackground() {
    this.showBlackBackgroundSub$.next(false);
  }
}
