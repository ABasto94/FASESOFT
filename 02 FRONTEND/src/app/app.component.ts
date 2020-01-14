import {Component, ViewContainerRef} from '@angular/core';

import { environment } from '../environments/environment';
import { AdalService } from 'adal-angular4';

@Component({
  selector: 'app-root',
  template: '<router-outlet></router-outlet>'
})
export class AppComponent {
  public title = 'app works!';

  public constructor(private viewContainerRef: ViewContainerRef, private adalService: AdalService) {
    adalService.init(environment.config);
    this.adalService.handleWindowCallback();
  }
    
}
