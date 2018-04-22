import {Component, OnInit, ViewChild} from '@angular/core';
import {CompareService} from '../../../../services/compare.service.client';
import {SharedService} from '../../../../services/shared.service.client';
import {UserService} from "../../../../services/user.service.client";
import {Router} from "@angular/router";
declare let ace: any;

@Component({
  selector: 'app-upload-text',
  templateUrl: './upload-text.component.html',
  styleUrls: ['./upload-text.component.css']
})
export class UploadTextComponent implements OnInit {
  // @ViewChild('editor1') editor1;
  // @ViewChild('editor2') editor2;

  user;
  text1 = '';
  text2 = '';
  options = {printMargin: false};
  editor1;
  editor2;
  Range = ace.require('ace/range').Range;
  compareResult;
  resultDisplay = false;

  errorFlag = false;
  errorMsg = 'Input can not be empty';

  students;
  student1;
  student2;

  strategies = ['Zhang-Shasha ALgorithm', 'Longest Common Subsequence Algorithm', 'Weighted Average'];
  strategy;

  constructor(private userService: UserService, private compareService: CompareService,
               private sharedService: SharedService, private router: Router) { }

  ngOnInit() {
    this.editor1 = ace.edit('editor1');
    this.editor2 = ace.edit('editor2');
    this.user = this.sharedService.user;
    this.findStudents();
    // this.editor1.on('click', function(e) {
    //   console.log(e);
    //   console.log('row: ', e.getDocumentPosition().row);
    // });
  }

  findStudents() {
    this.userService.findStudentsForProfessor(this.user.id, this.user.id).subscribe(result => {
      this.students = result.data;
    });
  }

  compare() {
    // console.log(this.editor1.getValue());
    // this.editor1.session.addMarker(new this.Range(1, 0, 1, 1), 'jy-marker-green', 'fullLine');
    if (this.isInputValid()) {
      this.errorFlag = false;
      const data = {'fileText1': this.text1, 'fileText2': this.text2};
      const userId = this.sharedService.user ? this.sharedService.user.id : 0;
      this.compareService.uploadText(data, userId, this.student1.id, this.student2.id).subscribe((result) => {
        console.log('compare result', result);
        this.compareResult = result.data;
        this.showResult();
      });
    } else {
      this.errorFlag = true;
    }
  }

  viewDetail() {
    this.sharedService.compareResult = this.compareResult;
    this.sharedService.strategy = this.strategy;
    this.router.navigate(['compare', 'result']);
  }

  showResult() {
    this.resultDisplay = true;
  }

  isInputValid() {
    return this.text1.trim().length > 0 && this.text2.trim().length > 0;
  }

}
