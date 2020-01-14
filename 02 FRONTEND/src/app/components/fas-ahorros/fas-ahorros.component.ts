
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';

@Component({
  selector: 'fas-ahorros',
  templateUrl: './fas-ahorros.component.html',
  providers:  [UriProvider]
})
export class FasAhorrosComponent implements OnInit {

  constructor(
    private router: Router) {
  }

  ngOnInit(): void {
  }

}