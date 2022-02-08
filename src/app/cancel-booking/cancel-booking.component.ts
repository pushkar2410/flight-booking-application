import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingResponse } from '../model/bookingResponse.component';
import { FlightuserService } from '../services/flightuser.service';

@Component({
  selector: 'app-cancel-booking',
  templateUrl: './cancel-booking.component.html',
  styleUrls: ['./cancel-booking.component.css']
})
export class CancelBookingComponent implements OnInit {

  bookRes: BookingResponse = new BookingResponse();
  constructor(private userService: FlightuserService) { }

  public isDeleted = false;

  ngOnInit(): void {
  }

  cancelBooking(){
    this.userService.cancelBooking(this.bookRes.pnrNumber);
    this.isDeleted = true;
    //this.router.navigate(['/userService']);
    
  }

}
