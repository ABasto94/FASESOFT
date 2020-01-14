import {
  OnDestroy, OnInit,
  NgModule,
  ComponentRef,
  Injectable,
  Component,
  Injector,
  ViewContainerRef,
  ViewChild, ComponentFactoryResolver} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser'
import {Subject} from 'rxjs/Subject';
import { Subscription } from 'rxjs/Rx';
import { ModalDirective, ModalOptions } from 'ngx-bootstrap';
import {ModalService} from './modal.service';

@Component({
  selector: 'form-modal',
  templateUrl: './form-modal.html'
})

export class ModalComponent implements OnDestroy, OnInit{
  @ViewChild('modalBody', {read: ViewContainerRef}) modalBody;
  @ViewChild('lgModal') public lgModal: ModalDirective;

  cmpRef: ComponentRef<any>;
  private modalServiceSubscription: Subscription;
  modalVar = this;

  constructor(
    private modalService: ModalService,
    private componentFactoryResolver: ComponentFactoryResolver,
    injector: Injector) {


  }

  ngOnInit() {
    console.log('Ontinit modal called');
      this.modalServiceSubscription = this.modalService.showModal.subscribe(type => {
        console.log('modal component subscribe called');
        if (this.cmpRef) {
          this.cmpRef.destroy();
        }
        const factory = this.componentFactoryResolver.resolveComponentFactory(type);
        this.cmpRef = this.modalBody.createComponent(factory);
        if (this.modalService.field !== null && this.modalService.value){
          this.cmpRef.instance[this.modalService.field] = this.modalService.value;
        }
        this.cmpRef.instance['padre'] = this;
        this.lgModal.config.backdrop = 'static';
        this.lgModal.config.keyboard = false;
        this.lgModal.show();
      });
  }

  ngOnDestroy() {
    this.modalServiceSubscription.unsubscribe();
  }

  close() {
    if (this.cmpRef) {
      this.cmpRef.destroy();
    }
    this.cmpRef = null;
    this.lgModal.hide();
  }
}
