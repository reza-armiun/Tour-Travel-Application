import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";



@Injectable()
export class AuthHttpInterceptor implements HttpInterceptor {
  intercept = (req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> => {
    const modifiedReq = req.clone({withCredentials: true});
    return next.handle(modifiedReq);
  };

}
