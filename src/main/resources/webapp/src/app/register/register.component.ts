import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../model/user';

import { AuthService } from '../service/auth.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html'
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  loading = false;
  submitted = false;
  currentUser : User;
  alreadyExists : boolean = false;
  successfulRegister : boolean = false;


  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService : AuthService,
  ) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required,Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
  });
    this.authService.currentUser.subscribe(x => this.currentUser = x);
  }

  get fval() { return this.registerForm.controls; }

  onFormSubmit(){
    this.alreadyExists = false;
    // return for here if form is invalid
    if (this.registerForm.invalid
      ||this.successfulRegister) {
      return;
    }
    this.loading = true;
    this.authService.register(this.registerForm.value).subscribe(
      (data)=>{
        this.loading = false;
        if(data){
          this.successfulRegister = true;
        }
        else{
          this.alreadyExists = true;
        }
     },
      (error)=>{
        console.log(error);
        this.loading = false;
      }
    )

  }

}
