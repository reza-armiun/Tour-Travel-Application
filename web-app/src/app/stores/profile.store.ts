import {Injectable} from "@angular/core";
import {BehaviorSubject, catchError, Observable, shareReplay, tap, throwError} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {LoadingService} from "../shared/loading/loading.service";
import {MessagesService} from "../shared/messages/messages.service";
import {AuthService} from "../auth/auth.service";


interface  Address {
  street: string;
  postalCode: string;
  city: string;
  zipCode: string;
  country: string;
  countryCode: string;
}
interface  Booking {
  id: string;
  tourId: string;
  tourName: string;
  date: string;
}
export interface Profile {
  name: string;
  username: string;
  phone: string;
  email: string;
  nationalId: number;
  imageUrl: string;
  address: Address;
  bookings: Booking[];
}


@Injectable({
  providedIn: 'root'
})
export class ProfileStore {
  private profileSub$ = new BehaviorSubject<Profile | null>(null);
  profile$: Observable<Profile | null> = this.profileSub$.asObservable().pipe(
    shareReplay()
  );



  constructor(private httpClient: HttpClient
              , private loadingService: LoadingService
              , private messageService: MessagesService, private authService: AuthService) {
    this.authService.username$.subscribe(username => {
      if(username)
        this.loadProfileByUsername(username)
    });


  }

  loadProfileByUsername(username: string) {
    const profileObs =  this.httpClient.get<Profile>(`/v1/profile`, {params: { username}}).pipe(
      tap(profile => this.profileSub$.next(profile)),
      catchError(err => {
        this.messageService.showErrorForPeriodOfTime(1500, 'Failed to get profile details');
        return throwError(err);
      })
    );
    this.loadingService.showLoadingUntilCompletion(profileObs).subscribe();
  }

  updateProfile(profile: any) {
    return this.httpClient.put(`/v1/profile`, profile).pipe(
      tap(_ => this.profileSub$.next({...profile, bookings: this.profileSub$.value?.bookings})),
      shareReplay()
    );
  }

  editProfileImg(file: File) {
    let formData = new FormData();
    formData.append("file", file)
   return  this.httpClient.post('/v1/profile/img' , formData  , {
     reportProgress: true,
     responseType: 'text'
   });
  }

  setProfileImgUrl(imgUrl: string) {
    this.profileSub$.next(<Profile>{...this.profileSub$.getValue(), imageUrl: imgUrl})
  }
}
