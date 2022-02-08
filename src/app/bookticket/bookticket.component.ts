import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { BookingRequest } from '../model/bookingRequest.component';
import { FormBuilder, FormGroup, FormArray } from '@angular/forms';
import { Passenger } from '../model/Passengers.component';
import { FlightuserService } from '../services/flightuser.service';
import { BookingResponse } from '../model/bookingResponse.component';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-bookticket',
  templateUrl: './bookticket.component.html',
  styleUrls: ['./bookticket.component.css']
})
export class BookticketComponent implements OnInit {
  passengerForm: FormGroup;
 
  bookingReq: BookingRequest = new BookingRequest();
  passList: Passenger = new Passenger();

  passListArray: Passenger[] = [];

  bookingRes: Observable<BookingResponse>;

  constructor(private formBuilder: FormBuilder, private location: Location, private userService: FlightuserService) {
    this.passengerForm = this.formBuilder.group({

      flightNo: '',
      name: '',
      email: '',
      passengers: this.formBuilder.array([]),
      noOfPassenger: '',
      meal: '',
      typeOfMeal: ''
    });
  }

  passengers(): FormArray{
    return this.passengerForm.get("passengers") as FormArray
  }

  flightId: any = this.location.getState();
  totolP = 0;

  ngOnInit(): void {

  }
  
  createPassengerList(): FormGroup {
    return this.formBuilder.group({
      firstName: '',
      lastName: '',
      gender: '',
      age: '',
      seatNo: '',
    })
  }

  addPassenger() {
    this.passengers().push(this.createPassengerList());
    this.totolP = this.totolP + 1;
  }

  get passengerList(): FormArray {
    return this.passengerForm.get("passengers") as FormArray
  }

  onSubmit() {

    this.savetoPassengerArray()
    this.bookingReq.passengers = this.passListArray;

    console.log("this.bookingReq===" + this.passengerForm.value)
    console.log("this.bookingReq.passengers - " + this.bookingReq.passengers)
    console.log("this.bookingReq- " + this.bookingReq.email)

    this.book();
  }

  savetoPassengerArray() {

    for (let i = 0; i < this.passengers().value.length; i++) {
      this.passList.firstName = this.passengers().value[i].firstName;
      this.passList.lastName = this.passengers().value[i].lastName;
      this.passList.gender = this.passengers().value[i].gender;
      this.passList.age = this.passengers().value[i].age;
      this.passList.seatNo = this.passengers().value[i].seatNo;
      this.passListArray.push(this.passList);
    }
  }

  book() {
    this.userService.bookFlight(this.bookingReq, this.flightId.flightId)
      .subscribe(data => {
        console.log(data)
        this.bookingRes = data;

        // Pending show ticket
      });
  }

}
