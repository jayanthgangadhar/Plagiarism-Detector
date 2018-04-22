import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service.client";
import {Router} from "@angular/router";
import {SharedService} from "../../../services/shared.service.client";
import {CourseService} from "../../../services/course.service.client";
import {AssignmentService} from "../../../services/assignment.service.client";
declare let $;
@Component({
  selector: 'app-student-course',
  templateUrl: './student-course.component.html',
  styleUrls: ['./student-course.component.css']
})
export class StudentCourseComponent implements OnInit {

  user;

  courses;
  selectedCourse;

  assignments;
  selectedAssignment;

  file = null;
  fileList = [];

  submissions;
  submittedAssnId = [];

  errorFlag = false;
  errorMsg = 'No python file in the folder';

  constructor(private userService: UserService, private router: Router, private sharedService: SharedService,
              private courseService: CourseService, private changeDetectorRef: ChangeDetectorRef,
              private assignmentService: AssignmentService) { }

  ngOnInit() {
    this.user = this.sharedService.user;
    this.courseService.findCoursesForStudent(this.user.id).subscribe(result => {
      this.courses = result.data;
    });
    // console.log('student course', this.courses);
    this.getAllSubmission();
  }

  getAllSubmission() {
    this.assignmentService.getSubmissionByStudentId(this.user.id, this.user.id).subscribe(result => {
      this.submissions = result.data;
      // console.log('student submission', this.submissions);
      if (this.submissions) {
        const assnIds = [];
        this.submissions.forEach(s => {
          assnIds.push(s.homeworkId);
        });
        this.submittedAssnId = assnIds;
        // console.log('submitted ids', this.submittedAssnId);
      } else {
        this.submittedAssnId = [];
      }

    });
  }

  getAllAssignmentsForCourse() {
    this.assignmentService.findAssignmentsByCourseId(this.selectedCourse._id, this.user.id).subscribe(result => {
      this.assignments = result.data;
      // console.log('assignments', this.assignments);
    });
  }

  selectCourse(c) {
    this.selectedCourse = c;
    this.getAllAssignmentsForCourse();
  }

  selectAssignment(a) {
    this.selectedAssignment = a;
  }

  submit() {
    if (this.selectedAssignment.submissionType === 'FILE') {
      $('#uploadFileModel').modal('show');
    } else {
      $('#uploadFolderModel').modal('show');
    }
  }

  fileEvent($event) {
    if ( $event.target.id === 'file') {
      this.file = $event.target.files[0];
    } else {
      this.fileList = this.filterFiles($event.target.files);
    }
  }

  uploadFile() {
    const formData = new FormData();
    formData.append('uploadingFiles', this.file);
    this.assignmentService.createSubmission(this.selectedAssignment._id, this.user.id, formData).subscribe(result => {
      // console.log('submission result', result.data);
      this.getAllSubmission();
      $('#uploadFileModel').modal('hide');
    });
  }

  uploadFolder() {
    const formData = new FormData();
    for (let i = 0; i < this.fileList.length; i++) {
      formData.append('uploadingFiles', this.fileList[i]);
    }
    this.assignmentService.createSubmission(this.selectedAssignment._id, this.user.id, formData).subscribe(result => {
      // console.log('submission result', result.data);
      this.getAllSubmission();
      $('#uploadFolderModel').modal('hide');
    });
  }

  filterFiles(fileList) {
    const resultList = [];
    for (let i = 0; i < fileList.length; i++) {

      if (this.isPythonFileName(fileList[i].name)) {
        resultList.push(fileList[i]);
      }
    }
    return resultList;
  }

  isPythonFileName(fileName) {
    const res = fileName.split('.');
    // console.log(res, res[res.length - 1] === 'py');
    return res[res.length - 1] === 'py';
  }

  isValidInput() {
    return this.fileList.length > 0;
  }

}
