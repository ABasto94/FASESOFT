import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/firestore'
import { AngularFireDatabase } from '@angular/fire/database'
import { FirebaseListObservable } from '@angular/fire/FirebaseListObservable';
import * as firebase from 'firebase';

import { Upload } from './upload';
import { Key } from 'protractor';
import { AngularFireStorage, AngularFireStorageReference } from '@angular/fire/storage';
import { Url } from 'url';
import { Observable, Subject } from 'rxjs';
import { finalize } from 'rxjs/operators';
import { FirebaseZoneScheduler } from '@angular/fire';;

@Injectable()
export class UploadService {
  private path: String = '/uploads';
  private carga: firebase.storage.UploadTask;
  private strore: AngularFirestore;
  private db: AngularFireDatabase;
  private url: any;
  private ref: Url;
  profileUrl: Observable<any | null>;
  urlRespuesta = new Subject<string>();
  prurl: any;

  constructor(private storage: AngularFireStorage) { }

  subirFile(upload: Upload) {
    this.storage.ref(upload.file.name);
    this.storage.upload(upload.file.name, upload.file).then(
      (data) => data.ref.getDownloadURL().then(
        url => {
          this.urlRespuesta.next(url);
        }).catch((error) => {
          this.urlRespuesta.next(null);
        }));
  }
}

