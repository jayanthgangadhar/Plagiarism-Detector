import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service.client";
import {ActivatedRoute, Router} from "@angular/router";
import {SharedService} from "../../../services/shared.service.client";
import {HistoryService} from "../../../services/history.service.client";
declare let $;
@Component({
  selector: 'app-operation',
  templateUrl: './operation.component.html',
  styleUrls: ['./operation.component.css']
})
export class OperationComponent implements OnInit {

  user;
  oId;
  studentResults;
  selectedStudent;
  compareResults;

  constructor(private userService: UserService, private router: Router, private sharedService: SharedService,
               private changeDetectorRef: ChangeDetectorRef, private historyService: HistoryService,
               private acRoute: ActivatedRoute) { }

  ngOnInit() {
    this.user = this.sharedService.user;
    this.acRoute.params.subscribe(params => {
      this.oId = params['oid'];
      this.historyService.getStudentResult(this.user.id, this.oId).subscribe(result => {
        this.studentResults = result.data;
        // console.log('student list', this.studentResults);
      });
    });
  }

  selectStudent(s) {
    this.selectedStudent = s;
    this.historyService.getReportsOnStudentCompareId(this.user.id, this.oId, this.selectedStudent.id).subscribe(result => {
      this.compareResults = result.data;
      // console.log('list of files', this.compareResults);
    });
  }

  viewDetail(result) {
    this.sharedService.strategy = 'Weighted Average';
    this.sharedService.compareResult = result;
    this.router.navigate(['compare', 'result']);
  }

  notifyStudents(studentResult) {
    console.log(studentResult);
    this.historyService.notifyStudents(this.user.id, studentResult.student1Id, studentResult.student2Id,
      studentResult.maxSimilarityInAnyTwoFiles).subscribe(result => {
      $('#emailSentModel').modal('show');
    });
  }

}
