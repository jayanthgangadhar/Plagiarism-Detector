import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service.client";
import {ActivatedRoute, Router} from "@angular/router";
import {SharedService} from "../../services/shared.service.client";
import {HistoryService} from "../../services/history.service.client";

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  user;
  operations;

  constructor(private userService: UserService, private router: Router, private sharedService: SharedService,
               private changeDetectorRef: ChangeDetectorRef, private historyService: HistoryService,
               private acRoute: ActivatedRoute) { }

  ngOnInit() {
    this.user = this.sharedService.user;
    this.historyService.getOperationsByUserId(this.user.id).subscribe(result => {
      this.operations = result.data;
      // console.log('history list', this.operations);
    });
  }

  viewDetail(o) {
    this.router.navigate(['operation', o.id]);
  }

}
