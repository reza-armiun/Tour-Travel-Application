import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {BehaviorSubject, catchError, finalize, map, Observable, tap, throwError} from "rxjs";

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

  rootUrl = 'http://localhost:8080';
  private usernameSub$ = new BehaviorSubject<string | null>(null);
  signedin$ = new BehaviorSubject(false);
  username$: Observable<string | null> = this.usernameSub$.asObservable();

  constructor(private http: HttpClient) {}

  signin(credentials: SigninCredentials) {
    return this.http.post<HttpResponse<any>>(`${this.rootUrl}/v1/login`, credentials, {observe: "response"}).pipe(
      tap(res => {
        let userHeader = res.headers.get('user-info');
        if(!userHeader) return;
        const user = <SigninResponse>JSON.parse(userHeader);
        this.usernameSub$.next(user.username);
      }) ,
      tap(() => {
        this.signedin$.next(true);
      })
    );
  }

  checkAuth() {
    return this.http.get<SigninResponse>(`${this.rootUrl}/v1/signedin`)
      .pipe(
        tap(({ authenticated, username }) => {
          this.signedin$.next(authenticated);
          this.usernameSub$.next(username);
        })
      );
  }

  signout() {
    return this.http.get(`${this.rootUrl}/v1/logout`)
      .pipe(
        tap(() => this.signedin$.next(false))
      );
  }

  signup(credentials: SignupCredentials) {
    return this.http.post(`${this.rootUrl}/v1/signup`, credentials);
  }

  usernameExist(username: string) {
    return this.http.get(`${this.rootUrl}/v1/check-username`, {
      params: {
        username
      }
    });
  }

  changePassword(changePassword: UpdatePasswordReq) {
    return this.http.put(`${this.rootUrl}/v1/change-password`, changePassword);
  }

  updateProfile(profile: any) {
    return this.http.put(`${this.rootUrl}/v1/profile`, profile);
  }
}
