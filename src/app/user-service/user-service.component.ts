import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-service',
  templateUrl: './user-service.component.html',
  styleUrls: ['./user-service.component.css']
})
export class UserServiceComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  searchFlight() {
    this.router.navigate(["searchFlight"])
  }

  bookFlight() {
    this.router.navigate(["bookTicket"])
  }

  getFlightDetail() {
    this.router.navigate(["showTicket"])
  }

  getFlightHistory() {
    this.router.navigate(["bookingHistory"])
  }

  deleteFlightDetail() {
    this.router.navigate(["cancelBooking"])
  }

}
