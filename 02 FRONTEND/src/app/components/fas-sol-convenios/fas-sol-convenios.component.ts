
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';

@Component({
  selector: 'fas-sol-convenios',
  templateUrl: './fas-sol-convenios.component.html',
  providers:  [UriProvider]
})
export class FasSolConveniosComponent implements OnInit {

  constructor(
    private router: Router) {
  }

  ngOnInit(): void {
  }

}