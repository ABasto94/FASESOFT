import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import * as MicrosoftGraph from '@microsoft/microsoft-graph-types';
import * as MicrosoftGraphClient from '@microsoft/microsoft-graph-client';
import { AdalService } from 'adal-angular4';
import { Observable } from 'rxjs';

@Injectable()
export class GraphServiceService {

  constructor(
    private http: Http,
    private adalService: AdalService,
  ) { }

  getClient(): MicrosoftGraphClient.Client {
    const client = MicrosoftGraphClient.Client.init({
        authProvider: (done) => {
            done(null,this.adalService.userInfo.token);
        }
    });
    return client;
}

  getMePhoto() {
    const client = this.getClient();
    return Observable.fromPromise(
        client.api('me/photos/120x120/$value')
            .responseType(MicrosoftGraphClient.ResponseType.BLOB)
            .get()
            .then((res) => {
                return res;
            })
    );
}
}
