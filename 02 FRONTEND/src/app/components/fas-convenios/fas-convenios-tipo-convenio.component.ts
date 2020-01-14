import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FasTiposConvenio } from 'app/core/domain/fas-tipos-convenio.domain';
import { UriProvider } from 'app/core/service/uri.provider';
import { UriControl } from 'app/core/domain/generic.domain';
import { ActivatedRoute } from '@angular/router';
import { GenericClientService } from 'app/core/client/generic-client.service';

@Component({
  selector: 'fas-convenios-tipo-convenio',
  templateUrl: './fas-convenios-tipo-convenio.component.html',
})
export class ConveniosTipoConvenio implements OnInit {
  @Input('idTipoConvenio') idTipoConvenio: number;
  @Input('ind') indice: number;
  @Input('mapTiposConv') tiposConv: Map<number, string>;

  @Output() propagar = new EventEmitter<Map<number, string>>();
  private tiposConvenios: FasTiposConvenio;
  private sub: any;


  constructor(
      private uriProvider: UriProvider,
      private route: ActivatedRoute,
      private genericClientService: GenericClientService,
    ) { 
  }

  ngOnInit() {
      if(this.idTipoConvenio != null && this.idTipoConvenio !== undefined){
      this.getFasTipoConveniosList([['filterBy=idTipoConvenio', this.idTipoConvenio.toString()]])
      }
  }
  

   getFasTipoConveniosList(queryParamList: [string, string][]) {
       if(this.idTipoConvenio == null) return;
    let serviceProvider : string = 'FasTiposConvenio';

    let queryParams : Array<[string, string]> = new Array<[string, string]>();
    let commonQuery : Array<string> = ['filterBy=idTipoConvenio'];

    if (queryParamList !== null) {
      for (let queryParam of queryParamList) {
        queryParams.push([queryParam[0], this.uriProvider.encodeURI(queryParam[1])]);
        commonQuery = commonQuery.filter(item => item !== queryParam[0]);
      }
    }
    for ( let cq of commonQuery ){
      queryParams.push([cq, this.uriProvider.encodeURI("")]);
    }

    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, queryParams));
    this.sub = this.route
      .params
      .subscribe(params => {
        this.genericClientService.get(uriService)
          .subscribe(result => {
              this.propagar.emit(this.tiposConv.set(this.indice, result[0].tipo));
          });
      });
  }


  onWizardComplete(data){
    console.log('TipoConvenio', data)
  }

}
