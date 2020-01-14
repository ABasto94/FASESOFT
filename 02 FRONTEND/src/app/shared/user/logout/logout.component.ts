import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {NotificationService} from "../../utils/notification.service";
import { AdalService } from 'adal-angular4';

declare var $:any;

@Component({
  selector: 'sa-logout',
  template: `
<div id="logout" (click)="showPopup()" class="btn-header transparent pull-right">
        <span> <a routerlink="/auth/login" title="Cerrar sesión" data-action="userLogout"
                  data-logout-msg="You can improve your security further after logging out by closing this opened browser"><i
          class="fa fa-sign-out"></i></a> </span>
    </div>
  `,
  styles: []
})
export class LogoutComponent implements OnInit {

  constructor(
    private router: Router,
    private notificationService: NotificationService,
    private adalService: AdalService,
    ) { }

  showPopup(){
    this.notificationService.smartMessageBox({
      title : "<i class='fa fa-sign-out txt-color-orangeDark'></i> Cerrar sesión <span class='txt-color-orangeDark'><strong>" + $('#show-shortcut').text() + "</strong></span> ?",
      content : "Puedes mejorar la seguridad cerrando el navegador",
      buttons : '[No][Si]'

    }, (ButtonPressed) => {
      if (ButtonPressed == "Si") {
        this.logout()
      }
    });
  }

  logout(){
    this.adalService.logOut();
    localStorage.removeItem("accesos");
    localStorage.removeItem("correo");
  }

  ngOnInit() {

  }



}
