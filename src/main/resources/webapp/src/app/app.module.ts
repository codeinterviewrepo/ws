import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'; 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AuthService } from './service/auth.service';
import { LoggedInGuard } from './auth-guard/logged-in-guard';
import { LoggedOutGuard } from './auth-guard/logged-out-guard';
import { ListingComponent } from './listing/listing.component';
import { EnrolmentService } from './service/enrolment.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ListingComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule, // required animations module
  ],
  providers: [AuthService, LoggedInGuard, LoggedOutGuard, EnrolmentService], //
  bootstrap: [AppComponent]
})
export class AppModule { }
