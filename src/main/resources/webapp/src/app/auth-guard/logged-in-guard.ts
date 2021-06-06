import { CanActivate } from "@angular/router";
import { Injectable } from '@angular/core';

@Injectable()
export class LoggedInGuard implements CanActivate {

  canActivate() {
    return localStorage.getItem('currentUser') ? true : false;
  }
}



