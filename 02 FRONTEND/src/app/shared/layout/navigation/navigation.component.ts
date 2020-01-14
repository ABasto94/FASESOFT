import { Component, OnInit } from '@angular/core';
import { FasAccesos } from 'app/core/domain/fas-accesos.domain';


class TipoAcceso {
  accesos: FasAccesos[];
  descripcion: String;
}
@Component({

  selector: 'sa-navigation',
  templateUrl: './navigation.component.html'
})
export class NavigationComponent implements OnInit {
  accesos: FasAccesos[] = [ ];

  descripciones: String[] = [];
  descripciones2: TipoAcceso[] = [];
  constructor() {
  }
  esCelular:boolean=false;
  ngOnInit() {
    this.accesos =  JSON.parse(localStorage.getItem("accesos"));
    //elimina el acceso de home
    let indice = this.accesos.findIndex(acceso => acceso.componente == "/layout/home");
    this.accesos.splice(indice,1);
    this.obtenerDescripciones();
  }

  obtenerDescripciones() {
    this.accesos.map(acceso => {
      this.descripciones.push(acceso.descripcion);
    });
    this.descripciones = this.descripciones.filter((acceso, i, arr) => {
      return arr.indexOf(arr.find(t => t == acceso)) == i;
    });

    this.esCelular=  this.isMobile();
  }
  isMobile(){
    return (
      (navigator.userAgent.indexOf('iPhone')) !=-1||
        (navigator.userAgent.indexOf('Android'))!=-1 ||
        (navigator.userAgent.indexOf('webOS')) !=-1||
        (navigator.userAgent.indexOf('iPod'))!=-1||
        (navigator.userAgent.indexOf('iPad'))!=-1 ||
        (navigator.userAgent.indexOf('BlackBerry'))!=-1
    );
}

}