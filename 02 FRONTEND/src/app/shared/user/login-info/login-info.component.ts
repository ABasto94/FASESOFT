import {Component, OnInit} from '@angular/core';
import {UserService} from "../user.service";
import {LayoutService} from "../../layout/layout.service";
import { AdalService } from 'adal-angular4';

@Component({

  selector: 'sa-login-info',
  templateUrl: './login-info.component.html',
})
export class LoginInfoComponent implements OnInit {

  user:any;
  nombreUsuario:string;

  constructor(
    private userService: UserService,
    private layoutService: LayoutService,
    private adalService:AdalService
    ) {
  }

  ngOnInit() {
    this.adalService.getUser().subscribe(result=>{
      this.nombreUsuario=result.profile.given_name;
    });
    this.userService.getLoginInfo().subscribe(user => {
      this.user = user
    })

  }

  toggleShortcut() {
    this.layoutService.onShortcutToggle()
  }

}
