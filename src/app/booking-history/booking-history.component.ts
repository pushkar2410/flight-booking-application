import { Component, OnInit } from '@angular/core';
import { BookingResponse } from '../model/bookingResponse.component';
import { FlightuserService } from '../services/flightuser.service';

@Component({
  selector: 'app-booking-history',
  templateUrl: './booking-history.component.html',
  styleUrls: ['./booking-history.component.css']
})
export class BookingHistoryComponent implements OnInit {

  bookingHistory: BookingResponse[] = [];
  bookRes: BookingResponse = new BookingResponse();

  constructor(private userService: FlightuserService) { }

  ngOnInit(): void {
  }

  getHistory() {
    this.userService.getHistory(this.bookRes.email).subscribe(
      (res => { this.bookingHistory = res }));
  }
}
