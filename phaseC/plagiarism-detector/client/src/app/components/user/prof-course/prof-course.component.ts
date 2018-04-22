import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service.client";
import {Router} from "@angular/router";
import {SharedService} from "../../../services/shared.service.client";
import {CourseService} from "../../../services/course.service.client";
declare let $: any;

@Component({
  selector: 'app-prof-course',
  templateUrl: './prof-course.component.html',
  styleUrls: ['./prof-course.component.css']
})
export class ProfCourseComponent implements OnInit {

  user;

  semesters;
  selectedSemester;
  selectedSemId;

  courses;
  selectedCourse;
  students;

  nCourseName;

  updateMessageFlag = false;
  updateMessage = 'Successfully Updated';

  constructor(private userService: UserService, private router: Router, private sharedService: SharedService,
               private courseService: CourseService, private changeDetectorRef: ChangeDetectorRef) { }

  ngOnInit() {
    this.user = this.sharedService.user;
    this.getAllSemesters();
    this.getAllCourses();
  }

  createCourse() {
    const newCourse = {
      courseName: this.nCourseName,
      facultyID: this.user.id,
      semesterId: this.selectedSemId,
      status: 'ACTIVE',
    };
    // console.log('new course', newCourse);
    this.courseService.createCourse(newCourse, this.user.id).subscribe(r => {
      $('#newCourseModel').modal('hide');
      this.clearCreateModel();
      this.getAllCourses();
    });
  }

  getAllCourses() {
    this.courseService.findCourseByFacultyId(this.user.id, this.user.id).subscribe(result => {
      this.courses = result.data;
      // console.log('course', this.courses);
    });
  }

  updateCourse() {
    this.courseService.updateCourse(this.selectedCourse, this.user.id).subscribe(r => {
      this.updateMessageFlag = true;
      this.getAllCourses();
    });
  }

  deleteCourse() {
    this.courseService.deleteCourse(this.selectedCourse._id, this.user.id).subscribe(r => {
      this.selectedCourse = null;
      this.getAllCourses();
    });
  }

  getAllSemesters() {
    this.courseService.findAllActiveSemesters(this.user.id).subscribe(result => {
      this.semesters = result.data;
      // console.log('semester', this.semesters);
      // this.changeDetectorRef.detectChanges();
    });
  }

  editCourse(c) {
    this.selectedCourse = c;
    this.changeDetectorRef.detectChanges();
    this.updateMessageFlag = false;
    $('#editCourseModel').modal('show');
  }

  showStudents(c) {
    this.courseService.findStudentsForCourse(this.user.id, c._id).subscribe(result => {
      // console.log('students for course', result);
      this.students = result.data;
      this.changeDetectorRef.detectChanges();
      $('#studentListModel').modal('show');
    });
  }

  clearCreateModel() {
    this.nCourseName = null;
  }

}
