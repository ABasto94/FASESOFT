
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';

@Component({
  selector: 'fas-roles',
  templateUrl: './fas-roles.component.html',
  providers:  [UriProvider]
})
export class FasRolesComponent implements OnInit {

  constructor(
    private router: Router) {
  }

  ngOnInit(): void {
  }

}