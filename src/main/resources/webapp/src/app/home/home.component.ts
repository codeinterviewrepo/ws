import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {
  public currentUser;
  constructor(private router: Router,) {
    this.currentUser = localStorage.getItem('currentUser')? JSON.parse(localStorage.getItem('currentUser')) : '';
   }

  ngOnInit() {
    if(this.currentUser)
      this.router.navigate(['/listing']);
  }

}
