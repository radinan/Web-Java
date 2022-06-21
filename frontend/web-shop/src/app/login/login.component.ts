import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NavbarComponent } from '../navbar/navbar.component';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService, private router:Router, private navbar: NavbarComponent) { }

  ngOnInit(): void {
  }

  userLogIn(name: string, password: string){
    this.userService.logIn(name, password);
    this.navbar.userBtnVal = "Log out";
  }
}
