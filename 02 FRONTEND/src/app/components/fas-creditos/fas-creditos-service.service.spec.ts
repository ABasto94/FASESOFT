import { TestBed, inject } from '@angular/core/testing';
 
import { FasCreditosServiceService } from './fas-creditos-service.service';
 
describe('FasCreditosServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FasCreditosServiceService]
    });
  });
 
  it('should be created', inject([FasCreditosServiceService], (service: FasCreditosServiceService) => {
    expect(service).toBeTruthy();
  }));
});
