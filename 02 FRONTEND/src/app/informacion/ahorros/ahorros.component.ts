import { Component, OnInit } from '@angular/core';
import { FasCreditos } from 'app/core/domain/fas-creditos.domain';
import { FasAhorros } from 'app/core/domain/fas-ahorros.domain';
import { UriProvider } from 'app/core/service/uri.provider';
import { GenericClientService } from 'app/core/client/generic-client.service';
import { UriControl } from 'app/core/domain/generic.domain';

@Component({
  selector: 'app-ahorros',
  templateUrl: './ahorros.component.html',
  styleUrls: ['./ahorros.component.css'],
  providers:  [UriProvider, GenericClientService]
})
export class AhorrosComponent implements OnInit {
  private AhorrosList : FasAhorros[];
  constructor(
    private uriProvider: UriProvider,
    private genericClientService: GenericClientService

  ) { }

  ngOnInit() {
    this.getFasAhorrosList(null);
  }

  getFasAhorrosList(queryParamList: [string, string][]) {
   let uriService = this.uriProvider.getUri(new UriControl('FasAhorros', null, null));
    console.log(uriService);
        this.genericClientService.get(uriService)
          .subscribe(result => {this.AhorrosList = result;}
          );
      };
   }

  

