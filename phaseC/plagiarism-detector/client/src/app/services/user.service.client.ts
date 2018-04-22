import { Injectable } from '@angular/core';
import { Http, RequestOptions, Response } from '@angular/http';
import 'rxjs/Rx';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';
import {SharedService} from './shared.service.client';
import 'rxjs/add/operator/catch';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class UserService {

  baseUrl = environment.baseUrl;
  options: RequestOptions = new RequestOptions();

  constructor(private http: Http, private sharedService: SharedService, private router: Router) {
  }

  register(user) {
    const url = this.baseUrl  + '/api/register';
    this.options.withCredentials = true;
    return this.http.post(url, user, this.options)
      .map((response: Response) => {
        return response.json();
      });
  }

  login(email, password) {
    const url = this.baseUrl + '/api/login';
    const credentials = {
      emailAddress: email,
      password: password,
    };
    this.options.withCredentials = true;
    return this.http.post(url, credentials, this.options)
      .map((response: Response) => {
        // console.log(response);
        return response.json();
      }).catch(e => {
        if (e.status === 401) {
          console.log(e);
          return Observable.throw('Unauthorized');
        }
      });
  }

  loggedIn() {
    if (this.sharedService.user) {
      return true;
    } else {
      this.router.navigate(['/']);
      return false;
    }
  }

  createUser(user: any) {
    return this.http.post(this.baseUrl + '/api/user', user)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  findUserById(userId: string) {
    return this.http.get(this.baseUrl + '/api/user/' + userId)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  findAllUsers() {
    return this.http.get(this.baseUrl + '/api/allusers')
      .map((res: Response) => {
      // console.log(res);
          return res.json();
        }
      );
  }

  findUserByEmail(email: string) {
    return this.http.get(this.baseUrl + '/api/user?email=' + email)
      .map((res: Response) => {
          // console.log('User service find by email, response', res);
          return res.json();
        // return null;
        }
      );
  }

  updateUser(user) {
    return this.http.put(this.baseUrl + '/api/user/', user)
      .map((res: Response) => {
          return res.json();
        }
      );
  }

  deleteUser(userId) {
    return this.http.delete(this.baseUrl + '/api/user/' + userId)
      .map((res: Response) => {
          return res.json();
        }
      );
  }

  approveUser(user: any) {
    return this.http.put(this.baseUrl + '/api/user/approve', user)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  rejectUser(user: any) {
    return this.http.put(this.baseUrl + '/api/user/reject', user)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  findStudentsForProfessor(userId, profId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/students/' + profId)
      .map((res: Response) => {
          return res.json();
        }
      );
  }

}
