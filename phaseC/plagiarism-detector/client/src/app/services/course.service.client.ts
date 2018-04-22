import { Injectable } from '@angular/core';
import { Http, RequestOptions, Response } from '@angular/http';
import 'rxjs/Rx';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';
import {SharedService} from './shared.service.client';
import 'rxjs/add/operator/catch';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class CourseService {

  baseUrl = environment.baseUrl;
  options: RequestOptions = new RequestOptions();

  constructor(private http: Http, private sharedService: SharedService, private router: Router) {
  }

  createSemester(semester: any, userId) {
    return this.http.post(this.baseUrl + '/api/' + userId + '/semester', semester)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  findSemesterById(sId, userId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/semester/' + sId)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  findAllSemesters(userId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/semester')
      .map((res: Response) => {
          return res.json();
        }
      );
  }

  findAllActiveSemesters(userId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/semester/active')
      .map((res: Response) => {
          return res.json();
        }
      );
  }

  updateSemester(semester: any, userId) {
    return this.http.put(this.baseUrl + '/api/' + userId + '/semester', semester)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  deleteSemester(sId: any, userId) {
    return this.http.delete(this.baseUrl + '/api/' + userId + '/semester/remove/' + sId)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  createCourse(course: any, userId) {
    return this.http.post(this.baseUrl + '/api/' + userId + '/course', course)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  findAllCourses(userId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/courses')
      .map((res: Response) => {
          return res.json();
        }
      );
  }

  findCourseBySemesterId(userId, sId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/courses/' + sId)
      .map((res: Response) => {
          return res.json();
        }
      );
  }

  findCourseByFacultyId(userId, fId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/course/faculty/' + fId)
      .map((res: Response) => {
          return res.json();
        }
      );
  }

  findCourseById(cId, userId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/course/' + cId)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  findStudentsForCourse(userId, cId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/course/students/' + cId)
      .map((res: Response) => {
          return res.json();
        }
      );
  }

  findCoursesForStudent(userId) {
    return this.http.get(this.baseUrl + '/api/' + userId + '/enrolledcourses')
      .map((res: Response) => {
          return res.json();
        }
      );
  }

  updateCourse(course: any, userId) {
    return this.http.put(this.baseUrl + '/api/' + userId + '/course', course)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  deleteCourse(cId: any, userId) {
    return this.http.delete(this.baseUrl + '/api/' + userId + '/course/' + cId)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  enrollCourse(course: any, userId) {
    return this.http.put(this.baseUrl + '/api/student/enroll/' + userId, course)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

  dropCourse(course: any, userId) {
    return this.http.put(this.baseUrl + '/api/student/drop/' + userId, course)
      .map(
        (res: Response) => {
          return res.json();
        }
      );
  }

}
