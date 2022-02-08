import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Flight } from '../model/flight.component';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FlightadminserviceService {

  private ADMIN_URL = 'http://localhost:9000/api/v1.0/admin/flight';

  constructor(private http: HttpClient) { }

  public addFlight(flight: Flight): Observable<Flight> {
    return this.http.post(`${this.ADMIN_URL}/airline/inventory/add`, flight)
                  .pipe(map((response: any) => response.json()));
  }

  public getAllFlight(): Observable<any> {
    return this.http.get(`${this.ADMIN_URL}/showAllFlights`);
  }
}
