import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs/Rx';

export interface ISpinnerState {
  show: boolean;
}

@Injectable()
export class SpinnerService {
  private _spinnerSubject = new Subject<ISpinnerState>();

  spinnerState = <Observable<ISpinnerState>>this._spinnerSubject.asObservable();

  show() {
    console.log("Show called");
    this._spinnerSubject.next(<ISpinnerState>{ show: true });
  }

  hide() {
    console.log("Hide called");
    this._spinnerSubject.next(<ISpinnerState>{ show: false });
  }
}