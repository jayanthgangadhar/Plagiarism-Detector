import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {SharedService} from "../../../services/shared.service.client";
import {UserService} from "../../../services/user.service.client";
declare let ace;

@Component({
  selector: 'app-compare-result',
  templateUrl: './compare-result.component.html',
  styleUrls: ['./compare-result.component.css']
})
export class CompareResultComponent implements OnInit {

  user;
  compareResult;
  strategy;
  options = {printMargin: false};
  text1;
  text2;
  editor1;
  editor2;
  ranges = [];
  Range = ace.require('ace/range').Range;
  colorCss = ['jy-marker-1', 'jy-marker-2', 'jy-marker-3', 'jy-marker-4', 'jy-marker-5', 'jy-marker-6', 'jy-marker-7', 'jy-marker-8'];
  testRanges = [{from1: 2, to1: 5, from2: 4, to2: 7}, {from1: 15, to1: 20, from2: 8, to2: 13}, {from1: 9, to1: 9, from2: 18, to2: 18}];
  constructor(private sharedService: SharedService,
               private userService: UserService, private changeDetectorRef: ChangeDetectorRef) { }

  ngOnInit() {
    this.user = this.sharedService.user;
    this.compareResult = this.sharedService.compareResult;
    this.strategy = this.sharedService.strategy;
    // console.log('compare result page', this.compareResult);
    // console.log('compare strategy', this.strategy);
    this.text1 = this.compareResult.file1Data;
    this.text2 = this.compareResult.file2Data;
    this.editor1 = ace.edit('editor1');
    this.editor2 = ace.edit('editor2');
    this.testRanges = this.compareResult.similarLines;
    this.rangeCalibrate();
    this.addListener();
    this.markLines();
  }

  rangeCalibrate() {
    this.testRanges.forEach(range => {
      this.ranges.push({
        from1: range.from1 - 1, to1: range.to1 - 1, from2: range.from2 - 1, to2: range.to2 - 1
      });
    });
  }

  markLines() {
    for (let i = 0; i < this.ranges.length; i++) {
      const color = this.colorCss[i % this.colorCss.length];
      this.editor1.session.addMarker(
        new this.Range(this.ranges[i].from1, 0, this.ranges[i].to1, 1), color, 'fullLine');
      this.editor2.session.addMarker(
        new this.Range(this.ranges[i].from2, 0, this.ranges[i].to2, 1), color, 'fullLine');
    }
    // this.editor1.session.addMarker(new this.Range(1, 0, 1, 1), 'jy-marker-green', 'fullLine');
  }

  addListener() {
    const self = this;
    this.editor1.on('click', function(e) {
      // console.log('row: ', e.getDocumentPosition().row);
      self.editorOneClick(e.getDocumentPosition().row);
    });
    this.editor2.on('click', function(e) {
      // console.log('row: ', e.getDocumentPosition().row);
      self.editorTwoClick(e.getDocumentPosition().row);
    });
  }

  editorOneClick(row) {
    for (let i = 0; i < this.ranges.length; i ++) {
      const range = this.ranges[i];
      if (range.from1 <= row && row <= range.to1) {
        this.scrollToRange(range);
      }
    }
  }

  editorTwoClick(row) {
    for (let i = 0; i < this.ranges.length; i ++) {
      const range = this.ranges[i];
      if (range.from2 <= row && row <= range.to2) {
        this.scrollToRange(range);
      }
    }
  }

  scrollToRange(range) {
    const row1 = Math.floor((range.from1 + range.to1) / 2) + 1;
    const row2 = Math.floor((range.from2 + range.to2) / 2) + 1;
    this.editor1.gotoLine(row1, 0, true);
    this.editor2.gotoLine(row2, 0, true);
  }

}
