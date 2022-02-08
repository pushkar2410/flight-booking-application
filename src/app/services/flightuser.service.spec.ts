import { TestBed } from '@angular/core/testing';

import { FlightuserService } from './flightuser.service';

describe('FlightuserService', () => {
  let service: FlightuserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FlightuserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
