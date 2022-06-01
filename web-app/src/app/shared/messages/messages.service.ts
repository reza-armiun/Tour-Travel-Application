import {Injectable} from "@angular/core";
import {BehaviorSubject, delay, filter, finalize, Observable, of, shareReplay, tap} from "rxjs";


@Injectable()
export class MessagesService {

  private errorsSub$ = new BehaviorSubject<string []>([]);
  private successSub$ = new BehaviorSubject<string | null>(null);
  errors$: Observable<string []> = this.errorsSub$.asObservable()
    .pipe(
      // filter(messages => messages && messages.length > 0),
      shareReplay(),
    );
  success: Observable<string | null> = this.successSub$.asObservable()


  showErrorForPeriodOfTime(duration: number, ...errors: string[])  {
    return of(null)
      .pipe(
        tap(() => this.showErrors(...errors)),
        delay(duration),
        finalize(() => this.closeErrors())
      ).subscribe();
  }

  showErrors(...errors: string[]) {
    this.errorsSub$.next(errors)
  }
  closeErrors() {
    this.errorsSub$.next([])
  }


  showSuccessForPeriodOfTime(duration: number, message: string) {
    return of(null)
      .pipe(
        tap(() => this.showSuccessMsg(message)),
        delay(duration),
        finalize(() => this.closeSuccessMsg())
      ).subscribe();
  }

  private showSuccessMsg(message: string) {
    this.successSub$.next(message);
  }

  private closeSuccessMsg() {
    this.successSub$.next(null);
  }
}
