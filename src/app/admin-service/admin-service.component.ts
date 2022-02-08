import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-service',
  templateUrl: './admin-service.component.html',
  styleUrls: ['./admin-service.component.css']
})
export class AdminServiceComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  addFlight(){
    this.router.navigate(["addFlight"])
  }

  viewFlight(){
    this.router.navigate(["flightList"])
  }

  blockFlight(){
    this.router.navigate(["blockFlight"])
  }
}
