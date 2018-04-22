import { Injectable } from '@angular/core';
import { Http, RequestOptions, Response } from '@angular/http';
import 'rxjs/Rx';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';
import {SharedService} from './shared.service.client';
import 'rxjs/add/operator/catch';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class CompareService {

  baseUrl = environment.baseUrl;
  constructor(private http: Http) {
  }

  uploadText(data, userId, s1Id, s2Id) {
    return this.http.post(this.baseUrl + '/api/compare/comparetexts/' + userId + '?s1Id=' + s1Id + '&s2Id=' + s2Id, data).map(
      (res: Response) => {
        return res.json();
      }
    );
  }

  uploadFile(formData, userId, s1Id, s2Id) {
    return this.http.post(this.baseUrl + '/api/compare/comparefiles/' + userId + '?s1Id=' + s1Id + '&s2Id=' + s2Id, formData).map(
      (res: Response) => {
        return res.json();
      }
    );
  }

  uploadFolder(formData, userId, s1Id, s2Id) {
    return this.http.post(this.baseUrl + '/api/compare/comparefolders/' + userId + '?s1Id=' + s1Id + '&s2Id=' + s2Id, formData).map(
      (res: Response) => {
        return res.json();
      }
    );
  }

  compareAssignment(userId, assnId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/submission/cmpallsubmissions?asId=' + assnId).map(
      (res: Response) => {
        return res.json();
      }
    );
  }

  compareSelectedSubmissions(userId, submissions) {
    return this.http.post(this.baseUrl + '/api/' + userId + '/submission/cmpallsubmissions', submissions).map(
      (res: Response) => {
        return res.json();
      }
    );
  }



}
