import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {BehaviorSubject, catchError, finalize, map, Observable, of, shareReplay, tap, throwError} from "rxjs";

interface SigninResponse {
  authenticated: boolean;
  username: string;
  authorities: string[];
}
interface SigninCredentials {
  username: string;
  password: string;
}
interface SignupCredentials {
  name: string;
  email: string;
  username: string;
  password: string;
  rePassword: string;
}

interface UpdatePasswordReq {
  username: string;
  oldPassword: string;
  password: string;
  rePassword: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usernameSub$ = new BehaviorSubject<string | null>(null);
  signedin$ = new BehaviorSubject(false);
  username$: Observable<string | null> = this.usernameSub$.asObservable().pipe(
    shareReplay()
  );

  constructor(private http: HttpClient) {
    // const token = localStorage.getItem('user-info');
    // if(token) {
    //   const user = JSON.parse(token) as SigninResponse;
    //
    // }
  }

  signin(credentials: SigninCredentials) {
    return this.http.post<HttpResponse<any>>(`/v1/login`, credentials, {observe: "response"}).pipe(
      tap(res => {
        let userHeader = res.headers.get('user-info');
        if(!userHeader) return;
        const user = <SigninResponse>JSON.parse(userHeader);
        localStorage.setItem("user-info", userHeader);

        this.usernameSub$.next(user.username);
      }) ,
      tap(() => {
        this.signedin$.next(true);
      })
    );
  }

  checkAuth() {
    const userInfo = localStorage.getItem("user-info");
    if (userInfo) {
      const user = <SigninResponse>JSON.parse(userInfo.toString());
      this.signedin$.next(true);
      console.log('check auth');
      this.usernameSub$.next(user.username);
      return of();
    } else
      return this.http.get<SigninResponse>(`/v1/signedin`)
        .pipe(
          tap((response) => {
            localStorage.setItem("user-info", JSON.stringify(response));
            this.signedin$.next(response.authenticated);
            this.usernameSub$.next(response.username);
          })
        );
  }

  signout() {
    return this.http.get(`/v1/logout`)
      .pipe(
        tap(() => localStorage.removeItem("user-info")),
        tap(() => this.signedin$.next(false))
      );
  }

  signup(credentials: SignupCredentials) {
    return this.http.post(`/v1/signup`, credentials);
  }

  usernameExist(username: string) {
    return this.http.get(`/v1/check-username`, {
      params: {
        username
      }
    });
  }

  changePassword(changePassword: UpdatePasswordReq) {
    return this.http.put(`/v1/change-password`, changePassword);
  }


}
