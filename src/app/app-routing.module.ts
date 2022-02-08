import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminServiceComponent } from './admin-service/admin-service.component';
import { UserServiceComponent } from './user-service/user-service.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AddflightComponent } from './addflight/addflight.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { SearchResultComponent } from './search-flight/search-result/search-result.component';
import { BookticketComponent } from './bookticket/bookticket.component';
import { ShowTicketComponent } from './show-ticket/show-ticket.component';
import { BookingHistoryComponent } from './booking-history/booking-history.component';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {path:'adminService', component: AdminServiceComponent},
  {path:'userService', component: UserServiceComponent},
  {path:'loginService', component: LoginComponent},
  {path:'signup', component: SignupComponent},
  {path:'addFlight', component: AddflightComponent},
  {path:'flightList', component: FlightListComponent},
  {path:'searchFlight', component: SearchFlightComponent},
  {path:'searchResult', component: SearchResultComponent},
  {path:'bookTicket', component: BookticketComponent},
  {path:'showTicket', component: ShowTicketComponent},
  {path:'bookingHistory', component: BookingHistoryComponent},
  {path:'cancelBooking', component: CancelBookingComponent},
  {path:'admin', component: BoardAdminComponent},
  {path:'mod', component: BoardModeratorComponent},
  {path:'user', component: BoardUserComponent},
  {path:'profile', component: ProfileComponent},
  {path:'register', component: RegisterComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
