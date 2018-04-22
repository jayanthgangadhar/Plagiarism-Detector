import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {SharedService} from "../../services/shared.service.client";
import {CourseService} from "../../services/course.service.client";
import {UserService} from "../../services/user.service.client";

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  user;
  semesters;
  selectedSemester;

  enrolledCourses;
  courses;

  constructor(private sharedService: SharedService, private userService: UserService,
               private courseService: CourseService, private changeDetectorRef: ChangeDetectorRef) { }

  ngOnInit() {
    this.user = this.sharedService.user;
    // console.log('course enroll, user', this.user);
    this.enrolledCourses = this.user.courseEnrolled ? this.user.courseEnrolled : [];
    // console.log('enrolled course id', this.enrolledCourses);
    this.getAllSemesters();
  }

  onChange(sem) {
    this.getAllCoursesForSemester();
  }

  getAllSemesters() {
    this.courseService.findAllActiveSemesters(this.user.id).subscribe(result => {
      this.semesters = result.data;
    });
  }

  getAllCoursesForSemester() {
    this.courseService.findCourseBySemesterId(this.user.id, this.selectedSemester._id).subscribe(result => {
      this.courses = result.data;
      // console.log('course', this.courses);
    });
  }

  updateUser() {
    this.userService.findUserById(this.user.id).subscribe(result => {
      this.user = result.data;
      this.sharedService.setUser(this.user);
      // console.log('update user', this.user);
      this.enrolledCourses = this.user.courseEnrolled;
      // console.log('enrolled course id', this.enrolledCourses);
    });
  }

  enrollCourse(c) {
    this.courseService.enrollCourse(c, this.user.id).subscribe(result => {
      this.getAllCoursesForSemester();
      this.updateUser();
    });
  }

  dropCourse(c) {
    this.courseService.dropCourse(c, this.user.id).subscribe(result => {
      this.getAllCoursesForSemester();
      this.updateUser();
    });
  }

}

