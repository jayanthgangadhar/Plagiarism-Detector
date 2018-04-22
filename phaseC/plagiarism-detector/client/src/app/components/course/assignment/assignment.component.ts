import { Component, OnInit } from '@angular/core';
import {SharedService} from "../../../services/shared.service.client";
import {ActivatedRoute, Router} from "@angular/router";
import {AssignmentService} from "../../../services/assignment.service.client";
import {CompareService} from "../../../services/compare.service.client";

@Component({
  selector: 'app-assignment',
  templateUrl: './assignment.component.html',
  styleUrls: ['./assignment.component.css']
})

export class AssignmentComponent implements OnInit {

  user;
  aId;
  assignment;
  submissions;
  isComparing = false;
  submissionIds = [];

  constructor(private sharedService: SharedService, private acRoute: ActivatedRoute,
               private assignmentService: AssignmentService, private router: Router,
               private compareService: CompareService) { }

  ngOnInit() {
    this.user = this.sharedService.user;
    this.acRoute.params.subscribe(params => {
      this.aId = params['aid'];
      this.assignmentService.findAssignmentById(this.aId, this.user.id).subscribe(result => {
        this.assignment = result.data;
      });
      this.assignmentService.getSubmissionByAssnId(this.aId, this.user.id).subscribe(result => {
        this.submissions = result.data;
        // console.log('list submission', this.submissions);
      });
    });
  }

  compare() {
    this.isComparing = true;
    this.compareService.compareAssignment(this.user.id, this.aId).subscribe(result => {
      const oid = result.data;
      this.router.navigate(['operation', oid]);
    });
  }

  selectSubmission(s) {
    const index = this.submissionIds.indexOf(s._id);
    if (index === -1) {
      this.submissionIds.push(s._id);
    } else {
      this.submissionIds.splice(index, 1);
    }
    // console.log('submission checked', this.submissionIds);
  }

  compareSelected() {
    const submissions = {
      inputList: this.submissionIds
    };
    this.isComparing = true;
    this.compareService.compareSelectedSubmissions(this.user.id, submissions).subscribe(result => {
      const oid = result.data;
      this.router.navigate(['operation', oid]);
    });
  }
}
