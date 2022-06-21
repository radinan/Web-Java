import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  checkUserStatus: boolean = false;
  userBtnVal = "Log in";

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, private userService: UserService, private router: Router) {}

  public loggedInUserCheck(): boolean {
    if (this.userService.getLoggedInUser() === ""){
      console.log("loggedInUserCheck");
      this.userBtnVal = "Log in";
      return false;
    } else {
      this.userBtnVal = "Log out";
      return true;
    }
  }

  ngOnInit(){
    this.checkUserStatus = this.loggedInUserCheck();
  }

  goHome(){
      if (this.userService.getLoggedInUser() === ""){
      this.checkUserStatus=false;
      this.router.navigateByUrl('');
    } else {
      this.checkUserStatus=true;
      this.router.navigateByUrl('home');
    }
  }

  userLogInOrOut(){
    if (this.userService.getLoggedInUser() === ""){
      this.router.navigateByUrl('login');
    } else {
      this.userService.logOut();
      this.userBtnVal="Log in";
    }
  }
}