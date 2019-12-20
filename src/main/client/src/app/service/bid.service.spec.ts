import {inject, TestBed} from '@angular/core/testing';

import {BidServiceService} from './bid.service';

describe('BidServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BidServiceService]
    });
  });

  it('should be created', inject([BidServiceService], (service: BidServiceService) => {
    expect(service).toBeTruthy();
  }));
});
