export class Flight{
    flightNo: number;
    airline: string;
    srcLocation:string;
    destLocation:string;
    startDate:Date;
    endDate:Date
    scheduledDays:string[];
    instrument:string;
    noOfBusinessClassSeats:number;
    noOfNonBusinessClassSeats:number;
    price:number;
}