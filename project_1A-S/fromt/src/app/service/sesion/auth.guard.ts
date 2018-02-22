import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { DataService } from '../dataService/data.service';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private router: Router, public dataService:DataService) { }

  //console.log("holas");

  canActivate() {
    //this.dataService.increment();
   // console.log(this.dataService.get(),"ffffffffffff");


    if (localStorage.getItem('currentUser')) {
    console.log("t",localStorage.getItem('currentUser'));
   //   this.router.navigate(['/home']);
      // logged in so return true
      return true;
    }
    console.log("f");
    // not logged in so redirect to login page
    //this.router.navigate(['/home']);
    return false;
  }
}
