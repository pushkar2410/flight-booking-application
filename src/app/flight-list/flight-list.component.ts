import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { FlightResponse } from '../model/flightResponse.component';
import { FlightadminserviceService } from '../services/flightadminservice.service';


@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {

  flights: Observable<FlightResponse[]>;

  constructor(private flightservice: FlightadminserviceService) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.flights = this.flightservice.getAllFlight();
  }

}
