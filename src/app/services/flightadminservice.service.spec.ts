import { TestBed } from '@angular/core/testing';

import { FlightadminserviceService } from './flightadminservice.service';

describe('FlightadminserviceService', () => {
  let service: FlightadminserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FlightadminserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
