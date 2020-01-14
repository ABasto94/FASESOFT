
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UriProvider } from '../../core/service/uri.provider';
import { FasPerfilesFormComponent } from './fas-perfiles-form.component';

@Component({
  selector: 'fas-perfiles',
  templateUrl: './fas-perfiles.component.html',
  providers:  [UriProvider]
})
export class FasPerfilesComponent implements OnInit {

  clickCreateProfile= false;
  fasPerfilesFormComponent: FasPerfilesFormComponent;
  
  constructor(
    private router: Router) {
  }

  ngOnInit(): void {
  }

  createProfileClicked(): void{
    this.clickCreateProfile = !this.clickCreateProfile;
  }
  getBackClicked():void{
    window.scroll(0,0);
    this.clickCreateProfile = false;
  }
  
}