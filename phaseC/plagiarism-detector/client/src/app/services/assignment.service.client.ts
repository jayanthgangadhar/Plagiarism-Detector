import { Injectable } from '@angular/core';
import { Http, RequestOptions, Response } from '@angular/http';
import 'rxjs/Rx';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';
import {SharedService} from './shared.service.client';
import 'rxjs/add/operator/catch';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class AssignmentService {

  baseUrl = environment.baseUrl;
  options: RequestOptions = new RequestOptions();

  constructor(private http: Http, private sharedService: SharedService, private router: Router) {
  }

  createAssignment(assignment: any, userId) {
    return this.http.post(this.baseUrl + '/api/' + userId + '/assignment', assignment)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  findAssignmentById(aId, userId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/assignment/' + aId)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  findAssignmentsByCourseId(cId, userId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/assignment/course/' + cId)
      .map((res: Response) => {
          // console.log(res);
          return res.json();
        }
      );
  }

  updateAssignment(assignment: any, userId) {
    return this.http.put(this.baseUrl + '/api/' + userId + '/assignment', assignment)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  deleteAssignment(aId: any, userId) {
    return this.http.delete(this.baseUrl + '/api/' + userId + '/assignment/remove/' + aId)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  createSubmission(assnId, userId, submission) {
    return this.http.post(this.baseUrl + '/api/' + userId + '/' + assnId + '/submission', submission)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  getSubmissionByAssnId(assnId, userId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/' + assnId + '/submission')
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  getSubmissionByStudentId(sId, userId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/submission/' + sId)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

}
