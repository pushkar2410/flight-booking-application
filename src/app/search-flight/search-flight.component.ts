import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FlightResponse } from '../model/flightResponse.component';
import { UserSearchFlight } from '../model/userSearchFlight.component';
import { FlightuserService } from '../services/flightuser.service';
import { Observable } from 'rxjs/internal/Observable';
import { Router } from '@angular/router';
import { ShowDataService } from './search-result/show-data.service';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css'],
  template:  `<app-child [userS]="showFlights"></app-child>`

})
export class SearchFlightComponent implements OnInit {

  userSearch: UserSearchFlight = new UserSearchFlight();
  showFlights: Observable<FlightResponse[]>;

  constructor(private flightUserService:FlightuserService, private router: Router, private sd:ShowDataService) { }

  done: boolean = false;

  ngOnInit(): void {
    
  }

  onSubmit() {
    this.display();
    console.log();
    

  }
  
  display() {
    this.flightUserService.searchFlight(this.userSearch)
      .subscribe(data => {
        console.log(data)
        this.showFlights = data;
        this.sd.searchResp= this.showFlights;
        this.router.navigate(["/searchResult"]);
      });
  }
    
  
}
