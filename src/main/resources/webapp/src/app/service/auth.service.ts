import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from '../model/user';

@Injectable({ providedIn: 'root' })
export class AuthService {
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    private url : string = "http://localhost:8080/";

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(email: string, password: string) {
        return this.http.post<any>(this.url+`authrest/login`, { email, password })
            .pipe(map(user => {
                if (user && user.token) {
                    // store user details in local storage to keep user logged in
                    console.log(user.result);
                    localStorage.setItem('currentUser', JSON.stringify(user.result));
                    this.currentUserSubject.next(user);
                }
                console.log(user);
                return user;
            }));
    }

    logout(){
        localStorage.removeItem('currentUser');
    }

    register(user: User) {
        return this.http.post(this.url+`authrest/register`, user);
    }

}