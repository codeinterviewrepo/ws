import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AuthService } from '../service/auth.service';
import { User } from '../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  currentUser : User;
  
  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService : AuthService,
  ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });

    this.authenticationService.currentUser.subscribe(x => this.currentUser = x);

  }


    // for accessing to form fields
    get fval() { return this.loginForm.controls; }

  onFormSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;
     this.authenticationService.login(this.fval.email.value, this.fval.password.value)
        .subscribe(
            data => {
              this.router.navigate(['/']);
            },
            error => {
                console.log(error);
                this.loading = false;
            });
  }
}
