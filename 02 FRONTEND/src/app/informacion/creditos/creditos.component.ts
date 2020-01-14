import { Component, OnInit } from '@angular/core';
import { GenericClientService } from 'app/core/client/generic-client.service';
import { FasTiposDeCredito } from 'app/core/domain/fas-tipos-de-credito.domain';
import { FasCreditos } from 'app/core/domain/fas-creditos.domain';
import { UriControl } from '../../core/domain/generic.domain';
import { UriProvider } from 'app/core/service/uri.provider';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'app-creditos',
  templateUrl: './creditos.component.html',
  styleUrls: ['./creditos.component.css'],
  providers:  [UriProvider, GenericClientService]
})
export class CreditosComponent implements OnInit {
  product = {
    slides: [
      {
        src: 'assets/img/demo/e-comm/detail-1.png',
      },
      {
        src: 'assets/img/demo/e-comm/detail-2.png'
      },
      {
        src: 'assets/img/demo/e-comm/detail-3.png'
      }
    ]
  }


  private CreditosList : FasCreditos[];
  private creditosList : FasTiposDeCredito[];
  
  constructor(
    private uriProvider: UriProvider,
    private genericClientService: GenericClientService

  ) { }

  ngOnInit() {
    this.getFasCreditosList(null);
  }


  imprimir(){
    console.log(this.creditosList);
  }

  getFasCreditosList(queryParamList: [string, string][]) {

   let serviceProvider : string = 'FasTiposDeCredito';
   let uriService = this.uriProvider.getUri(new UriControl(serviceProvider,null, null));
   console.log(uriService);

       this.genericClientService.get(uriService)
         .subscribe(result => {
           this.CreditosList = result;
          console.log(result);
          
          }
         );
     
         }
      

         

}
