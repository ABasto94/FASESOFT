import {Component, OnDestroy, OnInit} from '@angular/core';
import { Subscription } from 'rxjs/Rx';

import { ISpinnerState, SpinnerService } from './spinner.service';

@Component({
  selector: 'loading-spinner',
  template: `
    <div *ngIf="visible" class="modal modal_spinner" >
    	<div class="spinner" >
    	</div>
    </div>
  `,
})

export class SpinnerComponent implements OnDestroy, OnInit {
  visible = false;

  private _spinnerStateChanged: Subscription;

  constructor(private _spinnerService: SpinnerService) {

   }

  ngOnInit() {
    console.log('on init called');
    console.log(this._spinnerService.spinnerState);
    this._spinnerStateChanged = this._spinnerService.spinnerState
      .subscribe((state: ISpinnerState) => {
        this.visible = state.show;
        console.log('subscription working');
        console.log(state.show); }
      );

  }

  ngOnDestroy() {
    console.log('on destroy called');
    this._spinnerStateChanged.unsubscribe();
  }
}