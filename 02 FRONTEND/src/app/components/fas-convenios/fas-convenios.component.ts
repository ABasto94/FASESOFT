
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';

@Component({
  selector: 'fas-convenios',
  templateUrl: './fas-convenios.component.html',
  providers:  [UriProvider]
})
export class FasConveniosComponent implements OnInit {

  constructor(
    private router: Router) {
  }

  ngOnInit(): void {
  }

}