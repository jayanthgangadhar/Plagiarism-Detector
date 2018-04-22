import { Component, OnInit } from '@angular/core';
import {CompareService} from "../../../../services/compare.service.client";
import {SharedService} from "../../../../services/shared.service.client";
import {UserService} from "../../../../services/user.service.client";
import {Router} from "@angular/router";

@Component({
  selector: 'app-upload-folder',
  templateUrl: './upload-folder.component.html',
  styleUrls: ['./upload-folder.component.css']
})
export class UploadFolderComponent implements OnInit {

  user;
  fileListOne = [];
  fileListTwo = [];
  resultDisplay = false;
  errorFlag = false;
  errorMsg = 'Both folders can not be empty';
  compareResult = null;
  selectedResult = null;
  selectedIndex;
  compareBtnDisabled = false;

  students;
  student1;
  student2;

  constructor(private compareService: CompareService, private sharedService: SharedService,
               private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.user = this.sharedService.user;
    this.findStudents();
  }

  findStudents() {
    this.userService.findStudentsForProfessor(this.user.id, this.user.id).subscribe(result => {
      this.students = result.data;
    });
  }

  fileEvent($event) {
    console.log($event.target);
    console.log($event.target.files);
    if ( $event.target.id === 'file1') {
      this.fileListOne = this.filterFiles($event.target.files);
      console.log('file list one selected: ');
      console.log(this.fileListOne);
    } else {
      this.fileListTwo = this.filterFiles($event.target.files);
      console.log('file list two selected: ');
      console.log(this.fileListTwo);
    }
  }

  uploadFolder() {
    if (this.isValidInput()) {
      this.compareBtnDisabled = true;
      this.errorFlag = false;
      const formData = new FormData();
      for (let i = 0; i < this.fileListOne.length; i++) {
        formData.append('fileList1', this.fileListOne[i]);
      }
      for (let i = 0; i < this.fileListTwo.length; i++) {
        formData.append('fileList2', this.fileListTwo[i]);
      }
      const userId = this.sharedService.user ? this.sharedService.user.id : 0;
      this.compareService.uploadFolder(formData, userId, this.student1.id, this.student2.id).subscribe((result) => {
        this.compareResult = result.data;
        console.log('compare result', this.compareResult);
        this.compareBtnDisabled = false;
      });
    } else {
      this.errorFlag = true;
    }
  }

  viewDetail() {
    // this.sharedService.compareResult = this.compareResult;
    this.router.navigate(['operation', this.compareResult]);
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
    return this.fileListOne.length > 0 && this.fileListTwo.length > 0;
  }

  selectRow(index) {
    // console.log('select row', index);
    this.selectedIndex = index;
    this.selectedResult = this.compareResult[index];
    // console.log('select result:', this.selectedResult);
  }

}
