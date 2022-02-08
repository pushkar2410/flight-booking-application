import { Passenger } from "./Passengers.component";

export class BookingResponse{
    
    pnrNumber:string;
    flightId: number;
    name: string;
    email:string;
    passengers:Passenger[];
    noOfPassenger:number;
    meal:boolean;
    typeOfMeal:number
}