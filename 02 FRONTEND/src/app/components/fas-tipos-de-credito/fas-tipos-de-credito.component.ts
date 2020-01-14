
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';

@Component({
  selector: 'fas-tipos-de-credito',
  templateUrl: './fas-tipos-de-credito.component.html',
  providers:  [UriProvider]
})
export class FasTiposDeCreditoComponent implements OnInit {

  constructor(
    private router: Router) {
  }

  ngOnInit(): void {
  }

}