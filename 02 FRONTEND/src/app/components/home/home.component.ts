import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  template: `
    <h2>Bienvenido !!!</h2>
  `
})
export class HomeComponent implements OnInit, OnDestroy {

  constructor(
    private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit() {
  }

  ngOnDestroy() {
  }
}