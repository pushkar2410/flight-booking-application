import { Location } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FlightResponse } from '../../model/flightResponse.component';
import { UserSearchFlight } from '../../model/userSearchFlight.component';
import { FlightuserService } from '../../services/flightuser.service';
import { ShowDataService } from './show-data.service';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css'],
})
export class SearchResultComponent implements OnInit {

  userSearch: UserSearchFlight = new UserSearchFlight();
  //showFlights: Observable<FlightResponse[]>;

  constructor(private flightUserService: FlightuserService, private location: Location,private router: Router,  private sd:ShowDataService) { 
     
  }

  userS:any;

  // userS: any = this.location.getState();

  ngOnInit(): void { 
      this.userS = this.sd.searchResp; 
  
  }

  // onSubmit() {
  //   this.display();
  // }
  // display() {
  //   this.flightUserService.searchFlight(this.userS)
  //     .subscribe(data => {
  //       console.log(data)
  //       this.showFlights = data;
  //     });
  // }
}
