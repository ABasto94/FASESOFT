import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadFormsComponent } from './upload-forms.component';

describe('UploadFormsComponent', () => {
  let component: UploadFormsComponent;
  let fixture: ComponentFixture<UploadFormsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadFormsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadFormsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
