import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { DataService } from '../dataService/data.service';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private router: Router, public dataService: DataService) { }


  canActivate() {

    if (localStorage.getItem('currentUser')) {
    console.log("t",localStorage.getItem('currentUser'));

      return true;
    }
    console.log("f");
    // not logged in so redirect to login page
    //this.router.navigate(['/home']);
    return false;
  }
}
