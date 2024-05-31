import { TestBed } from '@angular/core/testing';

import { BronikService } from './bronik.service';

describe('BronikService', () => {
  let service: BronikService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BronikService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
