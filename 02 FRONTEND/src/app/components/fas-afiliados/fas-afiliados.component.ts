
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';

@Component({
  selector: 'fas-afiliados',
  templateUrl: './fas-afiliados.component.html',
  providers:  [UriProvider]
})
export class FasAfiliadosComponent implements OnInit {

  constructor(
    private router: Router) {
  }

  ngOnInit(): void {
  }

}