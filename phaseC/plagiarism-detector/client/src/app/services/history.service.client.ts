import { Injectable } from '@angular/core';
import { Http, RequestOptions, Response } from '@angular/http';
import 'rxjs/Rx';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';
import {SharedService} from './shared.service.client';
import 'rxjs/add/operator/catch';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class HistoryService {

  baseUrl = environment.baseUrl;
  options: RequestOptions = new RequestOptions();

  constructor(private http: Http, private sharedService: SharedService, private router: Router) {
  }

  getOperationsByUserId(userId) {
    return this.http.get(this.baseUrl + '/api/user/' + userId + '/operation')
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  getStudentResult(userId, oId) {
    return this.http.get(this.baseUrl + '/api/user/' + userId + '/operation/' + oId + '/studentsInvolved')
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  getReportsOnStudentCompareId(userId, oId, sId) {
    return this.http.get(this.baseUrl + '/api/user/' + userId + '/operation/' + oId + '/studentsInvolved/' + sId)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  notifyStudents(userId, s1Id, s2Id, score) {
    return this.http.post(this.baseUrl + '/api/user/studentNotif?userId='
      + userId + '&st1Id=' + s1Id + '&st2Id=' + s2Id + '&sim=' + score, userId).map(
      (res: Response) => {
        return res.json();
      }
    );
  }

}
