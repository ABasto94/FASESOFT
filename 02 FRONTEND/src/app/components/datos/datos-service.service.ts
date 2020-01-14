import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable()
export class DatosServiceService {
  terminoProceso = new Subject();

  constructor() { }

}
