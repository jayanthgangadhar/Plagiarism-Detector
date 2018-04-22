import { Component, OnInit } from '@angular/core';
import {UserService} from '../../../services/user.service.client';
import {Router} from '@angular/router';
import {SharedService} from '../../../services/shared.service.client';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user;
  updateMessageFlag = false;
  updateMessage = 'Successfully updated';
  profCourses;
  enrolledCourses;

  constructor(private userService: UserService, private router: Router, private sharedService: SharedService) { }

  ngOnInit() {
    this.user = this.sharedService.user;
    // this.user = {
    //   firstName: 'Alice',
    //   lastName: 'Wonder',
    //   emailAddress: 'alice@wonder.com',
    //   role: 'teacher',
    // };
  }

  updateUser() {
    this.userService.updateUser(this.user)
      .subscribe(res => {
        this.sharedService.setUser(res.data);
        this.user = res.data;
        this.updateMessageFlag = true;
      });
  }

  logOut() {
    this.sharedService.clearUser();
    this.router.navigate(['/']);
    // this.userService.logout().subscribe(result => {
    //   this.router.navigate(['/']);
    // });
  }

}
