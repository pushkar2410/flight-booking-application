import { Component, OnInit } from '@angular/core';
import { FlightadminserviceService } from '../services/flightadminservice.service';
import { Flight } from '../model/flight.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addflight',
  templateUrl: './addflight.component.html',
  styleUrls: ['./addflight.component.css']
})
export class AddflightComponent implements OnInit {

  flight: Flight = new Flight();

  constructor(private flightservice:FlightadminserviceService, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.save();
  }
  save() {
    this.flightservice.addFlight(this.flight)
      .subscribe(data => console.log(data), error => console.log(error));

      this.router.navigate(["flightList"]);
  }

}
