import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AdminServiceComponent } from './admin-service/admin-service.component';
import { UserServiceComponent } from './user-service/user-service.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { SignupComponent } from './signup/signup.component';
import { AddflightComponent } from './addflight/addflight.component';
import { HttpClientModule } from '@angular/common/http';
import { FlightListComponent } from './flight-list/flight-list.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { SearchResultComponent } from './search-flight/search-result/search-result.component';
import { BookticketComponent } from './bookticket/bookticket.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ShowTicketComponent } from './show-ticket/show-ticket.component';
import { BookingHistoryComponent } from './booking-history/booking-history.component';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AdminServiceComponent,
    UserServiceComponent,
    FooterComponent,
    LoginComponent,
    SignupComponent,
    AddflightComponent,
    FlightListComponent,
    SearchFlightComponent,
    SearchResultComponent,
    BookticketComponent,
    ShowTicketComponent,
    BookingHistoryComponent,
    CancelBookingComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    ProfileComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
