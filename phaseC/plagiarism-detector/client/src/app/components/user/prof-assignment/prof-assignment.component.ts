import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service.client";
import {Router} from "@angular/router";
import {SharedService} from "../../../services/shared.service.client";
import {CourseService} from "../../../services/course.service.client";
import {AssignmentService} from "../../../services/assignment.service.client";
declare let $;
@Component({
  selector: 'app-prof-assignment',
  templateUrl: './prof-assignment.component.html',
  styleUrls: ['./prof-assignment.component.css']
})
export class ProfAssignmentComponent implements OnInit {

  user;

  courses;
  selectedCourse;

  assignments;
  selectedAssignment;
  editingAssignment;

  nAssnName;
  nAssnDeadline;
  nAssnDoc;
  nAssnType;
  sTypes = ['FILE', 'FOLDER'];

  updateMessageFlag = false;
  updateMessage = 'Successfully Updated';

  constructor(private userService: UserService, private router: Router, private sharedService: SharedService,
               private courseService: CourseService, private changeDetectorRef: ChangeDetectorRef,
               private assignmentService: AssignmentService) { }

  ngOnInit() {
    this.user = this.sharedService.user;
    this.getAllCourses();
  }

  createAssignment() {
    const newAssignment = {
      name: this.nAssnName,
      deadline: this.nAssnDeadline,
      documentUrl: this.nAssnDoc,
      submissionType: this.nAssnType,
      relatedCourseId: this.selectedCourse._id,
      status: 'ACTIVE',
    };
    // console.log('new assignment', newAssignment);
    this.assignmentService.createAssignment(newAssignment, this.user.id).subscribe(r => {
      $('#newAssnModel').modal('hide');
      this.clearCreateModel();
      this.getAllAssignmentsForCourse();
    });
  }

  refreshCourses() {
    this.getAllCourses();
    this.selectedAssignment = null;
    this.selectedCourse = null;
    this.changeDetectorRef.detectChanges();
  }

  getAllAssignmentsForCourse() {
    this.assignmentService.findAssignmentsByCourseId(this.selectedCourse._id, this.user.id).subscribe(result => {
      this.assignments = result.data;
      // console.log('assignments', this.assignments);
    });
  }

  updateAssignment() {
    this.assignmentService.updateAssignment(this.editingAssignment, this.user.id).subscribe(r => {
      this.updateMessageFlag = true;
      this.getAllAssignmentsForCourse();
    });
  }

  deleteAssignment() {
    this.assignmentService.deleteAssignment(this.selectedAssignment._id, this.user.id).subscribe(r => {
      this.selectedAssignment = null;
      this.getAllAssignmentsForCourse();
    });
  }

  editAssignment(a) {
    this.editingAssignment = a;
    this.changeDetectorRef.detectChanges();
    this.updateMessageFlag = false;
    $('#editAssnModel').modal('show');
  }

  getAllCourses() {
    this.courseService.findCourseByFacultyId(this.user.id, this.user.id).subscribe(result => {
      this.courses = result.data;
      // console.log('course', this.courses);
    });
  }

  selectCourse(c) {
    // console.log('select course');
    this.selectedCourse = c;
    this.getAllAssignmentsForCourse();
  }

  selectAssignment(a) {
    this.selectedAssignment = a;
  }

  clearCreateModel() {
    this.nAssnName = null;
    this.nAssnDeadline = null;
    this.nAssnDoc = null;
  }

  viewSubmission() {
    this.router.navigate(['assignment', this.selectedAssignment._id]);
  }

}
