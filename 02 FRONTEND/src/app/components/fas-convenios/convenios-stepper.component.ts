import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'convenios-stepper',
  templateUrl: './convenios-stepper.component.html',
})
export class ConveniosStepper implements OnInit {
  @Input('actual') actual: string[];

  constructor() { 
  }

  ngOnInit() {
  }

  onWizardComplete(data){
    console.log('ConveniosStepper complete', data)
  }

}
