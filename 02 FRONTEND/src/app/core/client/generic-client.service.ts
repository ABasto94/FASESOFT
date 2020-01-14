import { Injectable } from '@angular/core';
import { Headers, RequestOptions } from '@angular/http';

import { Observable } from 'rxjs';
import { AdalService, AdalInterceptor } from 'adal-angular4';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';



@Injectable()
export class GenericClientService {

  token: string = sessionStorage.getItem('adal.idtoken');

  constructor(private http: HttpClient, private adalService: AdalService) { }

  getGenericItems(uriService: string): Observable<any[]> {
    return this.http.get(uriService)
    .pipe(catchError(this.manejoError));
  }

  get(uriService: string): Observable<any[]> {  
    return this.http.get<any[]>(uriService);
  }

  post(uriService: string, req: any):
    Observable<any> {
      let body = req;
      return this.http.post(uriService, body);

  }

  put(uriService: string, req: any):
    Observable<any> {
    let body = req;
    return this.http.put(uriService, body)
      .pipe(catchError(this.manejoError));
  }

  delete(uriService: string): Observable<any[]> {
    return this.http.delete(uriService)
    .pipe(catchError(this.manejoError));
  }

  private extractData(res: Response) {
    let body = res.json();
    return body;
  }

  private handleError(error: any) {
    let errMsg = (error.message) ? error.message :
      error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    console.error(errMsg);
    return Observable.throw(error.errMsg);
  }
  private manejoError(error: HttpErrorResponse){
    let mensaje: string;  
    if(error.status==0){
      mensaje="Verifique la conexión del equipo en la red.";
    }else{
      if(error.status == 400 ){
        mensaje = error.error.Message;
      }else{
        mensaje = "ha sucedido un error"
      }
    }
    return Observable.throw(mensaje);
  } 
}