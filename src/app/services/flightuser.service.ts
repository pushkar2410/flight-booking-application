import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { BookingRequest } from '../model/bookingRequest.component';
import { BookingResponse } from '../model/bookingResponse.component';
import { UserSearchFlight } from '../model/userSearchFlight.component';

@Injectable({
  providedIn: 'root'
})
export class FlightuserService {

  private USER_URL = 'http://localhost:9000/api/v1.0/user/flight';

  constructor(private http: HttpClient) { }

  public searchFlight(userSearch: UserSearchFlight): Observable<any> {


    return this.http.post(`${this.USER_URL}/search`, userSearch)
      .pipe(map((data: any) => {
        return data;
      }));
  }

  public bookFlight(bookingReq: BookingRequest, flightId: any): Observable<any> {

    return this.http.post(`${this.USER_URL}/booking/${flightId}`, bookingReq)
      .pipe(map((data: any) => {
        return data;
      }));
  }

  public getTicket(pnrNumber: string): Observable<BookingResponse> {
    return this.http.get<BookingResponse>(`${this.USER_URL}/ticket/${pnrNumber}`)
      .pipe(map((data: any) => {
        return data;
      }));
  }


  public getHistory(email: string): Observable<BookingResponse[]> {
    return this.http.get<BookingResponse[]>(`${this.USER_URL}/booking/history/${email}`)
      .pipe(map((data: any) => {
        return data;
      }));
  }


  public cancelBooking(pnrNumber: string) {
     this.http.delete(`${this.USER_URL}/booking/delete/${pnrNumber}`).subscribe(data => {
      console.log(data);
    });
  }
}