import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BookingResponse } from '../model/bookingResponse.component';
import { FlightuserService } from '../services/flightuser.service';

@Component({
  selector: 'app-show-ticket',
  templateUrl: './show-ticket.component.html',
  styleUrls: ['./show-ticket.component.css']
})
export class ShowTicketComponent implements OnInit {

  bookingResult: BookingResponse;
  bookRes:BookingResponse = new BookingResponse();
  
  constructor(private userService:FlightuserService) { }

  ngOnInit(): void {
    this.getPnr();
  }
  getPnr() {
    console.log( this.bookRes.pnrNumber);
    this.userService.getTicket(this.bookRes.pnrNumber).subscribe(
      (res => {this.bookingResult =res}));
  }
}
