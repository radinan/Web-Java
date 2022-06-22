import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { AppComponent } from './app.component';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private router:Router, private http: HttpClient) { }

  logIn( name: string, password: string){
    if (name == "admin" && password == "admin"){
      this.router.navigateByUrl('home');
      localStorage.setItem("username", name);
    }
  }

  getLoggedInUser() {
    var username = localStorage.getItem("username") || '';
    return username;
  }

  logOut(){
    this.router.navigateByUrl('');
    localStorage.removeItem("username");
  }

  dbLogIn(name: string, password: string) {
    return this.http.post<any>(AppComponent.url + "/users",
      {
        user: name,
        password: password
      });

  }

}