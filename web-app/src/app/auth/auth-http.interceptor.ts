import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from "@angular/common/http";
import {catchError, Observable, of, tap, throwError} from "rxjs";
import {Injectable} from "@angular/core";
import {AuthService} from "./auth.service";
import {Router} from "@angular/router";
import {MessagesService} from "../shared/messages/messages.service";



@Injectable()
export class AuthHttpInterceptor implements HttpInterceptor {

   constructor(private authService: AuthService, private router: Router, private messageService: MessagesService) {
  }
  intercept = (req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> => {
    const modifiedReq = req.clone({withCredentials: true});
    return next.handle(modifiedReq).pipe(
      catchError(err => {
        if (err instanceof HttpErrorResponse) {
          if(!err.status) {
            this.messageService.showErrorForPeriodOfTime(3500, 'Failed to connect to the server, please try later...');
            return of();
          }
          if (err.status === 403) {
            this.authService.signout().subscribe(
              () => this.router.navigateByUrl('/signin')
          );
          }
        }
        return throwError(err);
      })
    );
  };

}
