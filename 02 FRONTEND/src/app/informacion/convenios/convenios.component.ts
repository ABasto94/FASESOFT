import { Component, OnInit, ViewChild } from '@angular/core';
import { FasConvenios } from 'app/core/domain/fas-convenios.domain';
import { UriProvider } from 'app/core/service/uri.provider';
import { GenericClientService } from 'app/core/client/generic-client.service';
import { UriControl } from 'app/core/domain/generic.domain';
import { FadeInTop } from 'app/shared/animations/fade-in-top.decorator';
import { FasTiposConvenios } from 'app/core/domain/fas-tipos-convenios.domain';
import { ModalDirective } from 'ngx-bootstrap';
import { Router } from '@angular/router';
import { AdalService } from 'adal-angular4';

@FadeInTop()
@Component({
  selector: 'app-convenios',
  templateUrl: './convenios.component.html',
  styleUrls: ['./convenios.component.css'],
  providers: [UriProvider, GenericClientService]

})
export class ConveniosComponent implements OnInit {

  @ViewChild('lgModal') public lgModal: ModalDirective;

  public showChildModal(): void {
    this.lgModal.show();
  }

  public hideChildModal(): void {
    this.lgModal.hide();
    this.adalService.login();
    this.router.navigate(['/layout/fas-convenios/base'])
  }

  private ConveniosList: FasConvenios[];
  private TiposConveniosList: FasTiposConvenios[];
  private imagen: any[];

  constructor(
    private uriProvider: UriProvider,
    private genericClientService: GenericClientService,
    private router: Router,
    private adalService: AdalService,
  ) { }

  ngOnInit() {
    this.getFasConveniosList(null);
    this.getFasTiposDeConveniosList(null);
  }
  getFasConveniosList(queryParamList: [string, string][]) {
    let serviceProvider: string = 'FasConvenios';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    this.genericClientService.get(uriService)
      .subscribe(result => {
        this.ConveniosList = result
      },
        error => {

        }
      )
  };

  getFasTiposDeConveniosList(queryParamList: [string, string][]) {
    let serviceProvider: string = 'FasTiposConvenio';
    let uriService = this.uriProvider.getUri(new UriControl(serviceProvider, null, null));
    this.genericClientService.get(uriService)
      .subscribe(result => {
        this.TiposConveniosList = result

      },
        error => {

        }
      )
  };

  validarAcccesoConvenios() {
    this.adalService.getUser().subscribe(respuesta => {
      if (this.adalService.userInfo.authenticated) {
        this.router.navigate(['/layout/fas-convenios/base'])
      }
    }, error => {
      this.lgModal.show();
    });
  }

}


