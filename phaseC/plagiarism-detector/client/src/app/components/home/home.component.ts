import { Component, OnInit } from '@angular/core';
import {NavigationEnd, Router} from '@angular/router';
import {SharedService} from '../../services/shared.service.client';
import {UserService} from '../../services/user.service.client';
import {Subscription} from 'rxjs/Subscription';
declare let $: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentUser;
  currentPath;
  userSub: Subscription;
  homeLink = '/';

  firstName;
  lastName;
  emailAddress;
  password1;
  password2;
  userRole;
  roles = ['Professor', 'Student', 'Admin'];
  errorFlag: boolean;
  errorMsg = 'Password does not match';

  loginEmail: string;
  loginPass: string;
  loginErrorFlag: boolean;
  loginErrorMsg = 'Invalid username or password !';

  constructor(private router: Router, private sharedService: SharedService, private userService: UserService) { }

  ngOnInit() {
    this.currentUser = this.sharedService.user;
    this.homeLink = this.currentUser ? '/profile' : '/';
    // console.log('home init, current user:' + this.currentUser);
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.currentPath = event.url;
      }
    });

    this.userSub = this.sharedService.userObservable.subscribe(user => {
      // console.log('user subscribe');
      // console.log(user);
      this.currentUser = user;
      this.homeLink = this.currentUser ? '/profile' : '/';
    });
  }

  register() {
    if (!this.isRegInputValid()) {
      this.errorMsg = 'All fields cannot be empty';
      this.errorFlag = true;
    }else if (this.password1 === this.password2) {
      // console.log('user register', this.emailAddress);
      this.userService.findUserByEmail(this.emailAddress).subscribe((data) => {
        // console.log('find by enail', data);
        // console.log(data.status, data.status === 201, data.status === '201');
        if (data.status === '200') {
          this.errorMsg = 'Username already taken';
          this.errorFlag = true;
        } else {
          this.errorFlag = false;
          const user = {
            firstName: this.firstName,
            lastName: this.lastName,
            emailAddress: this.emailAddress,
            password: this.password1,
            role: this.userRole,
          };
          this.userService.register(user)
            .subscribe((res) => {
              this.sharedService.setUser(res.data);
              // console.log('user register.', res);
              this.clearRegisterModel();
              $('#registerModel').modal('hide');
              this.router.navigate(['profile']);
            });
        }
      });
    } else {
      this.errorMsg = 'Password does not match';
      this.errorFlag = true;
    }
  }

  login() {
    this.userService.login(this.loginEmail, this.loginPass)
      .subscribe((res) => {
        // console.log('User log in: ', res);
        if (res.data) {
          this.loginErrorFlag = false;
          this.sharedService.setUser(res.data);
          this.clearLoginModel();
          $('#loginModel').modal('hide');
          if (res.data.role === 'Admin') {
            this.router.navigate(['admin']);
          } else {
            this.router.navigate(['profile']);
          }
        } else {
          this.loginErrorFlag = true;
        }
      });

      // }, (err) => {
      //   console.log(err);
      //   if (err === 'Unauthorized') {
      //     this.loginErrorFlag = true;
      //   }
      // });
  }

  isRegInputValid() {
    if (this.firstName.trim().length === 0 || this.lastName.trim().length === 0 ||
      this.emailAddress.trim().length === 0 || this.password1.trim().length === 0) {
      return false;
    } else {
      return true;
    }
  }

  clearRegisterModel() {
    this.firstName = null;
    this.lastName = null;
    this.emailAddress = null;
    this.password1 = null;
    this.password2 = null;
    this.errorFlag = false;
  }

  clearLoginModel() {
    this.loginEmail = null;
    this.loginPass = null;
  }

  logOut() {
    this.sharedService.clearUser();
    this.router.navigate(['/']);
    // this.userService.logout().subscribe(result => {
    //   this.router.navigate(['/']);
    // });
  }

}
