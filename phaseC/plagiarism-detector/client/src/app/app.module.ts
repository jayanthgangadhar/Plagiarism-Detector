import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {Routing} from './app.routing';
import { HomeComponent } from './components/home/home.component';
import { HistoryComponent } from './components/history/history.component';
import { CompareComponent } from './components/compare/compare.component';
import {SharedService} from './services/shared.service.client';
import {UserService} from './services/user.service.client';
import { ProfileComponent } from './components/user/profile/profile.component';
import { AdminComponent } from './components/admin/admin.component';
import { UploadFileComponent } from './components/compare/upload/upload-file/upload-file.component';
import { UploadTextComponent } from './components/compare/upload/upload-text/upload-text.component';
import { UploadFolderComponent } from './components/compare/upload/upload-folder/upload-folder.component';
import {CompareService} from './services/compare.service.client';
import {AceEditorModule} from 'ng2-ace-editor';
import {AuthenticationService} from './services/authentication.service.client';
import {CourseService} from './services/course.service.client';
import { ProfCourseComponent } from './components/user/prof-course/prof-course.component';
import {AssignmentService} from './services/assignment.service.client';
import { ProfAssignmentComponent } from './components/user/prof-assignment/prof-assignment.component';
import { CourseComponent } from './components/course/course.component';
import { StudentCourseComponent } from './components/user/student-course/student-course.component';
import {HistoryService} from './services/history.service.client';
import { OperationComponent } from './components/history/operation/operation.component';
import { CompareResultComponent } from './components/compare/compare-result/compare-result.component';
import { AssignmentComponent } from './components/course/assignment/assignment.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HistoryComponent,
    CompareComponent,
    ProfileComponent,
    AdminComponent,
    UploadFileComponent,
    UploadTextComponent,
    UploadFolderComponent,
    ProfCourseComponent,
    ProfAssignmentComponent,
    CourseComponent,
    StudentCourseComponent,
    OperationComponent,
    CompareResultComponent,
    AssignmentComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    Routing,
    AceEditorModule,
  ],
  providers: [SharedService, UserService, CompareService, CourseService, AssignmentService, HistoryService, AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
