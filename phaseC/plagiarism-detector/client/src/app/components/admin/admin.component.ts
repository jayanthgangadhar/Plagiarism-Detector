import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service.client';
import {Router} from '@angular/router';
import {SharedService} from '../../services/shared.service.client';
import {CourseService} from "../../services/course.service.client";
declare let $: any;
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  currentUser;
  users;
  selectedUser;

  nfirstName;
  nlastName;
  nemailAddress;
  npassword;
  nuserRole;
  roles = ['Professor', 'Student', 'Admin'];
  status = ['APPROVAL', 'ACTIVE', 'REJECTED'];

  pendingUsers;
  updateMessageFlag = false;
  updateMessage = 'Successfully Updated';

  semesters;
  selectedSemester;
  nSemesterName;
  semesterStatus = ['ACTIVE', 'INACTIVE'];

  constructor(private userService: UserService, private router: Router, private sharedService: SharedService,
               private courseService: CourseService) { }

  ngOnInit() {
    this.currentUser = this.sharedService.user;
    if (this.currentUser) {
      this.getAllUsers();
      this.getAllSemesters();
    }
    // const u1 = {firstName: 'Bob', lastName: 'Marley'};
    // const u2 = {firstName: 'Charley', lastName: 'Cici'};
    // this.users = [u1, u2];
    // console.log(this.users);
    // this.currentUser = this.sharedService.user;
    // this.userService.findAllUsers().subscribe(result => {
    //   this.users = result;
    // });
  }

  selectUser(user) {
    this.selectedUser = user;
    this.updateMessageFlag = false;
  }

  createUser() {
    const newUser = {
      firstName: this.nfirstName,
      lastName: this.nlastName,
      emailAddress: this.nemailAddress,
      password: this.npassword,
      role: this.nuserRole,
    };
      this.userService.createUser(newUser).subscribe(r => {
        $('#newUserModel').modal('hide');
        this.clearCreateModel();
        this.getAllUsers();
      });
  }

  updateUser() {
    this.userService.updateUser(this.selectedUser).subscribe(r => {
      this.updateMessageFlag = true;
      this.getAllUsers();
    });
  }

  deleteUser() {
    this.userService.deleteUser(this.selectedUser.id).subscribe(r => {
      this.selectedUser = null;
      this.getAllUsers();
    });
  }

  getAllUsers() {
    this.userService.findAllUsers().subscribe(result => {
      this.users = result.data;
      this.pendingUsers = this.users.filter(u => {
        return u.status === 'APPROVAL';
      });
      // console.log('pending users: ', this.pendingUsers);
    });
  }

  approveUser(user) {
    this.userService.approveUser(user).subscribe(result => {
      this.getAllUsers();
    });
  }

  rejectUser(user) {
    this.userService.rejectUser(user).subscribe(result => {
      this.getAllUsers();
    });
  }

  clearCreateModel() {
    this.nfirstName = null;
    this.nlastName = null;
    this.nemailAddress = null;
    this.npassword = null;
    this.nuserRole = null;
    this.nSemesterName = null;
  }

  selectSemester(s) {
    this.selectedSemester = s;
    this.updateMessageFlag = false;
  }

  createSemester() {
    const newSemester = {
      name: this.nSemesterName,
      status: 'ACTIVE',
    };
    this.courseService.createSemester(newSemester, this.currentUser.id).subscribe(r => {
      $('#newSemesterModel').modal('hide');
      this.clearCreateModel();
      this.getAllSemesters();
    });
  }

  updateSemester() {
    this.courseService.updateSemester(this.selectedSemester, this.currentUser.id).subscribe(r => {
      this.updateMessageFlag = true;
      this.getAllSemesters();
    });
  }

  deleteSemester() {
    this.courseService.deleteSemester(this.selectedSemester._id, this.currentUser.id).subscribe(r => {
      this.selectedSemester = null;
      this.getAllSemesters();
    });
  }

  getAllSemesters() {
    this.courseService.findAllSemesters(this.currentUser.id).subscribe(result => {
      // console.log('semester', result);
      this.semesters = result.data;
    });
  }


}
