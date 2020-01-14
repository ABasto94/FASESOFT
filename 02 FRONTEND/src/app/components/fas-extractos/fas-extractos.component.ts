
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';

@Component({
  selector: 'fas-extractos',
  templateUrl: './fas-extractos.component.html',
  providers:  [UriProvider]
})
export class FasExtractosComponent implements OnInit {

  constructor(
    private router: Router) {
  }

  ngOnInit(): void {
  }

}