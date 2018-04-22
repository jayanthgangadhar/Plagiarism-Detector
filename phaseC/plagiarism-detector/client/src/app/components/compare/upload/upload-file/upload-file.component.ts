import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {CompareService} from '../../../../services/compare.service.client';
import {SharedService} from '../../../../services/shared.service.client';
import {UserService} from "../../../../services/user.service.client";
import {Router} from "@angular/router";

@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.css']
})
export class UploadFileComponent implements OnInit {
  // @ViewChild('editor1') editor1;
  // @ViewChild('editor2') editor2;
  user;
  fileOne = null;
  fileTwo = null;
  resultDisplay = false;
  text1 = '';
  text2 = '';
  options = {printMargin: false};
  compareResult;
  errorFlag = false;
  errorMsg = 'Must be two python files';

  students;
  student1;
  student2;
  strategies = ['Zhang-Shasha ALgorithm', 'Longest Common Subsequence Algorithm', 'Weighted Average'];
  strategy;

  constructor(private compareService: CompareService, private sharedService: SharedService,
               private userService: UserService, private changeDetectorRef: ChangeDetectorRef,
               private router: Router) { }

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
    // console.log($event);
    if ( $event.target.id === 'file1') {
      this.fileOne = $event.target.files[0];
      // console.log('file one selected: ');
      // console.log(this.fileOne);
    } else {
      this.fileTwo = $event.target.files[0];
      // console.log('file two selected: ');
      // console.log(this.fileTwo);
    }
  }

  uploadFile () {
    if (this.isValidInput()) {
      this.errorFlag = false;
      const formData = new FormData();
      formData.append('uploadingFiles', this.fileOne);
      formData.append('uploadingFiles', this.fileTwo);
      const userId = this.sharedService.user ? this.sharedService.user.id : 0;
      this.compareService.uploadFile(formData, userId, this.student1.id, this.student2.id).subscribe((result) => {
        // console.log('compare result', result);
        this.compareResult = result.data;
        this.showResult();
      });
    } else {
      this.errorFlag = true;
    }
  }

  showResult() {
    this.resultDisplay = true;
    // this.readFile(this.fileOne).then((data: string) => {
    //   this.text1 = data;
    //   // console.log('text1', this.text1);
    // });
    // this.readFile(this.fileTwo).then((data: string) => {
    //   this.text2 = data;
    //   // console.log('text1', this.text1);
    // });
  }

  viewDetail() {
    this.sharedService.compareResult = this.compareResult;
    this.sharedService.strategy = this.strategy;
    this.router.navigate(['compare', 'result']);
  }

  readFile(file) {
    return new Promise(function(resolve, reject) {
      const fileReader = new FileReader();
      fileReader.onload = function(event) {
        // console.log(event);
        resolve(fileReader.result);
      };
      fileReader.readAsText(file);
    });
  }

  isValidInput() {
    // console.log(this.fileOne);
    // console.log(this.fileTwo);
    if (this.fileOne && this.fileTwo && this.isPythonFileName(this.fileOne.name)
         && this.isPythonFileName(this.fileTwo.name)) {
      return true;
    } else {
      return false;
    }
  }

  isPythonFileName(fileName) {
    const res = fileName.split('.');
    // console.log(res, res[res.length - 1] === 'py');
    return res[res.length - 1] === 'py';
  }

}
