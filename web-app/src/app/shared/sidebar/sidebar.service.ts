import {Injectable} from "@angular/core";
import {BehaviorSubject} from "rxjs";


@Injectable({
  providedIn: "root"
})
export class SidebarService {

  private showSidebarSub$ = new BehaviorSubject<boolean>(false);
  showSidebar$ =  this.showSidebarSub$.asObservable();


  openSidebar(){
    this.showSidebarSub$.next(true);
  }


  hideSidebar() {
    this.showSidebarSub$.next(false);
  }
}
