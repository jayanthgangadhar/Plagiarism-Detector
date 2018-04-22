import {Routes, RouterModule} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {CompareComponent} from './components/compare/compare.component';
import {HistoryComponent} from './components/history/history.component';
import {ProfileComponent} from './components/user/profile/profile.component';
import {AdminComponent} from './components/admin/admin.component';
import {UploadFileComponent} from './components/compare/upload/upload-file/upload-file.component';
import {UploadTextComponent} from './components/compare/upload/upload-text/upload-text.component';
import {UploadFolderComponent} from './components/compare/upload/upload-folder/upload-folder.component';
import {AuthenticationService} from './services/authentication.service.client';
import {CourseComponent} from './components/course/course.component';
import {OperationComponent} from './components/history/operation/operation.component';
import {CompareResultComponent} from './components/compare/compare-result/compare-result.component';
import {AssignmentComponent} from './components/course/assignment/assignment.component';

const APP_ROUTES: Routes = [
  { path : 'compare' , component: CompareComponent, canActivate: [AuthenticationService]},
  { path : 'history' , component: HistoryComponent, canActivate: [AuthenticationService]},
  { path : 'courses' , component: CourseComponent, canActivate: [AuthenticationService]},
  { path : 'profile', component: ProfileComponent, canActivate: [AuthenticationService]},
  { path : 'assignment/:aid', component: AssignmentComponent, canActivate: [AuthenticationService]},
  { path : 'operation/:oid', component: OperationComponent, canActivate: [AuthenticationService]},
  { path : 'compare/result', component: CompareResultComponent, canActivate: [AuthenticationService]},
  { path : 'upload/text', component: UploadTextComponent, canActivate: [AuthenticationService]},
  { path : 'upload/file', component: UploadFileComponent, canActivate: [AuthenticationService]},
  { path : 'upload/folder', component: UploadFolderComponent, canActivate: [AuthenticationService]},
  { path : 'admin', component: AdminComponent, canActivate: [AuthenticationService]},
];

// Export the routes as module providers
export const Routing: ModuleWithProviders = RouterModule.forRoot(APP_ROUTES);
