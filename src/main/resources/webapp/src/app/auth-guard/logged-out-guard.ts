import { CanActivate } from "@angular/router";
import { Injectable } from '@angular/core';

@Injectable()
export class LoggedOutGuard implements CanActivate {

  canActivate() {
    return localStorage.getItem('currentUser') ? false : true;
  }
}



