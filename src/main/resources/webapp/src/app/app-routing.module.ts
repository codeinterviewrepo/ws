import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

/**Componenets */
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import {LoggedInGuard} from './auth-guard/logged-in-guard'
import { LoggedOutGuard } from './auth-guard/logged-out-guard';
import { ListingComponent } from './listing/listing.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent, canActivate: [LoggedOutGuard] },
  { path: 'register', component: RegisterComponent, canActivate: [LoggedOutGuard] },
  { path: 'listing', component: ListingComponent, canActivate: [LoggedInGuard]},
  { path: '**', redirectTo: '' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
