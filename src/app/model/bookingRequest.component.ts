import { Passenger } from "./Passengers.component";

export class BookingRequest{
    flightNo: number;
    name: string;
    email:string;
    passengers:Passenger[];
    noOfPassenger:number;
    meal:boolean;
    typeOfMeal:number
}