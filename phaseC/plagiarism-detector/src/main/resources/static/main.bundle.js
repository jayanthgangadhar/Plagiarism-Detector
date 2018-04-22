webpackJsonp(["main"],{

/***/ "./src/$$_gendir lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_gendir lazy recursive";

/***/ }),

/***/ "./src/app/app.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<app-home></app-home>\r\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = (function () {
    function AppComponent() {
        this.title = 'app';
    }
    return AppComponent;
}());
AppComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-root',
        template: __webpack_require__("./src/app/app.component.html"),
        styles: [__webpack_require__("./src/app/app.component.css")]
    })
], AppComponent);

//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ "./src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("./node_modules/@angular/platform-browser/@angular/platform-browser.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_component__ = __webpack_require__("./src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__("./node_modules/@angular/http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__app_routing__ = __webpack_require__("./src/app/app.routing.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__components_home_home_component__ = __webpack_require__("./src/app/components/home/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__components_history_history_component__ = __webpack_require__("./src/app/components/history/history.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__components_compare_compare_component__ = __webpack_require__("./src/app/components/compare/compare.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__components_user_profile_profile_component__ = __webpack_require__("./src/app/components/user/profile/profile.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__components_admin_admin_component__ = __webpack_require__("./src/app/components/admin/admin.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__components_compare_upload_upload_file_upload_file_component__ = __webpack_require__("./src/app/components/compare/upload/upload-file/upload-file.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__components_compare_upload_upload_text_upload_text_component__ = __webpack_require__("./src/app/components/compare/upload/upload-text/upload-text.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__components_compare_upload_upload_folder_upload_folder_component__ = __webpack_require__("./src/app/components/compare/upload/upload-folder/upload-folder.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__services_compare_service_client__ = __webpack_require__("./src/app/services/compare.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17_ng2_ace_editor__ = __webpack_require__("./node_modules/ng2-ace-editor/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_18__services_authentication_service_client__ = __webpack_require__("./src/app/services/authentication.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_19__services_course_service_client__ = __webpack_require__("./src/app/services/course.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_20__components_user_prof_course_prof_course_component__ = __webpack_require__("./src/app/components/user/prof-course/prof-course.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_21__services_assignment_service_client__ = __webpack_require__("./src/app/services/assignment.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_22__components_user_prof_assignment_prof_assignment_component__ = __webpack_require__("./src/app/components/user/prof-assignment/prof-assignment.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_23__components_course_course_component__ = __webpack_require__("./src/app/components/course/course.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_24__components_user_student_course_student_course_component__ = __webpack_require__("./src/app/components/user/student-course/student-course.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_25__services_history_service_client__ = __webpack_require__("./src/app/services/history.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_26__components_history_operation_operation_component__ = __webpack_require__("./src/app/components/history/operation/operation.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_27__components_compare_compare_result_compare_result_component__ = __webpack_require__("./src/app/components/compare/compare-result/compare-result.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_28__components_course_assignment_assignment_component__ = __webpack_require__("./src/app/components/course/assignment/assignment.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};





























var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["M" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__app_component__["a" /* AppComponent */],
            __WEBPACK_IMPORTED_MODULE_6__components_home_home_component__["a" /* HomeComponent */],
            __WEBPACK_IMPORTED_MODULE_7__components_history_history_component__["a" /* HistoryComponent */],
            __WEBPACK_IMPORTED_MODULE_8__components_compare_compare_component__["a" /* CompareComponent */],
            __WEBPACK_IMPORTED_MODULE_11__components_user_profile_profile_component__["a" /* ProfileComponent */],
            __WEBPACK_IMPORTED_MODULE_12__components_admin_admin_component__["a" /* AdminComponent */],
            __WEBPACK_IMPORTED_MODULE_13__components_compare_upload_upload_file_upload_file_component__["a" /* UploadFileComponent */],
            __WEBPACK_IMPORTED_MODULE_14__components_compare_upload_upload_text_upload_text_component__["a" /* UploadTextComponent */],
            __WEBPACK_IMPORTED_MODULE_15__components_compare_upload_upload_folder_upload_folder_component__["a" /* UploadFolderComponent */],
            __WEBPACK_IMPORTED_MODULE_20__components_user_prof_course_prof_course_component__["a" /* ProfCourseComponent */],
            __WEBPACK_IMPORTED_MODULE_22__components_user_prof_assignment_prof_assignment_component__["a" /* ProfAssignmentComponent */],
            __WEBPACK_IMPORTED_MODULE_23__components_course_course_component__["a" /* CourseComponent */],
            __WEBPACK_IMPORTED_MODULE_24__components_user_student_course_student_course_component__["a" /* StudentCourseComponent */],
            __WEBPACK_IMPORTED_MODULE_26__components_history_operation_operation_component__["a" /* OperationComponent */],
            __WEBPACK_IMPORTED_MODULE_27__components_compare_compare_result_compare_result_component__["a" /* CompareResultComponent */],
            __WEBPACK_IMPORTED_MODULE_28__components_course_assignment_assignment_component__["a" /* AssignmentComponent */]
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
            __WEBPACK_IMPORTED_MODULE_3__angular_http__["b" /* HttpModule */],
            __WEBPACK_IMPORTED_MODULE_4__angular_forms__["a" /* FormsModule */],
            __WEBPACK_IMPORTED_MODULE_5__app_routing__["a" /* Routing */],
            __WEBPACK_IMPORTED_MODULE_17_ng2_ace_editor__["a" /* AceEditorModule */],
        ],
        providers: [__WEBPACK_IMPORTED_MODULE_9__services_shared_service_client__["a" /* SharedService */], __WEBPACK_IMPORTED_MODULE_10__services_user_service_client__["a" /* UserService */], __WEBPACK_IMPORTED_MODULE_16__services_compare_service_client__["a" /* CompareService */], __WEBPACK_IMPORTED_MODULE_19__services_course_service_client__["a" /* CourseService */], __WEBPACK_IMPORTED_MODULE_21__services_assignment_service_client__["a" /* AssignmentService */], __WEBPACK_IMPORTED_MODULE_25__services_history_service_client__["a" /* HistoryService */], __WEBPACK_IMPORTED_MODULE_18__services_authentication_service_client__["a" /* AuthenticationService */]],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_2__app_component__["a" /* AppComponent */]]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ "./src/app/app.routing.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Routing; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__components_compare_compare_component__ = __webpack_require__("./src/app/components/compare/compare.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__components_history_history_component__ = __webpack_require__("./src/app/components/history/history.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__components_user_profile_profile_component__ = __webpack_require__("./src/app/components/user/profile/profile.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__components_admin_admin_component__ = __webpack_require__("./src/app/components/admin/admin.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__components_compare_upload_upload_file_upload_file_component__ = __webpack_require__("./src/app/components/compare/upload/upload-file/upload-file.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__components_compare_upload_upload_text_upload_text_component__ = __webpack_require__("./src/app/components/compare/upload/upload-text/upload-text.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__components_compare_upload_upload_folder_upload_folder_component__ = __webpack_require__("./src/app/components/compare/upload/upload-folder/upload-folder.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__ = __webpack_require__("./src/app/services/authentication.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__components_course_course_component__ = __webpack_require__("./src/app/components/course/course.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__components_history_operation_operation_component__ = __webpack_require__("./src/app/components/history/operation/operation.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__components_compare_compare_result_compare_result_component__ = __webpack_require__("./src/app/components/compare/compare-result/compare-result.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__components_course_assignment_assignment_component__ = __webpack_require__("./src/app/components/course/assignment/assignment.component.ts");













var APP_ROUTES = [
    { path: 'compare', component: __WEBPACK_IMPORTED_MODULE_1__components_compare_compare_component__["a" /* CompareComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__["a" /* AuthenticationService */]] },
    { path: 'history', component: __WEBPACK_IMPORTED_MODULE_2__components_history_history_component__["a" /* HistoryComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__["a" /* AuthenticationService */]] },
    { path: 'courses', component: __WEBPACK_IMPORTED_MODULE_9__components_course_course_component__["a" /* CourseComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__["a" /* AuthenticationService */]] },
    { path: 'profile', component: __WEBPACK_IMPORTED_MODULE_3__components_user_profile_profile_component__["a" /* ProfileComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__["a" /* AuthenticationService */]] },
    { path: 'assignment/:aid', component: __WEBPACK_IMPORTED_MODULE_12__components_course_assignment_assignment_component__["a" /* AssignmentComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__["a" /* AuthenticationService */]] },
    { path: 'operation/:oid', component: __WEBPACK_IMPORTED_MODULE_10__components_history_operation_operation_component__["a" /* OperationComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__["a" /* AuthenticationService */]] },
    { path: 'compare/result', component: __WEBPACK_IMPORTED_MODULE_11__components_compare_compare_result_compare_result_component__["a" /* CompareResultComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__["a" /* AuthenticationService */]] },
    { path: 'upload/text', component: __WEBPACK_IMPORTED_MODULE_6__components_compare_upload_upload_text_upload_text_component__["a" /* UploadTextComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__["a" /* AuthenticationService */]] },
    { path: 'upload/file', component: __WEBPACK_IMPORTED_MODULE_5__components_compare_upload_upload_file_upload_file_component__["a" /* UploadFileComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__["a" /* AuthenticationService */]] },
    { path: 'upload/folder', component: __WEBPACK_IMPORTED_MODULE_7__components_compare_upload_upload_folder_upload_folder_component__["a" /* UploadFolderComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__["a" /* AuthenticationService */]] },
    { path: 'admin', component: __WEBPACK_IMPORTED_MODULE_4__components_admin_admin_component__["a" /* AdminComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_8__services_authentication_service_client__["a" /* AuthenticationService */]] },
];
// Export the routes as module providers
var Routing = __WEBPACK_IMPORTED_MODULE_0__angular_router__["d" /* RouterModule */].forRoot(APP_ROUTES);
//# sourceMappingURL=app.routing.js.map

/***/ }),

/***/ "./src/app/components/admin/admin.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/admin/admin.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid jy-max-width-1000\" *ngIf=\"currentUser && currentUser.role === 'Admin'; else elseBlock\">\r\n\r\n  <h2>Administrator page</h2>\r\n\r\n  <ul class=\"nav nav-tabs\" id=\"myTab\" role=\"tablist\">\r\n    <li class=\"nav-item\">\r\n      <a class=\"nav-link active\" id=\"request-tab\" data-toggle=\"tab\" href=\"#requestTab\">Pending Requests</a>\r\n    </li>\r\n    <li class=\"nav-item\">\r\n      <a  class=\"nav-link\" id=\"user-tab\" data-toggle=\"tab\" href=\"#userTab\">Manage Users</a>\r\n    </li>\r\n    <li class=\"nav-item\">\r\n      <a  class=\"nav-link\" id=\"semester-tab\" data-toggle=\"tab\" href=\"#semesterTab\">Manage Semesters</a>\r\n    </li>\r\n  </ul>\r\n\r\n  <div class=\"tab-content\" id=\"myTabContent\">\r\n\r\n    <div class=\"tab-pane fade show active\" id=\"requestTab\">\r\n      <div class=\"table-responsive-sm\">\r\n        <table class=\"table\">\r\n          <thead>\r\n          <tr>\r\n            <th scope=\"col\">First</th>\r\n            <th scope=\"col\">Last</th>\r\n            <th scope=\"col\">Email</th>\r\n            <th scope=\"col\">Role</th>\r\n            <th scope=\"col\">Operation</th>\r\n          </tr>\r\n          </thead>\r\n          <tbody>\r\n          <tr *ngFor=\"let user of pendingUsers\">\r\n            <td>{{user.firstName}}</td>\r\n            <td>{{user.lastName}}</td>\r\n            <td>{{user.emailAddress}}</td>\r\n            <td>{{user.role}}</td>\r\n            <td>\r\n              <button (click)=\"approveUser(user)\" class=\"btn btn-success\">Approve</button>\r\n              <button (click)=\"rejectUser(user)\" class=\"btn btn-danger\">Reject</button>\r\n            </td>\r\n          </tr>\r\n          </tbody>\r\n        </table>\r\n      </div>\r\n    </div>\r\n\r\n    <div class=\"tab-pane fade jy-max-width-700 mx-auto\" id=\"userTab\">\r\n      <button type=\"button\" class=\"btn btn-primary btn-block my-2\" data-toggle=\"modal\" data-target=\"#newUserModel\">Create user</button>\r\n      <ul class=\"list-inline\">\r\n        <li class=\"list-inline-item mr-1\"><h5>User list: </h5></li>\r\n        <li *ngFor=\"let user of users\" class=\"list-inline-item mr-1\">\r\n          <a class=\"text-primary h5\" (click)=\"selectUser(user)\">{{user.firstName}} | </a>\r\n        </li>\r\n      </ul>\r\n      <form class=\"jy-form\" *ngIf=\"selectedUser\">\r\n        <div class=\"form-group\">\r\n          <label for=\"emailAddress\">Email:</label>\r\n          <input type=\"text\" class=\"form-control\" name=\"emailAddress\" id=\"emailAddress\" [(ngModel)] = \"selectedUser.emailAddress\" disabled>\r\n        </div>\r\n        <!--<div class=\"form-group\">-->\r\n          <!--<label for=\"password\">Password:</label>-->\r\n          <!--<input type=\"text\" class=\"form-control\" name=\"password\" id=\"password\" [(ngModel)] = \"selectedUser.password\">-->\r\n        <!--</div>-->\r\n        <div class=\"form-group\">\r\n          <label for=\"firstName\">First Name:</label>\r\n          <input type=\"text\" class=\"form-control\" name=\"firstName\" id=\"firstName\" [(ngModel)] = \"selectedUser.firstName\">\r\n        </div>\r\n        <div class=\"form-group\">\r\n          <label for=\"lastName\">Last Name:</label>\r\n          <input type=\"text\" class=\"form-control\" name=\"lastName\" id=\"lastName\" [(ngModel)] = \"selectedUser.lastName\">\r\n        </div>\r\n        <div class=\"form-group mb-2\">\r\n          <label for=\"role\">Role: </label>\r\n          <select class=\"form-control\" id=\"role\" name=\"role\" [(ngModel)] = \"selectedUser.role\" required>\r\n            <option *ngFor=\"let r of roles\" [value]=\"r\">{{r}}</option>\r\n          </select>\r\n        </div>\r\n        <div class=\"form-group mb-2\">\r\n          <label for=\"status\">User Status: </label>\r\n          <select class=\"form-control\" id=\"status\" name=\"status\" [(ngModel)] = \"selectedUser.status\" required>\r\n            <option *ngFor=\"let r of status\" [value]=\"r\">{{r}}</option>\r\n          </select>\r\n        </div>\r\n        <div *ngIf=\"updateMessageFlag\" class=\"alert alert-success\" role=\"alert\">\r\n          {{updateMessage}}\r\n        </div>\r\n        <button (click)=\"updateUser()\" class=\"btn btn-primary btn-block\">Update User</button>\r\n        <button (click)=\"deleteUser()\" class=\"btn btn-danger btn-block\">Delete User</button>\r\n      </form>\r\n    </div>\r\n\r\n    <div class=\"tab-pane fade jy-max-width-700 mx-auto\" id=\"semesterTab\">\r\n      <button type=\"button\" class=\"btn btn-primary btn-block my-2\" data-toggle=\"modal\" data-target=\"#newSemesterModel\">New semester</button>\r\n      <ul class=\"list-inline\">\r\n        <li class=\"list-inline-item mr-1\"><h5>Semester list: </h5></li>\r\n        <li *ngFor=\"let s of semesters\" class=\"list-inline-item mr-1\">\r\n          <a class=\"text-primary h5\" (click)=\"selectSemester(s)\">{{s.name}} | </a>\r\n        </li>\r\n      </ul>\r\n      <form class=\"jy-form\" *ngIf=\"selectedSemester\">\r\n        <div class=\"form-group\">\r\n          <label for=\"sName\">Name:</label>\r\n          <input type=\"text\" class=\"form-control\" name=\"sName\" id=\"sName\" [(ngModel)] = \"selectedSemester.name\">\r\n        </div>\r\n        <div class=\"form-group mb-2\">\r\n          <label for=\"sStatus\">Status: </label>\r\n          <select class=\"form-control\" id=\"sStatus\" name=\"status\" [(ngModel)] = \"selectedSemester.status\" required>\r\n            <option *ngFor=\"let r of semesterStatus\" [value]=\"r\">{{r}}</option>\r\n          </select>\r\n        </div>\r\n        <div *ngIf=\"updateMessageFlag\" class=\"alert alert-success\" role=\"alert\">\r\n          {{updateMessage}}\r\n        </div>\r\n        <button (click)=\"updateSemester()\" class=\"btn btn-primary btn-block\">Update Semester</button>\r\n        <button (click)=\"deleteSemester()\" class=\"btn btn-danger btn-block\">Delete Semester</button>\r\n      </form>\r\n    </div>\r\n\r\n\r\n  </div>\r\n</div>\r\n\r\n<ng-template #elseBlock>\r\n  <h2>Unauthorized</h2>\r\n</ng-template>\r\n\r\n<div class=\"modal fade\" id=\"newUserModel\" tabindex=\"-1\" role=\"dialog\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Create new user</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <form #registerF=\"ngForm\">\r\n          <input name=\"firstName\" placeholder=\"First Name\" type=\"text\" class=\"form-control\"\r\n                 required [(ngModel)] = \"nfirstName\"/>\r\n          <input name=\"lastName\" placeholder=\"Last Name\" type=\"text\" class=\"form-control\"\r\n                 required [(ngModel)] = \"nlastName\"/>\r\n          <input name=\"email\" placeholder=\"email\" type=\"text\" class=\"form-control\"\r\n                 required [(ngModel)] = \"nemailAddress\"/>\r\n          <input name=\"password1\" placeholder=\"password\" type=\"password\" class=\"form-control\"\r\n                 required [(ngModel)] = \"npassword\"/>\r\n          <div class=\"form-group\">\r\n            <label for=\"nrole\">Role</label>\r\n            <select class=\"form-control\" id=\"nrole\" name=\"role\" [(ngModel)] = \"nuserRole\" required>\r\n              <option *ngFor=\"let r of roles\" [value]=\"r\">{{r}}</option>\r\n            </select>\r\n          </div>\r\n        </form>\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\"  class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n        <button type=\"button\" class=\"btn btn-primary btn-block\" (click)=\"createUser()\" [disabled]=\"!registerF.valid\">Create</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"modal fade\" id=\"newSemesterModel\" tabindex=\"-1\" role=\"dialog\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">Create new semester</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <form #semesterF=\"ngForm\">\r\n          <input name=\"sName\" placeholder=\"Semester Name\" type=\"text\" class=\"form-control\"\r\n                 required [(ngModel)] = \"nSemesterName\"/>\r\n        </form>\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\"  class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n        <button type=\"button\" class=\"btn btn-primary btn-block\" (click)=\"createSemester()\" [disabled]=\"!semesterF.valid\">Create</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/admin/admin.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AdminComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__ = __webpack_require__("./src/app/services/course.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var AdminComponent = (function () {
    function AdminComponent(userService, router, sharedService, courseService) {
        this.userService = userService;
        this.router = router;
        this.sharedService = sharedService;
        this.courseService = courseService;
        this.roles = ['Professor', 'Student', 'Admin'];
        this.status = ['APPROVAL', 'ACTIVE', 'REJECTED'];
        this.updateMessageFlag = false;
        this.updateMessage = 'Successfully Updated';
        this.semesterStatus = ['ACTIVE', 'INACTIVE'];
    }
    AdminComponent.prototype.ngOnInit = function () {
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
    };
    AdminComponent.prototype.selectUser = function (user) {
        this.selectedUser = user;
        this.updateMessageFlag = false;
    };
    AdminComponent.prototype.createUser = function () {
        var _this = this;
        var newUser = {
            firstName: this.nfirstName,
            lastName: this.nlastName,
            emailAddress: this.nemailAddress,
            password: this.npassword,
            role: this.nuserRole,
        };
        this.userService.createUser(newUser).subscribe(function (r) {
            $('#newUserModel').modal('hide');
            _this.clearCreateModel();
            _this.getAllUsers();
        });
    };
    AdminComponent.prototype.updateUser = function () {
        var _this = this;
        this.userService.updateUser(this.selectedUser).subscribe(function (r) {
            _this.updateMessageFlag = true;
            _this.getAllUsers();
        });
    };
    AdminComponent.prototype.deleteUser = function () {
        var _this = this;
        this.userService.deleteUser(this.selectedUser.id).subscribe(function (r) {
            _this.selectedUser = null;
            _this.getAllUsers();
        });
    };
    AdminComponent.prototype.getAllUsers = function () {
        var _this = this;
        this.userService.findAllUsers().subscribe(function (result) {
            _this.users = result.data;
            _this.pendingUsers = _this.users.filter(function (u) {
                return u.status === 'APPROVAL';
            });
            // console.log('pending users: ', this.pendingUsers);
        });
    };
    AdminComponent.prototype.approveUser = function (user) {
        var _this = this;
        this.userService.approveUser(user).subscribe(function (result) {
            _this.getAllUsers();
        });
    };
    AdminComponent.prototype.rejectUser = function (user) {
        var _this = this;
        this.userService.rejectUser(user).subscribe(function (result) {
            _this.getAllUsers();
        });
    };
    AdminComponent.prototype.clearCreateModel = function () {
        this.nfirstName = null;
        this.nlastName = null;
        this.nemailAddress = null;
        this.npassword = null;
        this.nuserRole = null;
        this.nSemesterName = null;
    };
    AdminComponent.prototype.selectSemester = function (s) {
        this.selectedSemester = s;
        this.updateMessageFlag = false;
    };
    AdminComponent.prototype.createSemester = function () {
        var _this = this;
        var newSemester = {
            name: this.nSemesterName,
            status: 'ACTIVE',
        };
        this.courseService.createSemester(newSemester, this.currentUser.id).subscribe(function (r) {
            $('#newSemesterModel').modal('hide');
            _this.clearCreateModel();
            _this.getAllSemesters();
        });
    };
    AdminComponent.prototype.updateSemester = function () {
        var _this = this;
        this.courseService.updateSemester(this.selectedSemester, this.currentUser.id).subscribe(function (r) {
            _this.updateMessageFlag = true;
            _this.getAllSemesters();
        });
    };
    AdminComponent.prototype.deleteSemester = function () {
        var _this = this;
        this.courseService.deleteSemester(this.selectedSemester._id, this.currentUser.id).subscribe(function (r) {
            _this.selectedSemester = null;
            _this.getAllSemesters();
        });
    };
    AdminComponent.prototype.getAllSemesters = function () {
        var _this = this;
        this.courseService.findAllSemesters(this.currentUser.id).subscribe(function (result) {
            // console.log('semester', result);
            _this.semesters = result.data;
        });
    };
    return AdminComponent;
}());
AdminComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-admin',
        template: __webpack_require__("./src/app/components/admin/admin.component.html"),
        styles: [__webpack_require__("./src/app/components/admin/admin.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__["a" /* CourseService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__["a" /* CourseService */]) === "function" && _d || Object])
], AdminComponent);

var _a, _b, _c, _d;
//# sourceMappingURL=admin.component.js.map

/***/ }),

/***/ "./src/app/components/compare/compare-result/compare-result.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/compare/compare-result/compare-result.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n  <div class=\"row my-2\">\r\n    <div class=\"col mx-auto text-center\" *ngIf=\"compareResult\">\r\n\r\n      <h3 class=\"text-danger\" *ngIf=\"compareResult.plagiarismExists; else zEBlock\">\r\n        Plagiarism detected!\r\n      </h3>\r\n      <ng-template #zEBlock>\r\n        <h3 class=\"text-success\">No plagiarism</h3>\r\n      </ng-template>\r\n      <h5>Threshold used: {{compareResult.thresholdUsed}}</h5>\r\n\r\n      <div [ngSwitch]=\"strategy\">\r\n        <div *ngSwitchCase=\"'Zhang-Shasha ALgorithm'\">\r\n          <h5>Zhang-Shasha ALgorithm score: {{compareResult.metrics[0].score + '%'}}</h5>\r\n        </div>\r\n        <div *ngSwitchCase=\"'Longest Common Subsequence Algorithm'\">\r\n          <h5>Longest Common Subsequence Algorithm score: {{compareResult.metrics[1].score + '%'}}</h5>\r\n        </div>\r\n        <div *ngSwitchDefault>\r\n          <h5>Weighted average score: {{compareResult.averageScore + '%'}}</h5>\r\n          <div class=\"table-responsive-sm jy-max-width-700 mx-auto\">\r\n            <table class=\"table\">\r\n              <thead>\r\n              <tr>\r\n                <th scope=\"col\">Metric type</th>\r\n                <th scope=\"col\">Score</th>\r\n              </tr>\r\n              </thead>\r\n              <tbody>\r\n              <tr *ngFor=\"let metric of compareResult.metrics\">\r\n                <td>{{metric.metricType}}</td>\r\n                <td>{{metric.score}}</td>\r\n              </tr>\r\n              </tbody>\r\n            </table>\r\n          </div>\r\n        </div>\r\n      </div>\r\n\r\n    </div>\r\n  </div>\r\n\r\n\r\n  <div class=\"row mb-2\">\r\n    <div class=\"col-12 col-md-6\">\r\n      <h5>File one: {{compareResult?.file1Name}}</h5>\r\n      <div ace-editor id=\"editor1\" class=\"jy-ace-editor\" [(text)]=\"text1\" [mode]=\"'python'\" [theme]=\"'eclipse'\"\r\n           #editor1 [options]=\"options\" [readOnly]=\"false\" [autoUpdateContent]=\"true\"></div>\r\n    </div>\r\n\r\n    <div class=\"col-12 col-md-6\">\r\n      <h5>File two: {{compareResult?.file2Name}}</h5>\r\n      <div ace-editor id=\"editor2\" class=\"jy-ace-editor\" [(text)]=\"text2\" [mode]=\"'python'\" [theme]=\"'eclipse'\"\r\n           #editor2 [options]=\"options\" [readOnly]=\"false\" [autoUpdateContent]=\"true\"></div>\r\n    </div>\r\n    <!--<button class=\"btn btn-primary\" (click)=\"markLines()\"></button>-->\r\n  </div>\r\n\r\n  <div class=\"row mb-4\">\r\n    <div class=\"col\">\r\n      <p>* You can click on one colored code block, then the other panel will scroll to the matched block.\r\n      This can help you navigate through the detected similar code</p>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/compare/compare-result/compare-result.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CompareResultComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var CompareResultComponent = (function () {
    function CompareResultComponent(sharedService, userService, changeDetectorRef) {
        this.sharedService = sharedService;
        this.userService = userService;
        this.changeDetectorRef = changeDetectorRef;
        this.options = { printMargin: false };
        this.ranges = [];
        this.Range = ace.require('ace/range').Range;
        this.colorCss = ['jy-marker-1', 'jy-marker-2', 'jy-marker-3', 'jy-marker-4', 'jy-marker-5', 'jy-marker-6', 'jy-marker-7', 'jy-marker-8'];
        this.testRanges = [{ from1: 2, to1: 5, from2: 4, to2: 7 }, { from1: 15, to1: 20, from2: 8, to2: 13 }, { from1: 9, to1: 9, from2: 18, to2: 18 }];
    }
    CompareResultComponent.prototype.ngOnInit = function () {
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
    };
    CompareResultComponent.prototype.rangeCalibrate = function () {
        var _this = this;
        this.testRanges.forEach(function (range) {
            _this.ranges.push({
                from1: range.from1 - 1, to1: range.to1 - 1, from2: range.from2 - 1, to2: range.to2 - 1
            });
        });
    };
    CompareResultComponent.prototype.markLines = function () {
        for (var i = 0; i < this.ranges.length; i++) {
            var color = this.colorCss[i % this.colorCss.length];
            this.editor1.session.addMarker(new this.Range(this.ranges[i].from1, 0, this.ranges[i].to1, 1), color, 'fullLine');
            this.editor2.session.addMarker(new this.Range(this.ranges[i].from2, 0, this.ranges[i].to2, 1), color, 'fullLine');
        }
        // this.editor1.session.addMarker(new this.Range(1, 0, 1, 1), 'jy-marker-green', 'fullLine');
    };
    CompareResultComponent.prototype.addListener = function () {
        var self = this;
        this.editor1.on('click', function (e) {
            // console.log('row: ', e.getDocumentPosition().row);
            self.editorOneClick(e.getDocumentPosition().row);
        });
        this.editor2.on('click', function (e) {
            // console.log('row: ', e.getDocumentPosition().row);
            self.editorTwoClick(e.getDocumentPosition().row);
        });
    };
    CompareResultComponent.prototype.editorOneClick = function (row) {
        for (var i = 0; i < this.ranges.length; i++) {
            var range = this.ranges[i];
            if (range.from1 <= row && row <= range.to1) {
                this.scrollToRange(range);
            }
        }
    };
    CompareResultComponent.prototype.editorTwoClick = function (row) {
        for (var i = 0; i < this.ranges.length; i++) {
            var range = this.ranges[i];
            if (range.from2 <= row && row <= range.to2) {
                this.scrollToRange(range);
            }
        }
    };
    CompareResultComponent.prototype.scrollToRange = function (range) {
        var row1 = Math.floor((range.from1 + range.to1) / 2) + 1;
        var row2 = Math.floor((range.from2 + range.to2) / 2) + 1;
        this.editor1.gotoLine(row1, 0, true);
        this.editor2.gotoLine(row2, 0, true);
    };
    return CompareResultComponent;
}());
CompareResultComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-compare-result',
        template: __webpack_require__("./src/app/components/compare/compare-result/compare-result.component.html"),
        styles: [__webpack_require__("./src/app/components/compare/compare-result/compare-result.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_shared_service_client__["a" /* SharedService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__services_user_service_client__["a" /* UserService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */]) === "function" && _c || Object])
], CompareResultComponent);

var _a, _b, _c;
//# sourceMappingURL=compare-result.component.js.map

/***/ }),

/***/ "./src/app/components/compare/compare.component.css":
/***/ (function(module, exports) {

module.exports = "a:hover {\r\n  text-decoration: none;\r\n}\r\n"

/***/ }),

/***/ "./src/app/components/compare/compare.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n  <div class=\"row\">\r\n    <div class=\"col-12 col-sm-6 col-lg-4 mb-4\">\r\n      <a routerLink=\"/upload/text\">\r\n        <div class=\"card\">\r\n          <div class=\"card-body\">\r\n            <h4 class=\"card-title text-primary\">Compare text</h4>\r\n            <p class=\"card-text text-dark\">Input two python program for comparison</p>\r\n          </div>\r\n      </div>\r\n      </a>\r\n    </div>\r\n\r\n    <div class=\"col-12 col-sm-6 col-lg-4 mb-4\">\r\n      <a routerLink=\"/upload/file\">\r\n        <div class=\"card\">\r\n          <div class=\"card-body\">\r\n            <h4 class=\"card-title text-primary\">Compare file</h4>\r\n            <p class=\"card-text text-dark\">Upload two python program files for comparison</p>\r\n          </div>\r\n        </div>\r\n      </a>\r\n    </div>\r\n\r\n    <div class=\"col-12 col-sm-6 col-lg-4 mb-4\">\r\n      <a routerLink=\"/upload/folder\">\r\n        <div class=\"card\">\r\n          <div class=\"card-body\">\r\n            <h4 class=\"card-title text-primary\">Compare folder</h4>\r\n            <p class=\"card-text text-dark\">Upload two python project for comparison</p>\r\n          </div>\r\n        </div>\r\n      </a>\r\n    </div>\r\n\r\n    <!--<div class=\"col-12 col-sm-6 col-lg-4 mb-4\">-->\r\n      <!--<a routerLink=\"/upload/directory\">-->\r\n        <!--<div class=\"card\">-->\r\n          <!--<div class=\"card-body\">-->\r\n            <!--<h4 class=\"card-title text-primary\">Compare directory</h4>-->\r\n            <!--<p class=\"card-text text-dark\">Upload a directory of multiple python projects for comparison</p>-->\r\n          <!--</div>-->\r\n        <!--</div>-->\r\n      <!--</a>-->\r\n    <!--</div>-->\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/compare/compare.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CompareComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var CompareComponent = (function () {
    function CompareComponent() {
    }
    CompareComponent.prototype.ngOnInit = function () {
    };
    return CompareComponent;
}());
CompareComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-compare',
        template: __webpack_require__("./src/app/components/compare/compare.component.html"),
        styles: [__webpack_require__("./src/app/components/compare/compare.component.css")]
    }),
    __metadata("design:paramtypes", [])
], CompareComponent);

//# sourceMappingURL=compare.component.js.map

/***/ }),

/***/ "./src/app/components/compare/upload/upload-file/upload-file.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/compare/upload/upload-file/upload-file.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n  <div class=\"row mb-4\">\r\n    <div class=\"col jy-max-width-1000 mx-auto text-center\">\r\n      <h2 class=\"mb-4\">Select two python files for comparison</h2>\r\n      <div class=\"row mb-2\">\r\n        <div class=\"col-12 col-md-6\">\r\n          <form #f1=\"ngForm\">\r\n            <div class=\"form-group row\">\r\n              <label for=\"file1\" class=\"col-4 col-form-label\">File one</label>\r\n              <div class=\"col-8\">\r\n                <input (change)=fileEvent($event) name=\"file1\" type=\"file\" class=\"form-control\"\r\n                       id=\"file1\" accept=\".py\" required>\r\n              </div>\r\n            </div>\r\n            <div class=\"form-group row\">\r\n              <label for=\"student1\" class=\"col-4 col-form-label\">Student one</label>\r\n              <div class=\"col-8\">\r\n                <select class=\"form-control\" id=\"student1\" name=\"student1\" [(ngModel)] = \"student1\" required>\r\n                  <option *ngFor=\"let s of students\" [ngValue]=\"s\">{{s.firstName + ' ' + s.lastName}}</option>\r\n                </select>\r\n              </div>\r\n            </div>\r\n          </form>\r\n        </div>\r\n        <div class=\"col-12 col-md-6\">\r\n          <form #f2=\"ngForm\">\r\n            <div class=\"form-group row\">\r\n              <label for=\"file2\" class=\"col-4 col-form-label\">File two</label>\r\n              <div class=\"col-8\">\r\n                <input (change)=fileEvent($event) name=\"file2\" type=\"file\" class=\"form-control\"\r\n                       id=\"file2\" accept=\".py\" required>\r\n              </div>\r\n            </div>\r\n            <div class=\"form-group row\">\r\n              <label for=\"student2\" class=\"col-4 col-form-label\">Student two</label>\r\n              <div class=\"col-8\">\r\n                <select class=\"form-control\" id=\"student2\" name=\"student2\" [(ngModel)] = \"student2\" required>\r\n                  <option *ngFor=\"let s of students\" [ngValue]=\"s\">{{s.firstName + ' ' + s.lastName}}</option>\r\n                </select>\r\n              </div>\r\n            </div>\r\n          </form>\r\n        </div>\r\n      </div>\r\n      <div class=\"row mb-2\">\r\n        <div class=\"col jy-max-width-700 mx-auto\">\r\n          <form #sF=\"ngForm\">\r\n            <div class=\"form-group\">\r\n              <label for=\"strategy\">Select compare strategy</label>\r\n              <select class=\"form-control\" id=\"strategy\" name=\"strategy\" [(ngModel)] = \"strategy\" required>\r\n                <option *ngFor=\"let s of strategies\" [ngValue]=\"s\">{{s}}</option>\r\n              </select>\r\n            </div>\r\n          </form>\r\n        </div>\r\n      </div>\r\n      <div *ngIf=\"errorFlag\" class=\"alert alert-danger\">\r\n        {{errorMsg}}\r\n      </div>\r\n      <div class=\"row jy-max-width-700 mx-auto\">\r\n        <button (click)=\"uploadFile()\" class=\"btn btn-primary btn-block\" [disabled]=\"!f1.valid || !f2.valid || !sF.valid\">Compare</button>\r\n      </div>\r\n\r\n    </div>\r\n  </div>\r\n\r\n  <div class=\"row mb-4\" *ngIf=\"resultDisplay\">\r\n    <div class=\"col jy-max-width-1200 mx-auto text-center\">\r\n      <!--<h3>Average score: {{compareResult.averageScore}}</h3>-->\r\n      <h3>Compare complete</h3>\r\n      <button class=\"btn btn-primary\" (click)=\"viewDetail()\">View Details</button>\r\n      <!--<div class=\"table-responsive-sm jy-max-width-700 mx-auto\">-->\r\n        <!--<table class=\"table\">-->\r\n          <!--<thead>-->\r\n          <!--<tr>-->\r\n            <!--<th scope=\"col\">Metric type</th>-->\r\n            <!--<th scope=\"col\">Score</th>-->\r\n          <!--</tr>-->\r\n          <!--</thead>-->\r\n          <!--<tbody>-->\r\n          <!--<tr *ngFor=\"let metric of compareResult.metrics\">-->\r\n            <!--<td>{{metric.metricType}}</td>-->\r\n            <!--<td>{{metric.score}}</td>-->\r\n          <!--</tr>-->\r\n          <!--</tbody>-->\r\n        <!--</table>-->\r\n      <!--</div>-->\r\n\r\n      <!--<div class=\"row\">-->\r\n        <!--<div class=\"col-12 col-md-6\">-->\r\n          <!--<h5>File one: {{compareResult.file1Name}}</h5>-->\r\n          <!--<div ace-editor class=\"jy-ace-editor\" [(text)]=\"text1\" [mode]=\"'python'\" [theme]=\"'eclipse'\"-->\r\n               <!--#editor1 [options]=\"options\" [readOnly]=\"true\" [autoUpdateContent]=\"true\"></div>-->\r\n        <!--</div>-->\r\n\r\n        <!--<div class=\"col-12 col-md-6\">-->\r\n          <!--<h5>File two: {{compareResult.file2Name}}</h5>-->\r\n          <!--<div ace-editor class=\"jy-ace-editor\" [(text)]=\"text2\" [mode]=\"'python'\" [theme]=\"'eclipse'\"-->\r\n               <!--#editor2 [options]=\"options\" [readOnly]=\"true\" [autoUpdateContent]=\"true\"></div>-->\r\n        <!--</div>-->\r\n      <!--</div>-->\r\n    </div>\r\n  </div>\r\n\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/compare/upload/upload-file/upload-file.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UploadFileComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_compare_service_client__ = __webpack_require__("./src/app/services/compare.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var UploadFileComponent = (function () {
    function UploadFileComponent(compareService, sharedService, userService, changeDetectorRef, router) {
        this.compareService = compareService;
        this.sharedService = sharedService;
        this.userService = userService;
        this.changeDetectorRef = changeDetectorRef;
        this.router = router;
        this.fileOne = null;
        this.fileTwo = null;
        this.resultDisplay = false;
        this.text1 = '';
        this.text2 = '';
        this.options = { printMargin: false };
        this.errorFlag = false;
        this.errorMsg = 'Must be two python files';
        this.strategies = ['Zhang-Shasha ALgorithm', 'Longest Common Subsequence Algorithm', 'Weighted Average'];
    }
    UploadFileComponent.prototype.ngOnInit = function () {
        this.user = this.sharedService.user;
        this.findStudents();
    };
    UploadFileComponent.prototype.findStudents = function () {
        var _this = this;
        this.userService.findStudentsForProfessor(this.user.id, this.user.id).subscribe(function (result) {
            _this.students = result.data;
        });
    };
    UploadFileComponent.prototype.fileEvent = function ($event) {
        // console.log($event);
        if ($event.target.id === 'file1') {
            this.fileOne = $event.target.files[0];
            // console.log('file one selected: ');
            // console.log(this.fileOne);
        }
        else {
            this.fileTwo = $event.target.files[0];
            // console.log('file two selected: ');
            // console.log(this.fileTwo);
        }
    };
    UploadFileComponent.prototype.uploadFile = function () {
        var _this = this;
        if (this.isValidInput()) {
            this.errorFlag = false;
            var formData = new FormData();
            formData.append('uploadingFiles', this.fileOne);
            formData.append('uploadingFiles', this.fileTwo);
            var userId = this.sharedService.user ? this.sharedService.user.id : 0;
            this.compareService.uploadFile(formData, userId, this.student1.id, this.student2.id).subscribe(function (result) {
                // console.log('compare result', result);
                _this.compareResult = result.data;
                _this.showResult();
            });
        }
        else {
            this.errorFlag = true;
        }
    };
    UploadFileComponent.prototype.showResult = function () {
        this.resultDisplay = true;
        // this.readFile(this.fileOne).then((data: string) => {
        //   this.text1 = data;
        //   // console.log('text1', this.text1);
        // });
        // this.readFile(this.fileTwo).then((data: string) => {
        //   this.text2 = data;
        //   // console.log('text1', this.text1);
        // });
    };
    UploadFileComponent.prototype.viewDetail = function () {
        this.sharedService.compareResult = this.compareResult;
        this.sharedService.strategy = this.strategy;
        this.router.navigate(['compare', 'result']);
    };
    UploadFileComponent.prototype.readFile = function (file) {
        return new Promise(function (resolve, reject) {
            var fileReader = new FileReader();
            fileReader.onload = function (event) {
                // console.log(event);
                resolve(fileReader.result);
            };
            fileReader.readAsText(file);
        });
    };
    UploadFileComponent.prototype.isValidInput = function () {
        // console.log(this.fileOne);
        // console.log(this.fileTwo);
        if (this.fileOne && this.fileTwo && this.isPythonFileName(this.fileOne.name)
            && this.isPythonFileName(this.fileTwo.name)) {
            return true;
        }
        else {
            return false;
        }
    };
    UploadFileComponent.prototype.isPythonFileName = function (fileName) {
        var res = fileName.split('.');
        // console.log(res, res[res.length - 1] === 'py');
        return res[res.length - 1] === 'py';
    };
    return UploadFileComponent;
}());
UploadFileComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-upload-file',
        template: __webpack_require__("./src/app/components/compare/upload/upload-file/upload-file.component.html"),
        styles: [__webpack_require__("./src/app/components/compare/upload/upload-file/upload-file.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_compare_service_client__["a" /* CompareService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_compare_service_client__["a" /* CompareService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__["a" /* SharedService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__["a" /* UserService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */]) === "function" && _e || Object])
], UploadFileComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=upload-file.component.js.map

/***/ }),

/***/ "./src/app/components/compare/upload/upload-folder/upload-folder.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/compare/upload/upload-folder/upload-folder.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n  <div class=\"row mb-2\">\r\n    <div class=\"col jy-max-width-1000 mx-auto text-center\">\r\n      <h2 class=\"mb-4\">Select two python folders for comparison</h2>\r\n      <div class=\"row mb-4\">\r\n        <div class=\"col-12 col-md-6\">\r\n          <form #f1=\"ngForm\">\r\n            <div class=\"form-group row\">\r\n              <label for=\"student1\" class=\"col-3 col-form-label\">Student one</label>\r\n              <div class=\"col-4\">\r\n                <select class=\"form-control\" id=\"student1\" name=\"student1\" [(ngModel)] = \"student1\" required>\r\n                  <option *ngFor=\"let s of students\" [ngValue]=\"s\">{{s.firstName + ' ' + s.lastName}}</option>\r\n                </select>\r\n              </div>\r\n              <label class=\"btn btn-secondary col-5 col-form-label\" for=\"file1\">Folder one</label>\r\n              <input (change)=fileEvent($event) name=\"file1\" type=\"file\" class=\"form-control\"\r\n                      id=\"file1\" accept=\".py\" webkitdirectory directory multiple hidden>\r\n            </div>\r\n          </form>\r\n          <ul class=\"list-group\" *ngIf=\"fileListOne.length > 0\">\r\n            <li class=\"list-group-item h6\">{{fileListOne.length}} files selected</li>\r\n            <li class=\"list-group-item\" *ngFor=\"let file of fileListOne\">{{file.webkitRelativePath}}</li>\r\n          </ul>\r\n        </div>\r\n        <div class=\"col-12 col-md-6\">\r\n          <form #f2=\"ngForm\">\r\n            <div class=\"form-group row\">\r\n              <label for=\"student2\" class=\"col-3 col-form-label\">Student two</label>\r\n              <div class=\"col-4\">\r\n                <select class=\"form-control\" id=\"student2\" name=\"student2\" [(ngModel)] = \"student2\" required>\r\n                  <option *ngFor=\"let s of students\" [ngValue]=\"s\">{{s.firstName + ' ' + s.lastName}}</option>\r\n                </select>\r\n              </div>\r\n              <label class=\"btn btn-secondary col-5 col-form-label\" for=\"file2\">Folder two</label>\r\n              <input (change)=fileEvent($event) name=\"file2\" type=\"file\" class=\"form-control\"\r\n                     id=\"file2\" accept=\".py\" webkitdirectory directory multiple hidden>\r\n            </div>\r\n          </form>\r\n          <ul class=\"list-group\" *ngIf=\"fileListTwo.length > 0\">\r\n            <li class=\"list-group-item h6\">{{fileListTwo.length}} files selected</li>\r\n            <li class=\"list-group-item\" *ngFor=\"let file of fileListTwo\">{{file.webkitRelativePath}}</li>\r\n          </ul>\r\n        </div>\r\n      </div>\r\n      <div *ngIf=\"errorFlag\" class=\"alert alert-danger\">\r\n        {{errorMsg}}\r\n      </div>\r\n      <div class=\"row jy-max-width-700 mx-auto\">\r\n        <button (click)=\"uploadFolder()\" class=\"btn btn-primary btn-block\"\r\n                [disabled]=\"!f1.valid || !f2.valid ||compareBtnDisabled\">Compare</button>\r\n        <p class=\"text-info\" *ngIf=\"compareBtnDisabled\">Compare in process, please wait....</p>\r\n      </div>\r\n    </div>\r\n  </div>\r\n\r\n  <div class=\"row mb-4\" *ngIf=\"compareResult\">\r\n    <div class=\"col jy-max-width-1000 mx-auto text-center\">\r\n      <h3>Compare complete</h3>\r\n      <button class=\"btn btn-primary\" (click)=\"viewDetail()\">View Result</button>\r\n      <!--<div class=\"table-responsive-sm jy-max-width-700 mx-auto\">-->\r\n        <!--<table class=\"table table-hover\">-->\r\n          <!--<thead>-->\r\n          <!--<tr>-->\r\n            <!--<th scope=\"col\">File 1</th>-->\r\n            <!--<th scope=\"col\">File 2</th>-->\r\n            <!--<th scope=\"col\">Average Score</th>-->\r\n          <!--</tr>-->\r\n          <!--</thead>-->\r\n          <!--<tbody>-->\r\n          <!--<tr *ngFor=\"let result of compareResult; let i = index\" (click)=\"selectRow(i)\" [class.table-active]=\"i === selectedIndex\">-->\r\n            <!--<td>{{result.file1Name}}</td>-->\r\n            <!--<td>{{result.file2Name}}</td>-->\r\n            <!--<td>{{result.averageScore}}</td>-->\r\n          <!--</tr>-->\r\n          <!--</tbody>-->\r\n        <!--</table>-->\r\n      <!--</div>-->\r\n    </div>\r\n  </div>\r\n\r\n  <!--<div class=\"row mb-4\" *ngIf=\"selectedResult\">-->\r\n    <!--<div class=\"col mx-auto text-center\">-->\r\n      <!--<h3>Average score: {{selectedResult.averageScore}}</h3>-->\r\n      <!--<div class=\"table-responsive-sm jy-max-width-700 mx-auto\">-->\r\n        <!--<table class=\"table\">-->\r\n          <!--<thead>-->\r\n          <!--<tr>-->\r\n            <!--<th scope=\"col\">Metric type</th>-->\r\n            <!--<th scope=\"col\">Score</th>-->\r\n          <!--</tr>-->\r\n          <!--</thead>-->\r\n          <!--<tbody>-->\r\n          <!--<tr *ngFor=\"let metric of selectedResult.metrics\">-->\r\n            <!--<td>{{metric.metricType}}</td>-->\r\n            <!--<td>{{metric.score}}</td>-->\r\n          <!--</tr>-->\r\n          <!--</tbody>-->\r\n        <!--</table>-->\r\n      <!--</div>-->\r\n    <!--</div>-->\r\n  <!--</div>-->\r\n\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/compare/upload/upload-folder/upload-folder.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UploadFolderComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_compare_service_client__ = __webpack_require__("./src/app/services/compare.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var UploadFolderComponent = (function () {
    function UploadFolderComponent(compareService, sharedService, userService, router) {
        this.compareService = compareService;
        this.sharedService = sharedService;
        this.userService = userService;
        this.router = router;
        this.fileListOne = [];
        this.fileListTwo = [];
        this.resultDisplay = false;
        this.errorFlag = false;
        this.errorMsg = 'Both folders can not be empty';
        this.compareResult = null;
        this.selectedResult = null;
        this.compareBtnDisabled = false;
    }
    UploadFolderComponent.prototype.ngOnInit = function () {
        this.user = this.sharedService.user;
        this.findStudents();
    };
    UploadFolderComponent.prototype.findStudents = function () {
        var _this = this;
        this.userService.findStudentsForProfessor(this.user.id, this.user.id).subscribe(function (result) {
            _this.students = result.data;
        });
    };
    UploadFolderComponent.prototype.fileEvent = function ($event) {
        console.log($event.target);
        console.log($event.target.files);
        if ($event.target.id === 'file1') {
            this.fileListOne = this.filterFiles($event.target.files);
            console.log('file list one selected: ');
            console.log(this.fileListOne);
        }
        else {
            this.fileListTwo = this.filterFiles($event.target.files);
            console.log('file list two selected: ');
            console.log(this.fileListTwo);
        }
    };
    UploadFolderComponent.prototype.uploadFolder = function () {
        var _this = this;
        if (this.isValidInput()) {
            this.compareBtnDisabled = true;
            this.errorFlag = false;
            var formData = new FormData();
            for (var i = 0; i < this.fileListOne.length; i++) {
                formData.append('fileList1', this.fileListOne[i]);
            }
            for (var i = 0; i < this.fileListTwo.length; i++) {
                formData.append('fileList2', this.fileListTwo[i]);
            }
            var userId = this.sharedService.user ? this.sharedService.user.id : 0;
            this.compareService.uploadFolder(formData, userId, this.student1.id, this.student2.id).subscribe(function (result) {
                _this.compareResult = result.data;
                console.log('compare result', _this.compareResult);
                _this.compareBtnDisabled = false;
            });
        }
        else {
            this.errorFlag = true;
        }
    };
    UploadFolderComponent.prototype.viewDetail = function () {
        // this.sharedService.compareResult = this.compareResult;
        this.router.navigate(['operation', this.compareResult]);
    };
    UploadFolderComponent.prototype.filterFiles = function (fileList) {
        var resultList = [];
        for (var i = 0; i < fileList.length; i++) {
            if (this.isPythonFileName(fileList[i].name)) {
                resultList.push(fileList[i]);
            }
        }
        return resultList;
    };
    UploadFolderComponent.prototype.isPythonFileName = function (fileName) {
        var res = fileName.split('.');
        // console.log(res, res[res.length - 1] === 'py');
        return res[res.length - 1] === 'py';
    };
    UploadFolderComponent.prototype.isValidInput = function () {
        return this.fileListOne.length > 0 && this.fileListTwo.length > 0;
    };
    UploadFolderComponent.prototype.selectRow = function (index) {
        // console.log('select row', index);
        this.selectedIndex = index;
        this.selectedResult = this.compareResult[index];
        // console.log('select result:', this.selectedResult);
    };
    return UploadFolderComponent;
}());
UploadFolderComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-upload-folder',
        template: __webpack_require__("./src/app/components/compare/upload/upload-folder/upload-folder.component.html"),
        styles: [__webpack_require__("./src/app/components/compare/upload/upload-folder/upload-folder.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_compare_service_client__["a" /* CompareService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_compare_service_client__["a" /* CompareService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__["a" /* SharedService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__["a" /* UserService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */]) === "function" && _d || Object])
], UploadFolderComponent);

var _a, _b, _c, _d;
//# sourceMappingURL=upload-folder.component.js.map

/***/ }),

/***/ "./src/app/components/compare/upload/upload-text/upload-text.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/compare/upload/upload-text/upload-text.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n  <div class=\"row mb-2\">\r\n    <div class=\"col jy-max-width-1200 mx-auto text-center\">\r\n      <h2 class=\"mb-2\">Copy and paste two python files for comparison</h2>\r\n\r\n      <div class=\"row mb-2\">\r\n        <div class=\"col-12 col-md-6\">\r\n          <h5>File one</h5>\r\n          <div ace-editor class=\"jy-ace-editor\" [(text)]=\"text1\" [mode]=\"'python'\" [theme]=\"'eclipse'\"\r\n               id=\"editor1\" [options]=\"options\" [readOnly]=\"false\" [autoUpdateContent]=\"true\"></div>\r\n          <form #f1=\"ngForm\" class=\"my-2\">\r\n            <div class=\"form-group row\">\r\n              <label for=\"student1\" class=\"col-4 col-form-label\">Student one</label>\r\n              <div class=\"col-8\">\r\n                <select class=\"form-control\" id=\"student1\" name=\"student1\" [(ngModel)] = \"student1\" required>\r\n                  <option *ngFor=\"let s of students\" [ngValue]=\"s\">{{s.firstName + ' ' + s.lastName}}</option>\r\n                </select>\r\n              </div>\r\n            </div>\r\n          </form>\r\n        </div>\r\n\r\n        <div class=\"col-12 col-md-6\">\r\n          <h5>File two</h5>\r\n          <div ace-editor class=\"jy-ace-editor\" [(text)]=\"text2\" [mode]=\"'python'\" [theme]=\"'eclipse'\"\r\n               id=\"editor2\" [options]=\"options\" [readOnly]=\"false\" [autoUpdateContent]=\"true\"></div>\r\n          <form #f2=\"ngForm\" class=\"my-2\">\r\n            <div class=\"form-group row\">\r\n              <label for=\"student2\" class=\"col-4 col-form-label\">Student two</label>\r\n              <div class=\"col-8\">\r\n                <select class=\"form-control\" id=\"student2\" name=\"student2\" [(ngModel)] = \"student2\" required>\r\n                  <option *ngFor=\"let s of students\" [ngValue]=\"s\">{{s.firstName + ' ' + s.lastName}}</option>\r\n                </select>\r\n              </div>\r\n            </div>\r\n          </form>\r\n        </div>\r\n      </div>\r\n      <div class=\"row mb-2\">\r\n        <div class=\"col jy-max-width-700 mx-auto\">\r\n          <form #sF=\"ngForm\">\r\n            <div class=\"form-group\">\r\n              <label for=\"strategy\">Select compare strategy</label>\r\n              <select class=\"form-control\" id=\"strategy\" name=\"strategy\" [(ngModel)] = \"strategy\" required>\r\n                <option *ngFor=\"let s of strategies\" [ngValue]=\"s\">{{s}}</option>\r\n              </select>\r\n            </div>\r\n          </form>\r\n        </div>\r\n      </div>\r\n      <div *ngIf=\"errorFlag\" class=\"alert alert-danger\">\r\n        {{errorMsg}}\r\n      </div>\r\n\r\n      <div class=\"row mb-4\" *ngIf=\"resultDisplay\">\r\n        <div class=\"col jy-max-width-1200 mx-auto text-center\">\r\n          <h3>Compare complete</h3>\r\n          <!--<h3>Average score: {{compareResult.averageScore}}</h3>-->\r\n          <button class=\"btn btn-primary\" (click)=\"viewDetail()\">View Details</button>\r\n        </div>\r\n      </div>\r\n\r\n      <div class=\"row jy-max-width-700 mx-auto mb-4\">\r\n        <button (click)=\"compare()\" class=\"btn btn-primary btn-block\" [disabled]=\"!f1.valid || !f2.valid || !sF.valid\">Compare</button>\r\n      </div>\r\n\r\n    </div>\r\n  </div>\r\n\r\n\r\n\r\n</div>\r\n\r\n"

/***/ }),

/***/ "./src/app/components/compare/upload/upload-text/upload-text.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UploadTextComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_compare_service_client__ = __webpack_require__("./src/app/services/compare.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var UploadTextComponent = (function () {
    function UploadTextComponent(userService, compareService, sharedService, router) {
        this.userService = userService;
        this.compareService = compareService;
        this.sharedService = sharedService;
        this.router = router;
        this.text1 = '';
        this.text2 = '';
        this.options = { printMargin: false };
        this.Range = ace.require('ace/range').Range;
        this.resultDisplay = false;
        this.errorFlag = false;
        this.errorMsg = 'Input can not be empty';
        this.strategies = ['Zhang-Shasha ALgorithm', 'Longest Common Subsequence Algorithm', 'Weighted Average'];
    }
    UploadTextComponent.prototype.ngOnInit = function () {
        this.editor1 = ace.edit('editor1');
        this.editor2 = ace.edit('editor2');
        this.user = this.sharedService.user;
        this.findStudents();
        // this.editor1.on('click', function(e) {
        //   console.log(e);
        //   console.log('row: ', e.getDocumentPosition().row);
        // });
    };
    UploadTextComponent.prototype.findStudents = function () {
        var _this = this;
        this.userService.findStudentsForProfessor(this.user.id, this.user.id).subscribe(function (result) {
            _this.students = result.data;
        });
    };
    UploadTextComponent.prototype.compare = function () {
        var _this = this;
        // console.log(this.editor1.getValue());
        // this.editor1.session.addMarker(new this.Range(1, 0, 1, 1), 'jy-marker-green', 'fullLine');
        if (this.isInputValid()) {
            this.errorFlag = false;
            var data = { 'fileText1': this.text1, 'fileText2': this.text2 };
            var userId = this.sharedService.user ? this.sharedService.user.id : 0;
            this.compareService.uploadText(data, userId, this.student1.id, this.student2.id).subscribe(function (result) {
                console.log('compare result', result);
                _this.compareResult = result.data;
                _this.showResult();
            });
        }
        else {
            this.errorFlag = true;
        }
    };
    UploadTextComponent.prototype.viewDetail = function () {
        this.sharedService.compareResult = this.compareResult;
        this.sharedService.strategy = this.strategy;
        this.router.navigate(['compare', 'result']);
    };
    UploadTextComponent.prototype.showResult = function () {
        this.resultDisplay = true;
    };
    UploadTextComponent.prototype.isInputValid = function () {
        return this.text1.trim().length > 0 && this.text2.trim().length > 0;
    };
    return UploadTextComponent;
}());
UploadTextComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-upload-text',
        template: __webpack_require__("./src/app/components/compare/upload/upload-text/upload-text.component.html"),
        styles: [__webpack_require__("./src/app/components/compare/upload/upload-text/upload-text.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__["a" /* UserService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_1__services_compare_service_client__["a" /* CompareService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_compare_service_client__["a" /* CompareService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__["a" /* SharedService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */]) === "function" && _d || Object])
], UploadTextComponent);

var _a, _b, _c, _d;
//# sourceMappingURL=upload-text.component.js.map

/***/ }),

/***/ "./src/app/components/course/assignment/assignment.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/course/assignment/assignment.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n  <div class=\"row\" *ngIf=\"assignment\">\r\n    <div class=\"col jy-max-width-700 mx-auto text-center\">\r\n      <div class=\"text-left\"><a routerLink=\"/profile\"><< Back to Courses</a></div>\r\n      <h4>Assignment: {{assignment.name}}</h4>\r\n      <p>Deadline: {{assignment.deadline}}</p>\r\n      <a [href]=\"assignment.documentUrl\" target=\"_blank\">\r\n        Document link: {{assignment.documentUrl}}</a>\r\n      <p>Submission type: {{assignment.submissionType}}</p>\r\n    </div>\r\n  </div>\r\n  <div class=\"row\" *ngIf=\"submissions; else elseBlock\">\r\n    <div class=\"col jy-max-width-700 mx-auto text-center\">\r\n\r\n      <button class=\"btn btn-primary mb-2\" (click)=\"compare()\" [disabled]=\"isComparing\">Compare all</button>\r\n      <button class=\"btn btn-primary mb-2\" (click)=\"compareSelected()\" [disabled]=\"submissionIds.length < 2 || isComparing\">Compare Selected</button>\r\n      <p *ngIf=\"isComparing\" class=\"text-info\">Compare in process, please wait...</p>\r\n      <h5>Submission List</h5>\r\n      <div class=\"table-responsive-sm mx-auto text-left\">\r\n        <table class=\"table table-bordered\">\r\n          <thead>\r\n          <tr>\r\n            <th scope=\"col\">Select</th>\r\n            <th scope=\"col\">Student Name</th>\r\n            <th scope=\"col\">Date</th>\r\n            <th scope=\"col\">Files</th>\r\n          </tr>\r\n          </thead>\r\n          <tbody>\r\n          <tr *ngFor=\"let s of submissions\" >\r\n            <td>\r\n              <input type=\"checkbox\" (click)=\"selectSubmission(s)\">\r\n            </td>\r\n            <td>{{s.studentName}}</td>\r\n            <td>{{s.submissionDate}}</td>\r\n            <td>\r\n              <ul>\r\n                <li *ngFor=\"let file of s.url\">\r\n                  <a href=\"{{file.fileText2}}\" target=\"_blank\">{{file.fileText1}}</a>\r\n                </li>\r\n              </ul>\r\n            </td>\r\n          </tr>\r\n          </tbody>\r\n        </table>\r\n      </div>\r\n    </div>\r\n  </div>\r\n  <ng-template #elseBlock>\r\n  <div class=\"row\">\r\n    <div class=\"col jy-max-width-700 mx-auto text-center\">\r\n      <h4 class=\"text-info\">No submissions</h4>\r\n    </div>\r\n  </div>\r\n</ng-template>\r\n\r\n</div>\r\n\r\n"

/***/ }),

/***/ "./src/app/components/course/assignment/assignment.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AssignmentComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_assignment_service_client__ = __webpack_require__("./src/app/services/assignment.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__services_compare_service_client__ = __webpack_require__("./src/app/services/compare.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var AssignmentComponent = (function () {
    function AssignmentComponent(sharedService, acRoute, assignmentService, router, compareService) {
        this.sharedService = sharedService;
        this.acRoute = acRoute;
        this.assignmentService = assignmentService;
        this.router = router;
        this.compareService = compareService;
        this.isComparing = false;
        this.submissionIds = [];
    }
    AssignmentComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.user = this.sharedService.user;
        this.acRoute.params.subscribe(function (params) {
            _this.aId = params['aid'];
            _this.assignmentService.findAssignmentById(_this.aId, _this.user.id).subscribe(function (result) {
                _this.assignment = result.data;
            });
            _this.assignmentService.getSubmissionByAssnId(_this.aId, _this.user.id).subscribe(function (result) {
                _this.submissions = result.data;
                // console.log('list submission', this.submissions);
            });
        });
    };
    AssignmentComponent.prototype.compare = function () {
        var _this = this;
        this.isComparing = true;
        this.compareService.compareAssignment(this.user.id, this.aId).subscribe(function (result) {
            var oid = result.data;
            _this.router.navigate(['operation', oid]);
        });
    };
    AssignmentComponent.prototype.selectSubmission = function (s) {
        var index = this.submissionIds.indexOf(s._id);
        if (index === -1) {
            this.submissionIds.push(s._id);
        }
        else {
            this.submissionIds.splice(index, 1);
        }
        // console.log('submission checked', this.submissionIds);
    };
    AssignmentComponent.prototype.compareSelected = function () {
        var _this = this;
        var submissions = {
            inputList: this.submissionIds
        };
        this.isComparing = true;
        this.compareService.compareSelectedSubmissions(this.user.id, submissions).subscribe(function (result) {
            var oid = result.data;
            _this.router.navigate(['operation', oid]);
        });
    };
    return AssignmentComponent;
}());
AssignmentComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-assignment',
        template: __webpack_require__("./src/app/components/course/assignment/assignment.component.html"),
        styles: [__webpack_require__("./src/app/components/course/assignment/assignment.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_shared_service_client__["a" /* SharedService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* ActivatedRoute */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* ActivatedRoute */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_assignment_service_client__["a" /* AssignmentService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_assignment_service_client__["a" /* AssignmentService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_4__services_compare_service_client__["a" /* CompareService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__services_compare_service_client__["a" /* CompareService */]) === "function" && _e || Object])
], AssignmentComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=assignment.component.js.map

/***/ }),

/***/ "./src/app/components/course/course.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/course/course.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n  <div class=\"row\">\r\n    <div class=\"col jy-max-width-700 mx-auto\">\r\n      <h3>Course Enrollment</h3>\r\n      <form>\r\n        <div class=\"form-group row\">\r\n          <label for=\"sem\" class=\"col-3 col-form-label\">Select semester: </label>\r\n          <div class=\"col-4\">\r\n            <select class=\"form-control\" id=\"sem\" name=\"sem\" [(ngModel)] = \"selectedSemester\"\r\n                    (ngModelChange)=\"onChange($event)\">\r\n              <option *ngFor=\"let sem of semesters\" [ngValue]=\"sem\">{{sem.name}}</option>\r\n            </select>\r\n          </div>\r\n        </div>\r\n      </form>\r\n      <div *ngIf=\"courses\">\r\n        <h5>Course List</h5>\r\n        <div class=\"table-responsive-sm\">\r\n          <table class=\"table\">\r\n            <thead>\r\n            <tr>\r\n              <th scope=\"col\">Course Name</th>\r\n              <th scope=\"col\">Student Number</th>\r\n              <th scope=\"col\">Operation</th>\r\n            </tr>\r\n            </thead>\r\n            <tbody>\r\n            <tr *ngFor=\"let c of courses\">\r\n              <td>{{c.courseName}}</td>\r\n              <td>{{c.studentsEnrolled?.length}}</td>\r\n              <td>\r\n                  <button (click)=\"dropCourse(c)\" class=\"btn btn-danger\" *ngIf=\"enrolledCourses.indexOf(c._id) > -1\">Drop</button>\r\n                  <button (click)=\"enrollCourse(c)\" class=\"btn btn-primary\" *ngIf=\"enrolledCourses.indexOf(c._id) === -1\">Enroll</button>\r\n              </td>\r\n            </tr>\r\n            </tbody>\r\n          </table>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/course/course.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CourseComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_course_service_client__ = __webpack_require__("./src/app/services/course.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var CourseComponent = (function () {
    function CourseComponent(sharedService, userService, courseService, changeDetectorRef) {
        this.sharedService = sharedService;
        this.userService = userService;
        this.courseService = courseService;
        this.changeDetectorRef = changeDetectorRef;
    }
    CourseComponent.prototype.ngOnInit = function () {
        this.user = this.sharedService.user;
        // console.log('course enroll, user', this.user);
        this.enrolledCourses = this.user.courseEnrolled ? this.user.courseEnrolled : [];
        // console.log('enrolled course id', this.enrolledCourses);
        this.getAllSemesters();
    };
    CourseComponent.prototype.onChange = function (sem) {
        this.getAllCoursesForSemester();
    };
    CourseComponent.prototype.getAllSemesters = function () {
        var _this = this;
        this.courseService.findAllActiveSemesters(this.user.id).subscribe(function (result) {
            _this.semesters = result.data;
        });
    };
    CourseComponent.prototype.getAllCoursesForSemester = function () {
        var _this = this;
        this.courseService.findCourseBySemesterId(this.user.id, this.selectedSemester._id).subscribe(function (result) {
            _this.courses = result.data;
            // console.log('course', this.courses);
        });
    };
    CourseComponent.prototype.updateUser = function () {
        var _this = this;
        this.userService.findUserById(this.user.id).subscribe(function (result) {
            _this.user = result.data;
            _this.sharedService.setUser(_this.user);
            // console.log('update user', this.user);
            _this.enrolledCourses = _this.user.courseEnrolled;
            // console.log('enrolled course id', this.enrolledCourses);
        });
    };
    CourseComponent.prototype.enrollCourse = function (c) {
        var _this = this;
        this.courseService.enrollCourse(c, this.user.id).subscribe(function (result) {
            _this.getAllCoursesForSemester();
            _this.updateUser();
        });
    };
    CourseComponent.prototype.dropCourse = function (c) {
        var _this = this;
        this.courseService.dropCourse(c, this.user.id).subscribe(function (result) {
            _this.getAllCoursesForSemester();
            _this.updateUser();
        });
    };
    return CourseComponent;
}());
CourseComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-course',
        template: __webpack_require__("./src/app/components/course/course.component.html"),
        styles: [__webpack_require__("./src/app/components/course/course.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_shared_service_client__["a" /* SharedService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__["a" /* UserService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__services_course_service_client__["a" /* CourseService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__services_course_service_client__["a" /* CourseService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */]) === "function" && _d || Object])
], CourseComponent);

var _a, _b, _c, _d;
//# sourceMappingURL=course.component.js.map

/***/ }),

/***/ "./src/app/components/history/history.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/history/history.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n  <div class=\"row\">\r\n    <div class=\"col jy-max-width-700 mx-auto\">\r\n      <h3>Comparison History</h3>\r\n      <div *ngIf=\"operations; else elseBlock\">\r\n        <div class=\"table-responsive-sm\">\r\n          <table class=\"table table-bordered\">\r\n            <thead>\r\n            <tr>\r\n              <th scope=\"col\">Compare Type</th>\r\n              <th scope=\"col\">Date</th>\r\n              <th scope=\"col\">Initiated By</th>\r\n              <th scope=\"col\">View Details</th>\r\n            </tr>\r\n            </thead>\r\n            <tbody>\r\n            <tr *ngFor=\"let o of operations\">\r\n              <td>{{o.operationType}}</td>\r\n              <td>{{o.date}}</td>\r\n              <td>{{o.initiatedBy}}</td>\r\n              <td>\r\n                <a (click)=\"viewDetail(o)\"><i class=\"fa fa-external-link\"></i></a>\r\n              </td>\r\n            </tr>\r\n            </tbody>\r\n          </table>\r\n        </div>\r\n      </div>\r\n      <ng-template #elseBlock>\r\n        <h4 class=\"text-info\">No comparisons</h4>\r\n      </ng-template>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/history/history.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HistoryComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__services_history_service_client__ = __webpack_require__("./src/app/services/history.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var HistoryComponent = (function () {
    function HistoryComponent(userService, router, sharedService, changeDetectorRef, historyService, acRoute) {
        this.userService = userService;
        this.router = router;
        this.sharedService = sharedService;
        this.changeDetectorRef = changeDetectorRef;
        this.historyService = historyService;
        this.acRoute = acRoute;
    }
    HistoryComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.user = this.sharedService.user;
        this.historyService.getOperationsByUserId(this.user.id).subscribe(function (result) {
            _this.operations = result.data;
            // console.log('history list', this.operations);
        });
    };
    HistoryComponent.prototype.viewDetail = function (o) {
        this.router.navigate(['operation', o.id]);
    };
    return HistoryComponent;
}());
HistoryComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-history',
        template: __webpack_require__("./src/app/components/history/history.component.html"),
        styles: [__webpack_require__("./src/app/components/history/history.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_4__services_history_service_client__["a" /* HistoryService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__services_history_service_client__["a" /* HistoryService */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* ActivatedRoute */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* ActivatedRoute */]) === "function" && _f || Object])
], HistoryComponent);

var _a, _b, _c, _d, _e, _f;
//# sourceMappingURL=history.component.js.map

/***/ }),

/***/ "./src/app/components/history/operation/operation.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/history/operation/operation.component.html":
/***/ (function(module, exports) {


module.exports = "<div class=\"container-fluid\">\r\n  <div class=\"row\">\r\n    <div class=\"col-12 text-center mb-4\">\r\n      <h3 *ngIf=\"studentResults\">Compare Type: {{studentResults[0].comparisonType}}</h3>\r\n    </div>\r\n    <div class=\"col-5\">\r\n      <h5>Student List</h5>\r\n      <div *ngIf=\"studentResults\">\r\n        <div class=\"table-responsive-sm\">\r\n          <table class=\"table table-bordered table-hover\">\r\n            <thead>\r\n            <tr >\r\n              <th scope=\"col\">Student 1</th>\r\n              <th scope=\"col\">Student 2</th>\r\n              <th scope=\"col\">Result</th>\r\n            </tr>\r\n            </thead>\r\n            <tbody>\r\n            <tr class=\"jy-selectable\" *ngFor=\"let s of studentResults\" [class.table-primary] = \"selectedStudent === s\" (click)=\"selectStudent(s)\">\r\n              <td>{{s.student1Name}}</td>\r\n              <td>{{s.student2Name}}</td>\r\n              <td>\r\n                <div *ngIf=\"s.plagiarismExists; else notExist\">\r\n                  <span class=\"text-danger\">Plagiarism Found!</span>\r\n                  <button class=\"btn btn-sm btn-danger\" (click)=\"notifyStudents(s)\">Notify students</button>\r\n                </div>\r\n                <ng-template #notExist>\r\n                  <span class=\"text-success\">No Plagiarism</span>\r\n                </ng-template>\r\n              </td>\r\n            </tr>\r\n            </tbody>\r\n          </table>\r\n        </div>\r\n      </div>\r\n    </div>\r\n\r\n    <div class=\"col-7\">\r\n      <h5>File List</h5>\r\n      <div class=\"table-responsive-sm mx-auto\" *ngIf=\"compareResults; else elseBlock\">\r\n        <h5>Threshold used: {{compareResults[0].thresholdUsed}}</h5>\r\n        <table class=\"table table-bordered table-hover table-responsive\">\r\n          <thead>\r\n          <tr>\r\n            <th scope=\"col\">File 1</th>\r\n            <th scope=\"col\">File 2</th>\r\n            <th scope=\"col\">Average Score</th>\r\n            <th scope=\"col\">View Detail</th>\r\n          </tr>\r\n          </thead>\r\n          <tbody>\r\n          <tr *ngFor=\"let result of compareResults\" [class.table-danger]=\"result.plagiarismExists === 'YES'\" >\r\n            <td>{{result.file1Name}}</td>\r\n            <td>{{result.file2Name}}</td>\r\n            <td>{{result.averageScore}}</td>\r\n            <td>\r\n              <a (click)=\"viewDetail(result)\"><i class=\"fa fa-external-link\"></i></a>\r\n            </td>\r\n          </tr>\r\n          </tbody>\r\n        </table>\r\n      </div>\r\n      <ng-template #elseBlock>\r\n        <div>\r\n          <h4 class=\"text-info\">Select a pair of students to see file details</h4>\r\n        </div>\r\n      </ng-template>\r\n\r\n    </div>\r\n\r\n  </div>\r\n</div>\r\n\r\n<div class=\"modal fade text-left\" id=\"emailSentModel\" tabindex=\"-1\" role=\"dialog\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">Emails have been successfully sent</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\"  class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n"


/***/ }),

/***/ "./src/app/components/history/operation/operation.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OperationComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__services_history_service_client__ = __webpack_require__("./src/app/services/history.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var OperationComponent = (function () {
    function OperationComponent(userService, router, sharedService, changeDetectorRef, historyService, acRoute) {
        this.userService = userService;
        this.router = router;
        this.sharedService = sharedService;
        this.changeDetectorRef = changeDetectorRef;
        this.historyService = historyService;
        this.acRoute = acRoute;
    }
    OperationComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.user = this.sharedService.user;
        this.acRoute.params.subscribe(function (params) {
            _this.oId = params['oid'];
            _this.historyService.getStudentResult(_this.user.id, _this.oId).subscribe(function (result) {
                _this.studentResults = result.data;
                // console.log('student list', this.studentResults);
            });
        });
    };
    OperationComponent.prototype.selectStudent = function (s) {
        var _this = this;
        this.selectedStudent = s;
        this.historyService.getReportsOnStudentCompareId(this.user.id, this.oId, this.selectedStudent.id).subscribe(function (result) {
            _this.compareResults = result.data;
            // console.log('list of files', this.compareResults);
        });
    };
    OperationComponent.prototype.viewDetail = function (result) {
        this.sharedService.strategy = 'Weighted Average';
        this.sharedService.compareResult = result;
        this.router.navigate(['compare', 'result']);
    };
    OperationComponent.prototype.notifyStudents = function (studentResult) {
        console.log(studentResult);
        this.historyService.notifyStudents(this.user.id, studentResult.student1Id, studentResult.student2Id, studentResult.maxSimilarityInAnyTwoFiles).subscribe(function (result) {
            $('#emailSentModel').modal('show');
        });
    };
    return OperationComponent;
}());
OperationComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-operation',
        template: __webpack_require__("./src/app/components/history/operation/operation.component.html"),
        styles: [__webpack_require__("./src/app/components/history/operation/operation.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_4__services_history_service_client__["a" /* HistoryService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__services_history_service_client__["a" /* HistoryService */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* ActivatedRoute */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* ActivatedRoute */]) === "function" && _f || Object])
], OperationComponent);

var _a, _b, _c, _d, _e, _f;
//# sourceMappingURL=operation.component.js.map

/***/ }),

/***/ "./src/app/components/home/home.component.css":
/***/ (function(module, exports) {

module.exports = ".jy-below-nav {\r\n  margin-top: 70px;\r\n}\r\n\r\n.bg-img {\r\n  background-image: url('python.6f139f303a576eb9f905.png');\r\n  background-size: cover;\r\n  background-position: center;\r\n  height: 80vh;\r\n}\r\n\r\n.title-text {\r\n  background-color: rgba(255,255,255,0.4);\r\n}\r\n"

/***/ }),

/***/ "./src/app/components/home/home.component.html":
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-expand-md navbar-dark fixed-top bg-dark trans\">\r\n  <a class=\"navbar-brand\" routerLink=\"{{homeLink}}\">Home</a>\r\n  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\r\n    <span class=\"navbar-toggler-icon\"></span>\r\n  </button>\r\n\r\n\r\n  <div class=\"collapse navbar-collapse\" id=\"myNavbar\" >\r\n    <ul class=\"navbar-nav \" *ngIf=\"currentUser\">\r\n      <li class=\"nav-item\" [ngClass]=\"{'active': currentPath === '/compare'}\" *ngIf=\"currentUser.role === 'Professor' && currentUser.status === 'ACTIVE'\">\r\n        <a class=\"nav-link\" routerLink=\"/compare\">Compare</a>\r\n      </li>\r\n      <li class=\"nav-item dropdown\" *ngIf=\"currentUser.role === 'Professor' && currentUser.status === 'ACTIVE'\">\r\n        <a class=\"nav-link dropdown-toggle\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\"></a>\r\n        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n          <a class=\"dropdown-item\" routerLink=\"/upload/text\">Text</a>\r\n          <a class=\"dropdown-item\" routerLink=\"/upload/file\">File</a>\r\n          <a class=\"dropdown-item\" routerLink=\"/upload/folder\">Folder</a>\r\n        </div>\r\n      </li>\r\n      <li class=\"nav-item\" [ngClass]=\"{'active': currentPath === '/history'}\" *ngIf=\"currentUser.role === 'Professor' && currentUser.status === 'ACTIVE'\">\r\n        <a class=\"nav-link\" routerLink=\"/history\">History</a>\r\n      </li>\r\n      <li class=\"nav-item\" [ngClass]=\"{'active': currentPath === '/courses'}\" *ngIf=\"currentUser.role === 'Student'\">\r\n        <a class=\"nav-link\" routerLink=\"/courses\">Courses</a>\r\n      </li>\r\n    </ul>\r\n\r\n    <ul class=\"navbar-nav ml-auto\" *ngIf=\"!currentUser\">\r\n      <li class=\"mr-1\"><a class=\"nav-link\" data-toggle=\"modal\" data-target=\"#registerModel\"><i class=\"fa fa-user\"></i>  Sign Up</a></li>\r\n      <li><a class=\"nav-link\" data-toggle=\"modal\" data-target=\"#loginModel\"><i class=\"fa fa-sign-in\"></i>  Login</a></li>\r\n    </ul>\r\n\r\n    <ul class=\"navbar-nav ml-auto\" *ngIf=\"currentUser\">\r\n      <!--<li><a routerLink=\"/profile\" class=\"nav-link\">{{currentUser?.firstName + ' ' + currentUser?.lastName}}</a></li>-->\r\n      <a (click)=\"logOut()\" class=\"nav-link\">Log out</a>\r\n    </ul>\r\n\r\n  </div>\r\n</nav>\r\n\r\n<div class=\"jumbotron jumbotron-fluid bg-img\" *ngIf=\"currentPath === '/'\">\r\n  <div class=\"container text-center title-text\">\r\n    <h1 class=\"mt-4\">Compare python source code.</h1>\r\n    <h1 class=\"mt-2\">Detect plagiarism.</h1>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"jy-below-nav\">\r\n  <router-outlet></router-outlet>\r\n</div>\r\n<div class=\"modal fade\" id=\"registerModel\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Register</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <form #registerF=\"ngForm\">\r\n          <input name=\"firstName\" placeholder=\"First Name\" type=\"text\" class=\"form-control\"\r\n                 required [(ngModel)] = \"firstName\"/>\r\n          <input name=\"lastName\" placeholder=\"Last Name\" type=\"text\" class=\"form-control\"\r\n                 required [(ngModel)] = \"lastName\"/>\r\n          <input name=\"email\" placeholder=\"email\" type=\"email\" class=\"form-control\"\r\n                 required [(ngModel)] = \"emailAddress\" email/>\r\n          <input name=\"password1\" placeholder=\"password\" type=\"password\" class=\"form-control\"\r\n                 required [(ngModel)] = \"password1\"/>\r\n          <input name=\"password2\" placeholder=\"verify password\" type=\"password\" class=\"form-control\"\r\n                 required [(ngModel)] = \"password2\"/>\r\n          <div class=\"form-group\">\r\n            <label for=\"role\">Role</label>\r\n            <select class=\"form-control\" id=\"role\" name=\"role\" [(ngModel)] = \"userRole\" required>\r\n              <option *ngFor=\"let r of roles\" [value]=\"r\">{{r}}</option>\r\n            </select>\r\n          </div>\r\n          <div *ngIf=\"errorFlag\" class=\"alert alert-danger\">\r\n            {{errorMsg}}\r\n          </div>\r\n        </form>\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\"  class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n        <button type=\"button\" class=\"btn btn-primary btn-block\" (click)=\"register()\" [disabled]=\"!registerF.valid\">Register</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"modal fade\" id=\"loginModel\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">Login</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <div *ngIf=\"loginErrorFlag\" class=\"alert alert-danger\">\r\n          {{loginErrorMsg}}\r\n        </div>\r\n\r\n        <form #f=\"ngForm\">\r\n          <input placeholder=\"email\" name=\"email\" type=\"text\" class=\"form-control\" [(ngModel)] = \"loginEmail\" required\r\n                 #ue=\"ngModel\"/>\r\n          <span class=\"help-block\" *ngIf=\"!ue.valid && ue.touched\">Please enter email!</span>\r\n\r\n          <input placeholder=\"password\" name=\"password\" type=\"password\" class=\"form-control\" [(ngModel)] = \"loginPass\" required\r\n                 #pw=\"ngModel\"/>\r\n          <span class=\"help-block\" *ngIf=\"!pw.valid && pw.touched\">Please enter password!</span>\r\n        </form>\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n        <button type=\"button\" class=\"btn btn-primary btn-block\" (click)=\"login()\" [disabled]=\"!f.valid\">Login</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/home/home.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomeComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var HomeComponent = (function () {
    function HomeComponent(router, sharedService, userService) {
        this.router = router;
        this.sharedService = sharedService;
        this.userService = userService;
        this.homeLink = '/';
        this.roles = ['Professor', 'Student', 'Admin'];
        this.errorMsg = 'Password does not match';
        this.loginErrorMsg = 'Invalid username or password !';
    }
    HomeComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.currentUser = this.sharedService.user;
        this.homeLink = this.currentUser ? '/profile' : '/';
        // console.log('home init, current user:' + this.currentUser);
        this.router.events.subscribe(function (event) {
            if (event instanceof __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* NavigationEnd */]) {
                _this.currentPath = event.url;
            }
        });
        this.userSub = this.sharedService.userObservable.subscribe(function (user) {
            // console.log('user subscribe');
            // console.log(user);
            _this.currentUser = user;
            _this.homeLink = _this.currentUser ? '/profile' : '/';
        });
    };
    HomeComponent.prototype.register = function () {
        var _this = this;
        if (!this.isRegInputValid()) {
            this.errorMsg = 'All fields cannot be empty';
            this.errorFlag = true;
        }
        else if (this.password1 === this.password2) {
            // console.log('user register', this.emailAddress);
            this.userService.findUserByEmail(this.emailAddress).subscribe(function (data) {
                // console.log('find by enail', data);
                // console.log(data.status, data.status === 201, data.status === '201');
                if (data.status === '200') {
                    _this.errorMsg = 'Username already taken';
                    _this.errorFlag = true;
                }
                else {
                    _this.errorFlag = false;
                    var user = {
                        firstName: _this.firstName,
                        lastName: _this.lastName,
                        emailAddress: _this.emailAddress,
                        password: _this.password1,
                        role: _this.userRole,
                    };
                    _this.userService.register(user)
                        .subscribe(function (res) {
                        _this.sharedService.setUser(res.data);
                        // console.log('user register.', res);
                        _this.clearRegisterModel();
                        $('#registerModel').modal('hide');
                        _this.router.navigate(['profile']);
                    });
                }
            });
        }
        else {
            this.errorMsg = 'Password does not match';
            this.errorFlag = true;
        }
    };
    HomeComponent.prototype.login = function () {
        var _this = this;
        this.userService.login(this.loginEmail, this.loginPass)
            .subscribe(function (res) {
            // console.log('User log in: ', res);
            if (res.data) {
                _this.loginErrorFlag = false;
                _this.sharedService.setUser(res.data);
                _this.clearLoginModel();
                $('#loginModel').modal('hide');
                if (res.data.role === 'Admin') {
                    _this.router.navigate(['admin']);
                }
                else {
                    _this.router.navigate(['profile']);
                }
            }
            else {
                _this.loginErrorFlag = true;
            }
        });
        // }, (err) => {
        //   console.log(err);
        //   if (err === 'Unauthorized') {
        //     this.loginErrorFlag = true;
        //   }
        // });
    };
    HomeComponent.prototype.isRegInputValid = function () {
        if (this.firstName.trim().length === 0 || this.lastName.trim().length === 0 ||
            this.emailAddress.trim().length === 0 || this.password1.trim().length === 0) {
            return false;
        }
        else {
            return true;
        }
    };
    HomeComponent.prototype.clearRegisterModel = function () {
        this.firstName = null;
        this.lastName = null;
        this.emailAddress = null;
        this.password1 = null;
        this.password2 = null;
        this.errorFlag = false;
    };
    HomeComponent.prototype.clearLoginModel = function () {
        this.loginEmail = null;
        this.loginPass = null;
    };
    HomeComponent.prototype.logOut = function () {
        this.sharedService.clearUser();
        this.router.navigate(['/']);
        // this.userService.logout().subscribe(result => {
        //   this.router.navigate(['/']);
        // });
    };
    return HomeComponent;
}());
HomeComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-home',
        template: __webpack_require__("./src/app/components/home/home.component.html"),
        styles: [__webpack_require__("./src/app/components/home/home.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* Router */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__services_shared_service_client__["a" /* SharedService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_user_service_client__["a" /* UserService */]) === "function" && _c || Object])
], HomeComponent);

var _a, _b, _c;
//# sourceMappingURL=home.component.js.map

/***/ }),

/***/ "./src/app/components/user/prof-assignment/prof-assignment.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/user/prof-assignment/prof-assignment.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"row mt-4\">\r\n  <div class=\"col-3\">\r\n    <h4>Courses</h4>\r\n    <ul class=\"list-group\">\r\n      <li class=\"list-group-item jy-selectable\" *ngFor=\"let c of courses\"\r\n          (click)=\"selectCourse(c)\" [class.active] = \"selectedCourse == c\">\r\n        {{c.courseName}}\r\n      </li>\r\n    </ul>\r\n  </div>\r\n\r\n  <div class=\"col-4\" *ngIf=\"selectedCourse; else elseBlock\">\r\n    <h4>Assignments</h4>\r\n    <ul class=\"list-group\">\r\n      <li class=\"list-group-item d-flex justify-content-between align-items-center\">\r\n        <b>Assignment Name</b>\r\n        <b>Edit</b>\r\n      </li>\r\n      <li class=\"list-group-item d-flex justify-content-between align-items-center\" *ngFor=\"let a of assignments\"\r\n          (click)=\"selectAssignment(a)\" [class.active] = \"selectedAssignment == a\">\r\n        {{a.name}}\r\n        <a (click)=\"editAssignment(a)\"><i class=\"fa fa-cog\"></i></a>\r\n      </li>\r\n    </ul>\r\n    <button type=\"button\" class=\"btn btn-primary my-2\"\r\n            data-toggle=\"modal\" data-target=\"#newAssnModel\">Create Assignment</button>\r\n  </div>\r\n  <ng-template #elseBlock>\r\n    <div class=\"col-4\">\r\n      <h4 class=\"text-info\">No Course Selected</h4>\r\n    </div>\r\n  </ng-template>\r\n\r\n  <div class=\"col-5\" *ngIf=\"selectedAssignment; else aelseBlock\">\r\n    <h4>Assignment: {{selectedAssignment.name}}</h4>\r\n    <p>Deadline: {{selectedAssignment.deadline}}</p>\r\n    <a [href]=\"selectedAssignment.documentUrl\" target=\"_blank\">\r\n      Document link: {{selectedAssignment.documentUrl}}</a>\r\n    <p>Submission type: {{selectedAssignment.submissionType}}</p>\r\n    <a class=\"text-primary\" (click)=\"viewSubmission()\">View submissions</a>\r\n  </div>\r\n  <ng-template #aelseBlock>\r\n    <div class=\"col-5\">\r\n      <h4 class=\"text-info\">No Assignment Selected</h4>\r\n    </div>\r\n  </ng-template>\r\n\r\n</div>\r\n\r\n<div class=\"modal fade text-left\" id=\"newAssnModel\" tabindex=\"-1\" role=\"dialog\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">Create new assignment</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <form #assnF=\"ngForm\">\r\n          <div class=\"form-group\">\r\n            <label for=\"aName\">Assignment Name</label>\r\n            <input name=\"aName\" type=\"text\" class=\"form-control\" id=\"aName\" required [(ngModel)] = \"nAssnName\"/>\r\n          </div>\r\n          <div class=\"form-group\">\r\n            <label for=\"aDoc\">Assignment Doc Link</label>\r\n            <input name=\"aDoc\" type=\"text\" class=\"form-control\" id=\"aDoc\" required [(ngModel)] = \"nAssnDoc\"/>\r\n          </div>\r\n          <div class=\"form-group\">\r\n            <label for=\"aType\">Submission Type</label>\r\n            <select class=\"form-control\" id=\"aType\" name=\"aType\" [(ngModel)] = \"nAssnType\" required>\r\n              <option *ngFor=\"let t of sTypes\" [value]=\"t\">{{t}}</option>\r\n            </select>\r\n          </div>\r\n          <div class=\"form-group\">\r\n            <label for=\"aDeadline\">Assignment Deadline</label>\r\n            <input name=\"aDeadline\" type=\"date\" class=\"form-control\" id=\"aDeadline\" required [(ngModel)] = \"nAssnDeadline\"/>\r\n          </div>\r\n        </form>\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\"  class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n        <button type=\"button\" class=\"btn btn-primary btn-block\" (click)=\"createAssignment()\" [disabled]=\"!assnF.valid\">Create</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"modal fade text-left\" id=\"editAssnModel\" tabindex=\"-1\" role=\"dialog\" *ngIf=\"editingAssignment\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">Edit assignment</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <form #assneF=\"ngForm\">\r\n          <div class=\"form-group\">\r\n            <label for=\"aeName\">Assignment Name</label>\r\n            <input name=\"aeName\" type=\"text\" class=\"form-control\" id=\"aeName\" required [(ngModel)] = \"editingAssignment.name\"/>\r\n          </div>\r\n          <div class=\"form-group\">\r\n            <label for=\"aeDoc\">Assignment Doc Link</label>\r\n            <input name=\"aeDoc\" type=\"text\" class=\"form-control\" id=\"aeDoc\" required [(ngModel)] = \"editingAssignment.documentUrl\"/>\r\n          </div>\r\n          <div class=\"form-group\">\r\n            <label for=\"aeType\">Submission Type</label>\r\n            <select class=\"form-control\" id=\"aeType\" name=\"aeType\" [(ngModel)] = \"editingAssignment.submissionType\" required>\r\n              <option *ngFor=\"let t of sTypes\" [value]=\"t\">{{t}}</option>\r\n            </select>\r\n          </div>\r\n          <div class=\"form-group\">\r\n            <label for=\"aeDeadline\">Assignment Deadline</label>\r\n            <input name=\"aeDeadline\" type=\"date\" class=\"form-control\" id=\"aeDeadline\" required [(ngModel)] = \"editingAssignment.deadline\"/>\r\n          </div>\r\n        </form>\r\n      </div>\r\n      <div *ngIf=\"updateMessageFlag\" class=\"alert alert-success mx-2\" role=\"alert\">\r\n        {{updateMessage}}\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\"  class=\"btn btn-danger\" data-dismiss=\"modal\" (click)=\"deleteAssignment()\">Delete</button>\r\n        <button type=\"button\" class=\"btn btn-primary btn-block\" (click)=\"updateAssignment()\" [disabled]=\"!assneF.valid\">Update</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/user/prof-assignment/prof-assignment.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ProfAssignmentComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__ = __webpack_require__("./src/app/services/course.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__services_assignment_service_client__ = __webpack_require__("./src/app/services/assignment.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var ProfAssignmentComponent = (function () {
    function ProfAssignmentComponent(userService, router, sharedService, courseService, changeDetectorRef, assignmentService) {
        this.userService = userService;
        this.router = router;
        this.sharedService = sharedService;
        this.courseService = courseService;
        this.changeDetectorRef = changeDetectorRef;
        this.assignmentService = assignmentService;
        this.sTypes = ['FILE', 'FOLDER'];
        this.updateMessageFlag = false;
        this.updateMessage = 'Successfully Updated';
    }
    ProfAssignmentComponent.prototype.ngOnInit = function () {
        this.user = this.sharedService.user;
        this.getAllCourses();
    };
    ProfAssignmentComponent.prototype.createAssignment = function () {
        var _this = this;
        var newAssignment = {
            name: this.nAssnName,
            deadline: this.nAssnDeadline,
            documentUrl: this.nAssnDoc,
            submissionType: this.nAssnType,
            relatedCourseId: this.selectedCourse._id,
            status: 'ACTIVE',
        };
        // console.log('new assignment', newAssignment);
        this.assignmentService.createAssignment(newAssignment, this.user.id).subscribe(function (r) {
            $('#newAssnModel').modal('hide');
            _this.clearCreateModel();
            _this.getAllAssignmentsForCourse();
        });
    };
    ProfAssignmentComponent.prototype.refreshCourses = function () {
        this.getAllCourses();
        this.selectedAssignment = null;
        this.selectedCourse = null;
        this.changeDetectorRef.detectChanges();
    };
    ProfAssignmentComponent.prototype.getAllAssignmentsForCourse = function () {
        var _this = this;
        this.assignmentService.findAssignmentsByCourseId(this.selectedCourse._id, this.user.id).subscribe(function (result) {
            _this.assignments = result.data;
            // console.log('assignments', this.assignments);
        });
    };
    ProfAssignmentComponent.prototype.updateAssignment = function () {
        var _this = this;
        this.assignmentService.updateAssignment(this.editingAssignment, this.user.id).subscribe(function (r) {
            _this.updateMessageFlag = true;
            _this.getAllAssignmentsForCourse();
        });
    };
    ProfAssignmentComponent.prototype.deleteAssignment = function () {
        var _this = this;
        this.assignmentService.deleteAssignment(this.selectedAssignment._id, this.user.id).subscribe(function (r) {
            _this.selectedAssignment = null;
            _this.getAllAssignmentsForCourse();
        });
    };
    ProfAssignmentComponent.prototype.editAssignment = function (a) {
        this.editingAssignment = a;
        this.changeDetectorRef.detectChanges();
        this.updateMessageFlag = false;
        $('#editAssnModel').modal('show');
    };
    ProfAssignmentComponent.prototype.getAllCourses = function () {
        var _this = this;
        this.courseService.findCourseByFacultyId(this.user.id, this.user.id).subscribe(function (result) {
            _this.courses = result.data;
            // console.log('course', this.courses);
        });
    };
    ProfAssignmentComponent.prototype.selectCourse = function (c) {
        // console.log('select course');
        this.selectedCourse = c;
        this.getAllAssignmentsForCourse();
    };
    ProfAssignmentComponent.prototype.selectAssignment = function (a) {
        this.selectedAssignment = a;
    };
    ProfAssignmentComponent.prototype.clearCreateModel = function () {
        this.nAssnName = null;
        this.nAssnDeadline = null;
        this.nAssnDoc = null;
    };
    ProfAssignmentComponent.prototype.viewSubmission = function () {
        this.router.navigate(['assignment', this.selectedAssignment._id]);
    };
    return ProfAssignmentComponent;
}());
ProfAssignmentComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-prof-assignment',
        template: __webpack_require__("./src/app/components/user/prof-assignment/prof-assignment.component.html"),
        styles: [__webpack_require__("./src/app/components/user/prof-assignment/prof-assignment.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__["a" /* CourseService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__["a" /* CourseService */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_5__services_assignment_service_client__["a" /* AssignmentService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__services_assignment_service_client__["a" /* AssignmentService */]) === "function" && _f || Object])
], ProfAssignmentComponent);

var _a, _b, _c, _d, _e, _f;
//# sourceMappingURL=prof-assignment.component.js.map

/***/ }),

/***/ "./src/app/components/user/prof-course/prof-course.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/user/prof-course/prof-course.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"jy-max-width-700 mx-auto\">\r\n  <button type=\"button\" class=\"btn btn-primary my-2\"\r\n          data-toggle=\"modal\" data-target=\"#newCourseModel\">Create course</button>\r\n  <!--<ul class=\"list-group\" >-->\r\n    <!--<li class=\"list-group-item d-flex justify-content-between align-items-center\">-->\r\n      <!--<b>Course Name</b>-->\r\n      <!--<b>Students</b>-->\r\n      <!--<b>Edit</b>-->\r\n    <!--</li>-->\r\n    <!--<li class=\"list-group-item d-flex justify-content-between align-items-center\" *ngFor=\"let c of courses\">-->\r\n      <!--<span>{{c.courseName}}</span>-->\r\n      <!--<a (click)=\"showStudents(c)\" class=\"text-primary\">{{c.studentsEnrolled.length}}</a>-->\r\n      <!--<a (click)=\"editCourse(c)\"><i class=\"fa fa-cog\"></i></a>-->\r\n    <!--</li>-->\r\n  <!--</ul>-->\r\n  <div class=\"table-responsive-sm\">\r\n    <table class=\"table table-bordered\">\r\n      <thead>\r\n      <tr>\r\n        <th scope=\"col\">Course Name</th>\r\n        <th scope=\"col\">Student Number</th>\r\n        <th scope=\"col\">Edit</th>\r\n      </tr>\r\n      </thead>\r\n      <tbody>\r\n      <tr *ngFor=\"let c of courses\">\r\n        <td>{{c.courseName}}</td>\r\n        <td><a (click)=\"showStudents(c)\" class=\"text-primary\">{{c.studentsEnrolled?.length}}</a></td>\r\n        <td><a (click)=\"editCourse(c)\"><i class=\"fa fa-cog\"></i></a></td>\r\n      </tr>\r\n      </tbody>\r\n    </table>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"modal fade text-left\" id=\"newCourseModel\" tabindex=\"-1\" role=\"dialog\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">Create new course</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <form #courseF=\"ngForm\">\r\n          <div class=\"form-group\">\r\n            <label for=\"cName\">Course Name</label>\r\n            <input name=\"cName\" type=\"text\" class=\"form-control\" id=\"cName\" required [(ngModel)] = \"nCourseName\"/>\r\n          </div>\r\n          <div class=\"form-group\">\r\n            <label for=\"courseSem\">Semester</label>\r\n            <select class=\"form-control\" id=\"courseSem\" name=\"courseSem\" [(ngModel)] = \"selectedSemId\" required>\r\n              <option *ngFor=\"let sem of semesters\" [value]=\"sem._id\">{{sem.name}}</option>\r\n            </select>\r\n          </div>\r\n        </form>\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\"  class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n        <button type=\"button\" class=\"btn btn-primary btn-block\" (click)=\"createCourse()\" [disabled]=\"!courseF.valid\">Create</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"modal fade text-left\" id=\"editCourseModel\" tabindex=\"-1\" role=\"dialog\" *ngIf=\"selectedCourse\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">Edit course</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <form #courseF=\"ngForm\">\r\n          <div class=\"form-group\">\r\n            <label for=\"ecName\">Course Name</label>\r\n            <input name=\"cName\" type=\"text\" class=\"form-control\" id=\"ecName\" required [(ngModel)] = \"selectedCourse.courseName\"/>\r\n          </div>\r\n          <div class=\"form-group\">\r\n            <label for=\"ecourseSem\">Semester</label>\r\n            <select class=\"form-control\" id=\"ecourseSem\" name=\"courseSem\" [(ngModel)] = \"selectedCourse.semesterId\" required>\r\n              <option *ngFor=\"let sem of semesters\" [value]=\"sem._id\">{{sem.name}}</option>\r\n            </select>\r\n          </div>\r\n        </form>\r\n      </div>\r\n      <div *ngIf=\"updateMessageFlag\" class=\"alert alert-success mx-2\" role=\"alert\">\r\n        {{updateMessage}}\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\"  class=\"btn btn-danger\" data-dismiss=\"modal\" (click)=\"deleteCourse()\">Delete</button>\r\n        <button type=\"button\" class=\"btn btn-primary btn-block\" (click)=\"updateCourse()\" [disabled]=\"!courseF.valid\">Update</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"modal fade text-left\" id=\"studentListModel\" tabindex=\"-1\" role=\"dialog\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">Student List</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <ul class=\"list-group\">\r\n          <li class=\"list-group-item\" *ngFor=\"let s of students\">{{s.firstName + ' ' + s.lastName}}</li>\r\n        </ul>\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\"  class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/user/prof-course/prof-course.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ProfCourseComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__ = __webpack_require__("./src/app/services/course.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var ProfCourseComponent = (function () {
    function ProfCourseComponent(userService, router, sharedService, courseService, changeDetectorRef) {
        this.userService = userService;
        this.router = router;
        this.sharedService = sharedService;
        this.courseService = courseService;
        this.changeDetectorRef = changeDetectorRef;
        this.updateMessageFlag = false;
        this.updateMessage = 'Successfully Updated';
    }
    ProfCourseComponent.prototype.ngOnInit = function () {
        this.user = this.sharedService.user;
        this.getAllSemesters();
        this.getAllCourses();
    };
    ProfCourseComponent.prototype.createCourse = function () {
        var _this = this;
        var newCourse = {
            courseName: this.nCourseName,
            facultyID: this.user.id,
            semesterId: this.selectedSemId,
            status: 'ACTIVE',
        };
        // console.log('new course', newCourse);
        this.courseService.createCourse(newCourse, this.user.id).subscribe(function (r) {
            $('#newCourseModel').modal('hide');
            _this.clearCreateModel();
            _this.getAllCourses();
        });
    };
    ProfCourseComponent.prototype.getAllCourses = function () {
        var _this = this;
        this.courseService.findCourseByFacultyId(this.user.id, this.user.id).subscribe(function (result) {
            _this.courses = result.data;
            // console.log('course', this.courses);
        });
    };
    ProfCourseComponent.prototype.updateCourse = function () {
        var _this = this;
        this.courseService.updateCourse(this.selectedCourse, this.user.id).subscribe(function (r) {
            _this.updateMessageFlag = true;
            _this.getAllCourses();
        });
    };
    ProfCourseComponent.prototype.deleteCourse = function () {
        var _this = this;
        this.courseService.deleteCourse(this.selectedCourse._id, this.user.id).subscribe(function (r) {
            _this.selectedCourse = null;
            _this.getAllCourses();
        });
    };
    ProfCourseComponent.prototype.getAllSemesters = function () {
        var _this = this;
        this.courseService.findAllActiveSemesters(this.user.id).subscribe(function (result) {
            _this.semesters = result.data;
            // console.log('semester', this.semesters);
            // this.changeDetectorRef.detectChanges();
        });
    };
    ProfCourseComponent.prototype.editCourse = function (c) {
        this.selectedCourse = c;
        this.changeDetectorRef.detectChanges();
        this.updateMessageFlag = false;
        $('#editCourseModel').modal('show');
    };
    ProfCourseComponent.prototype.showStudents = function (c) {
        var _this = this;
        this.courseService.findStudentsForCourse(this.user.id, c._id).subscribe(function (result) {
            // console.log('students for course', result);
            _this.students = result.data;
            _this.changeDetectorRef.detectChanges();
            $('#studentListModel').modal('show');
        });
    };
    ProfCourseComponent.prototype.clearCreateModel = function () {
        this.nCourseName = null;
    };
    return ProfCourseComponent;
}());
ProfCourseComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-prof-course',
        template: __webpack_require__("./src/app/components/user/prof-course/prof-course.component.html"),
        styles: [__webpack_require__("./src/app/components/user/prof-course/prof-course.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__["a" /* CourseService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__["a" /* CourseService */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */]) === "function" && _e || Object])
], ProfCourseComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=prof-course.component.js.map

/***/ }),

/***/ "./src/app/components/user/profile/profile.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/user/profile/profile.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\r\n\r\n  <div class=\"row\" *ngIf=\"user.status === 'ACTIVE'\">\r\n    <div class=\"col text-center\">\r\n      <h3>{{user.firstName + ' ' + user.lastName}}</h3>\r\n      <h6>{{'Email: ' + user.emailAddress}}</h6>\r\n      <h6>{{'Role: ' + user.role}}</h6>\r\n      <a *ngIf=\"user.role === 'Admin'\" class=\"btn btn-primary\" routerLink=\"/admin\">Admin page</a>\r\n\r\n      <ul class=\"nav nav-tabs\" id=\"myTab\">\r\n\r\n        <li class=\"nav-item\" *ngIf=\"user.role === 'Professor'\">\r\n          <a class=\"nav-link\" [class.active]=\"user.role === 'Professor'\" id=\"prof-course-tab\"\r\n             data-toggle=\"tab\" href=\"#profCourse\">My courses</a>\r\n        </li>\r\n        <li class=\"nav-item\" *ngIf=\"user.role === 'Professor'\">\r\n          <a (click)=\"profAssn.refreshCourses()\" class=\"nav-link\" id=\"prof-assignment-tab\" data-toggle=\"tab\" href=\"#profAssinment\">Course Assignment</a>\r\n        </li>\r\n        <li class=\"nav-item\" *ngIf=\"user.role === 'Student'\">\r\n          <a  class=\"nav-link\" [class.active]=\"user.role === 'Student'\" id=\"student-course-tab\"\r\n              data-toggle=\"tab\" href=\"#enrolledCourse\">My courses</a>\r\n        </li>\r\n        <li class=\"nav-item\" *ngIf=\"user.role !== 'Admin'\">\r\n          <a class=\"nav-link\" id=\"about-tab\" data-toggle=\"tab\" href=\"#profile\">Profile</a>\r\n        </li>\r\n      </ul>\r\n\r\n      <div class=\"tab-content\" id=\"myTabContent\">\r\n        <div class=\"tab-pane fade\" [ngClass]=\"{'show': user.role === 'Professor', 'active': user.role === 'Professor'}\" id=\"profCourse\">\r\n          <app-prof-course *ngIf=\"user.role === 'Professor'\"></app-prof-course>\r\n        </div>\r\n\r\n        <div class=\"tab-pane fade\" id=\"profAssinment\">\r\n          <app-prof-assignment #profAssn></app-prof-assignment>\r\n        </div>\r\n\r\n        <div class=\"tab-pane fade\" id=\"enrolledCourse\" [ngClass]=\"{'show': user.role === 'Student', 'active': user.role === 'Student'}\">\r\n          <app-student-course *ngIf=\"user.role === 'Student'\"></app-student-course>\r\n        </div>\r\n        <div class=\"tab-pane fade\" id=\"profile\">\r\n          <div>\r\n            <form class=\"jy-max-width-700 mx-auto text-left mt-4\" *ngIf=\"user\">\r\n              <div class=\"form-group\">\r\n                <label for=\"firstName\">First Name:</label>\r\n                <input type=\"text\" class=\"form-control\" name=\"firstName\" id=\"firstName\" [(ngModel)] = \"user.firstName\">\r\n              </div>\r\n              <div class=\"form-group\">\r\n                <label for=\"lastName\">Last Name:</label>\r\n                <input type=\"text\" class=\"form-control\" name=\"lastName\" id=\"lastName\" [(ngModel)] = \"user.lastName\">\r\n              </div>\r\n              <div class=\"form-group\" *ngIf=\"user.role === 'Professor'\">\r\n                <label for=\"threshold\">Plagiarism threshold: {{user.threshold}}</label>\r\n                <input type=\"range\" class=\"form-control-range\" min=\"10\" max=\"90\" id=\"threshold\" name=\"threshold\" [(ngModel)] = \"user.threshold\">\r\n                <small id=\"thresholdHelpBlock\" class=\"form-text text-muted\">\r\n                  Set how tolerant to plagiarism. Files whose similarity scores are above this threshold will be marked as plagiarism.\r\n                </small>\r\n              </div>\r\n              <div *ngIf=\"updateMessageFlag\" class=\"alert alert-success\" role=\"alert\">\r\n                {{updateMessage}}\r\n              </div>\r\n              <button (click)=\"updateUser()\" class=\"btn btn-primary btn-block\">Save</button>\r\n              <button (click)=\"logOut()\" class=\"btn btn-danger btn-block\">Log out</button>\r\n            </form>\r\n          </div>\r\n        </div>\r\n\r\n      </div>\r\n\r\n\r\n    </div>\r\n  </div>\r\n\r\n  <div class=\"row\" *ngIf=\"user.status === 'APPROVAL'\">\r\n    <div class=\"col text-center\">\r\n      <h3 class=\"mb-2\">Your registration needs approval from system admin</h3>\r\n      <button (click)=\"logOut()\" class=\"btn btn-danger\">Log out</button>\r\n    </div>\r\n  </div>\r\n\r\n  <div class=\"row\" *ngIf=\"user.status === 'REJECTED'\">\r\n    <div class=\"col text-center\">\r\n      <h3 class=\"mb-2\">Your registration has been rejected by system admin. Contact admin for details</h3>\r\n      <button (click)=\"logOut()\" class=\"btn btn-danger\">Log out</button>\r\n    </div>\r\n  </div>\r\n\r\n\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/user/profile/profile.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ProfileComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ProfileComponent = (function () {
    function ProfileComponent(userService, router, sharedService) {
        this.userService = userService;
        this.router = router;
        this.sharedService = sharedService;
        this.updateMessageFlag = false;
        this.updateMessage = 'Successfully updated';
    }
    ProfileComponent.prototype.ngOnInit = function () {
        this.user = this.sharedService.user;
        // this.user = {
        //   firstName: 'Alice',
        //   lastName: 'Wonder',
        //   emailAddress: 'alice@wonder.com',
        //   role: 'teacher',
        // };
    };
    ProfileComponent.prototype.updateUser = function () {
        var _this = this;
        this.userService.updateUser(this.user)
            .subscribe(function (res) {
            _this.sharedService.setUser(res.data);
            _this.user = res.data;
            _this.updateMessageFlag = true;
        });
    };
    ProfileComponent.prototype.logOut = function () {
        this.sharedService.clearUser();
        this.router.navigate(['/']);
        // this.userService.logout().subscribe(result => {
        //   this.router.navigate(['/']);
        // });
    };
    return ProfileComponent;
}());
ProfileComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-profile',
        template: __webpack_require__("./src/app/components/user/profile/profile.component.html"),
        styles: [__webpack_require__("./src/app/components/user/profile/profile.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */]) === "function" && _c || Object])
], ProfileComponent);

var _a, _b, _c;
//# sourceMappingURL=profile.component.js.map

/***/ }),

/***/ "./src/app/components/user/student-course/student-course.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/components/user/student-course/student-course.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"row mt-4\">\r\n  <div class=\"col-3\">\r\n    <h4>Enrolled Courses</h4>\r\n    <ul class=\"list-group\">\r\n      <li class=\"list-group-item\" *ngFor=\"let c of courses\"\r\n          (click)=\"selectCourse(c)\" [class.active] = \"selectedCourse == c\">\r\n        {{c.courseName}}\r\n      </li>\r\n    </ul>\r\n    <button class=\"btn btn-primary my-3\" routerLink=\"/courses\">Course enroll</button>\r\n  </div>\r\n\r\n  <div class=\"col-4\" *ngIf=\"selectedCourse; else elseBlock\">\r\n    <h4>Course assignments</h4>\r\n    <ul class=\"list-group\">\r\n      <li class=\"list-group-item\" *ngFor=\"let a of assignments\"\r\n          (click)=\"selectAssignment(a)\" [class.active] = \"selectedAssignment == a\">\r\n        {{a.name}}\r\n      </li>\r\n    </ul>\r\n  </div>\r\n  <ng-template #elseBlock>\r\n    <div class=\"col-4\">\r\n      <h4 class=\"text-info\">No Course Selected</h4>\r\n    </div>\r\n  </ng-template>\r\n\r\n  <div class=\"col-5\" *ngIf=\"selectedAssignment; else aelseBlock\">\r\n    <h4>Assignment: {{selectedAssignment.name}}</h4>\r\n    <p>Deadline: {{selectedAssignment.deadline}}</p>\r\n    <a [href]=\"selectedAssignment.documentUrl\" target=\"_blank\">\r\n      Document link: {{selectedAssignment.documentUrl}}</a>\r\n    <b>Accepted submission type: {{selectedAssignment.submissionType}}</b>\r\n    <div *ngIf=\"submittedAssnId.indexOf(selectedAssignment._id) > -1\">\r\n      <p class=\"text-success\">Already submitted</p>\r\n    </div>\r\n    <div *ngIf=\"submittedAssnId.indexOf(selectedAssignment._id) == -1\">\r\n      <button class=\"btn btn-primary\" (click)=\"submit()\">Submit</button>\r\n    </div>\r\n  </div>\r\n  <ng-template #aelseBlock>\r\n    <div class=\"col-5\">\r\n      <h4 class=\"text-info\">No Assignment Selected</h4>\r\n    </div>\r\n  </ng-template>\r\n\r\n</div>\r\n\r\n<div class=\"modal fade text-left\" id=\"uploadFileModel\" tabindex=\"-1\" role=\"dialog\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">Select a single python file</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <form #fileF=\"ngForm\">\r\n          <input (change)=fileEvent($event) name=\"file\" type=\"file\" class=\"form-control\"\r\n                  id=\"file\" accept=\".py\" required>\r\n        </form>\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\"  class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n        <button type=\"button\" class=\"btn btn-primary btn-block\" (click)=\"uploadFile()\" [disabled]=\"!file\">Upload</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"modal fade text-left\" id=\"uploadFolderModel\" tabindex=\"-1\" role=\"dialog\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">Select your python project folder</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <form #folderF=\"ngForm\">\r\n          <div class=\"form-group\">\r\n            <label class=\"btn btn-secondary\" for=\"fileList\">Select Folder</label>\r\n            <input (change)=fileEvent($event) name=\"fileList\" type=\"file\" class=\"form-control\"\r\n                   id=\"fileList\" accept=\".py\" webkitdirectory directory multiple hidden required>\r\n          </div>\r\n        </form>\r\n        <p *ngIf=\"fileList && fileList.length > 0\">{{fileList.length + ' files selected'}}</p>\r\n        <div *ngIf=\"errorFlag\" class=\"alert alert-danger\">\r\n          {{errorMsg}}\r\n        </div>\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\"  class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n        <button type=\"button\" class=\"btn btn-primary btn-block\" (click)=\"uploadFolder()\" [disabled]=\"fileList.length == 0\">Upload</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/user/student-course/student-course.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return StudentCourseComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__ = __webpack_require__("./src/app/services/course.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__services_assignment_service_client__ = __webpack_require__("./src/app/services/assignment.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var StudentCourseComponent = (function () {
    function StudentCourseComponent(userService, router, sharedService, courseService, changeDetectorRef, assignmentService) {
        this.userService = userService;
        this.router = router;
        this.sharedService = sharedService;
        this.courseService = courseService;
        this.changeDetectorRef = changeDetectorRef;
        this.assignmentService = assignmentService;
        this.file = null;
        this.fileList = [];
        this.submittedAssnId = [];
        this.errorFlag = false;
        this.errorMsg = 'No python file in the folder';
    }
    StudentCourseComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.user = this.sharedService.user;
        this.courseService.findCoursesForStudent(this.user.id).subscribe(function (result) {
            _this.courses = result.data;
        });
        // console.log('student course', this.courses);
        this.getAllSubmission();
    };
    StudentCourseComponent.prototype.getAllSubmission = function () {
        var _this = this;
        this.assignmentService.getSubmissionByStudentId(this.user.id, this.user.id).subscribe(function (result) {
            _this.submissions = result.data;
            // console.log('student submission', this.submissions);
            if (_this.submissions) {
                var assnIds_1 = [];
                _this.submissions.forEach(function (s) {
                    assnIds_1.push(s.homeworkId);
                });
                _this.submittedAssnId = assnIds_1;
                // console.log('submitted ids', this.submittedAssnId);
            }
            else {
                _this.submittedAssnId = [];
            }
        });
    };
    StudentCourseComponent.prototype.getAllAssignmentsForCourse = function () {
        var _this = this;
        this.assignmentService.findAssignmentsByCourseId(this.selectedCourse._id, this.user.id).subscribe(function (result) {
            _this.assignments = result.data;
            // console.log('assignments', this.assignments);
        });
    };
    StudentCourseComponent.prototype.selectCourse = function (c) {
        this.selectedCourse = c;
        this.getAllAssignmentsForCourse();
    };
    StudentCourseComponent.prototype.selectAssignment = function (a) {
        this.selectedAssignment = a;
    };
    StudentCourseComponent.prototype.submit = function () {
        if (this.selectedAssignment.submissionType === 'FILE') {
            $('#uploadFileModel').modal('show');
        }
        else {
            $('#uploadFolderModel').modal('show');
        }
    };
    StudentCourseComponent.prototype.fileEvent = function ($event) {
        if ($event.target.id === 'file') {
            this.file = $event.target.files[0];
        }
        else {
            this.fileList = this.filterFiles($event.target.files);
        }
    };
    StudentCourseComponent.prototype.uploadFile = function () {
        var _this = this;
        var formData = new FormData();
        formData.append('uploadingFiles', this.file);
        this.assignmentService.createSubmission(this.selectedAssignment._id, this.user.id, formData).subscribe(function (result) {
            // console.log('submission result', result.data);
            _this.getAllSubmission();
            $('#uploadFileModel').modal('hide');
        });
    };
    StudentCourseComponent.prototype.uploadFolder = function () {
        var _this = this;
        var formData = new FormData();
        for (var i = 0; i < this.fileList.length; i++) {
            formData.append('uploadingFiles', this.fileList[i]);
        }
        this.assignmentService.createSubmission(this.selectedAssignment._id, this.user.id, formData).subscribe(function (result) {
            // console.log('submission result', result.data);
            _this.getAllSubmission();
            $('#uploadFolderModel').modal('hide');
        });
    };
    StudentCourseComponent.prototype.filterFiles = function (fileList) {
        var resultList = [];
        for (var i = 0; i < fileList.length; i++) {
            if (this.isPythonFileName(fileList[i].name)) {
                resultList.push(fileList[i]);
            }
        }
        return resultList;
    };
    StudentCourseComponent.prototype.isPythonFileName = function (fileName) {
        var res = fileName.split('.');
        // console.log(res, res[res.length - 1] === 'py');
        return res[res.length - 1] === 'py';
    };
    StudentCourseComponent.prototype.isValidInput = function () {
        return this.fileList.length > 0;
    };
    return StudentCourseComponent;
}());
StudentCourseComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-student-course',
        template: __webpack_require__("./src/app/components/user/student-course/student-course.component.html"),
        styles: [__webpack_require__("./src/app/components/user/student-course/student-course.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__services_user_service_client__["a" /* UserService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* Router */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__services_shared_service_client__["a" /* SharedService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__["a" /* CourseService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__services_course_service_client__["a" /* CourseService */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_5__services_assignment_service_client__["a" /* AssignmentService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__services_assignment_service_client__["a" /* AssignmentService */]) === "function" && _f || Object])
], StudentCourseComponent);

var _a, _b, _c, _d, _e, _f;
//# sourceMappingURL=student-course.component.js.map

/***/ }),

/***/ "./src/app/services/assignment.service.client.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AssignmentService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("./node_modules/@angular/http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__ = __webpack_require__("./node_modules/rxjs/_esm5/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_catch__ = __webpack_require__("./node_modules/rxjs/_esm5/add/operator/catch.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var AssignmentService = (function () {
    function AssignmentService(http, sharedService, router) {
        this.http = http;
        this.sharedService = sharedService;
        this.router = router;
        this.baseUrl = __WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].baseUrl;
        this.options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["c" /* RequestOptions */]();
    }
    AssignmentService.prototype.createAssignment = function (assignment, userId) {
        return this.http.post(this.baseUrl + '/api/' + userId + '/assignment', assignment)
            .map(function (res) {
            return res.json();
        });
    };
    AssignmentService.prototype.findAssignmentById = function (aId, userId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/assignment/' + aId)
            .map(function (res) {
            return res.json();
        });
    };
    AssignmentService.prototype.findAssignmentsByCourseId = function (cId, userId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/assignment/course/' + cId)
            .map(function (res) {
            // console.log(res);
            return res.json();
        });
    };
    AssignmentService.prototype.updateAssignment = function (assignment, userId) {
        return this.http.put(this.baseUrl + '/api/' + userId + '/assignment', assignment)
            .map(function (res) {
            return res.json();
        });
    };
    AssignmentService.prototype.deleteAssignment = function (aId, userId) {
        return this.http.delete(this.baseUrl + '/api/' + userId + '/assignment/remove/' + aId)
            .map(function (res) {
            return res.json();
        });
    };
    AssignmentService.prototype.createSubmission = function (assnId, userId, submission) {
        return this.http.post(this.baseUrl + '/api/' + userId + '/' + assnId + '/submission', submission)
            .map(function (res) {
            return res.json();
        });
    };
    AssignmentService.prototype.getSubmissionByAssnId = function (assnId, userId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/' + assnId + '/submission')
            .map(function (res) {
            return res.json();
        });
    };
    AssignmentService.prototype.getSubmissionByStudentId = function (sId, userId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/submission/' + sId)
            .map(function (res) {
            return res.json();
        });
    };
    return AssignmentService;
}());
AssignmentService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__shared_service_client__["a" /* SharedService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */]) === "function" && _c || Object])
], AssignmentService);

var _a, _b, _c;
//# sourceMappingURL=assignment.service.client.js.map

/***/ }),

/***/ "./src/app/services/authentication.service.client.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AuthenticationService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__user_service_client__ = __webpack_require__("./src/app/services/user.service.client.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AuthenticationService = (function () {
    function AuthenticationService(userService) {
        this.userService = userService;
    }
    AuthenticationService.prototype.canActivate = function () {
        return this.userService.loggedIn();
    };
    return AuthenticationService;
}());
AuthenticationService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__user_service_client__["a" /* UserService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__user_service_client__["a" /* UserService */]) === "function" && _a || Object])
], AuthenticationService);

var _a;
//# sourceMappingURL=authentication.service.client.js.map

/***/ }),

/***/ "./src/app/services/compare.service.client.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CompareService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("./node_modules/@angular/http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__ = __webpack_require__("./node_modules/rxjs/_esm5/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_catch__ = __webpack_require__("./node_modules/rxjs/_esm5/add/operator/catch.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var CompareService = (function () {
    function CompareService(http) {
        this.http = http;
        this.baseUrl = __WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].baseUrl;
    }
    CompareService.prototype.uploadText = function (data, userId, s1Id, s2Id) {
        return this.http.post(this.baseUrl + '/api/compare/comparetexts/' + userId + '?s1Id=' + s1Id + '&s2Id=' + s2Id, data).map(function (res) {
            return res.json();
        });
    };
    CompareService.prototype.uploadFile = function (formData, userId, s1Id, s2Id) {
        return this.http.post(this.baseUrl + '/api/compare/comparefiles/' + userId + '?s1Id=' + s1Id + '&s2Id=' + s2Id, formData).map(function (res) {
            return res.json();
        });
    };
    CompareService.prototype.uploadFolder = function (formData, userId, s1Id, s2Id) {
        return this.http.post(this.baseUrl + '/api/compare/comparefolders/' + userId + '?s1Id=' + s1Id + '&s2Id=' + s2Id, formData).map(function (res) {
            return res.json();
        });
    };
    CompareService.prototype.compareAssignment = function (userId, assnId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/submission/cmpallsubmissions?asId=' + assnId).map(function (res) {
            return res.json();
        });
    };
    CompareService.prototype.compareSelectedSubmissions = function (userId, submissions) {
        return this.http.post(this.baseUrl + '/api/' + userId + '/submission/cmpallsubmissions', submissions).map(function (res) {
            return res.json();
        });
    };
    return CompareService;
}());
CompareService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */]) === "function" && _a || Object])
], CompareService);

var _a;
//# sourceMappingURL=compare.service.client.js.map

/***/ }),

/***/ "./src/app/services/course.service.client.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CourseService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("./node_modules/@angular/http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__ = __webpack_require__("./node_modules/rxjs/_esm5/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_catch__ = __webpack_require__("./node_modules/rxjs/_esm5/add/operator/catch.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var CourseService = (function () {
    function CourseService(http, sharedService, router) {
        this.http = http;
        this.sharedService = sharedService;
        this.router = router;
        this.baseUrl = __WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].baseUrl;
        this.options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["c" /* RequestOptions */]();
    }
    CourseService.prototype.createSemester = function (semester, userId) {
        return this.http.post(this.baseUrl + '/api/' + userId + '/semester', semester)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.findSemesterById = function (sId, userId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/semester/' + sId)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.findAllSemesters = function (userId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/semester')
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.findAllActiveSemesters = function (userId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/semester/active')
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.updateSemester = function (semester, userId) {
        return this.http.put(this.baseUrl + '/api/' + userId + '/semester', semester)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.deleteSemester = function (sId, userId) {
        return this.http.delete(this.baseUrl + '/api/' + userId + '/semester/remove/' + sId)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.createCourse = function (course, userId) {
        return this.http.post(this.baseUrl + '/api/' + userId + '/course', course)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.findAllCourses = function (userId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/courses')
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.findCourseBySemesterId = function (userId, sId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/courses/' + sId)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.findCourseByFacultyId = function (userId, fId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/course/faculty/' + fId)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.findCourseById = function (cId, userId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/course/' + cId)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.findStudentsForCourse = function (userId, cId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/course/students/' + cId)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.findCoursesForStudent = function (userId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/enrolledcourses')
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.updateCourse = function (course, userId) {
        return this.http.put(this.baseUrl + '/api/' + userId + '/course', course)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.deleteCourse = function (cId, userId) {
        return this.http.delete(this.baseUrl + '/api/' + userId + '/course/' + cId)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.enrollCourse = function (course, userId) {
        return this.http.put(this.baseUrl + '/api/student/enroll/' + userId, course)
            .map(function (res) {
            return res.json();
        });
    };
    CourseService.prototype.dropCourse = function (course, userId) {
        return this.http.put(this.baseUrl + '/api/student/drop/' + userId, course)
            .map(function (res) {
            return res.json();
        });
    };
    return CourseService;
}());
CourseService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__shared_service_client__["a" /* SharedService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */]) === "function" && _c || Object])
], CourseService);

var _a, _b, _c;
//# sourceMappingURL=course.service.client.js.map

/***/ }),

/***/ "./src/app/services/history.service.client.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HistoryService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("./node_modules/@angular/http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__ = __webpack_require__("./node_modules/rxjs/_esm5/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_catch__ = __webpack_require__("./node_modules/rxjs/_esm5/add/operator/catch.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var HistoryService = (function () {
    function HistoryService(http, sharedService, router) {
        this.http = http;
        this.sharedService = sharedService;
        this.router = router;
        this.baseUrl = __WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].baseUrl;
        this.options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["c" /* RequestOptions */]();
    }
    HistoryService.prototype.getOperationsByUserId = function (userId) {
        return this.http.get(this.baseUrl + '/api/user/' + userId + '/operation')
            .map(function (res) {
            return res.json();
        });
    };
    HistoryService.prototype.getStudentResult = function (userId, oId) {
        return this.http.get(this.baseUrl + '/api/user/' + userId + '/operation/' + oId + '/studentsInvolved')
            .map(function (res) {
            return res.json();
        });
    };
    HistoryService.prototype.getReportsOnStudentCompareId = function (userId, oId, sId) {
        return this.http.get(this.baseUrl + '/api/user/' + userId + '/operation/' + oId + '/studentsInvolved/' + sId)
            .map(function (res) {
            return res.json();
        });
    };
    HistoryService.prototype.notifyStudents = function (userId, s1Id, s2Id, score) {
        return this.http.post(this.baseUrl + '/api/user/studentNotif?userId='
            + userId + '&st1Id=' + s1Id + '&st2Id=' + s2Id + '&sim=' + score, userId).map(function (res) {
            return res.json();
        });
    };
    return HistoryService;
}());
HistoryService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__shared_service_client__["a" /* SharedService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */]) === "function" && _c || Object])
], HistoryService);

var _a, _b, _c;
//# sourceMappingURL=history.service.client.js.map

/***/ }),

/***/ "./src/app/services/shared.service.client.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SharedService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Subject__ = __webpack_require__("./node_modules/rxjs/_esm5/Subject.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var SharedService = (function () {
    function SharedService() {
        this.user = null;
        this.userObservable = new __WEBPACK_IMPORTED_MODULE_1_rxjs_Subject__["b" /* Subject */]();
        this.compareResult = null;
        this.strategy = null;
    }
    SharedService.prototype.setUser = function (u) {
        this.user = u;
        this.userObservable.next(u);
    };
    SharedService.prototype.clearUser = function () {
        this.user = null;
        this.userObservable.next(null);
    };
    return SharedService;
}());
SharedService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])()
], SharedService);

//# sourceMappingURL=shared.service.client.js.map

/***/ }),

/***/ "./src/app/services/user.service.client.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UserService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("./node_modules/@angular/http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__ = __webpack_require__("./node_modules/rxjs/_esm5/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_service_client__ = __webpack_require__("./src/app/services/shared.service.client.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_catch__ = __webpack_require__("./node_modules/rxjs/_esm5/add/operator/catch.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_rxjs_Observable__ = __webpack_require__("./node_modules/rxjs/_esm5/Observable.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var UserService = (function () {
    function UserService(http, sharedService, router) {
        this.http = http;
        this.sharedService = sharedService;
        this.router = router;
        this.baseUrl = __WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].baseUrl;
        this.options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["c" /* RequestOptions */]();
    }
    UserService.prototype.register = function (user) {
        var url = this.baseUrl + '/api/register';
        this.options.withCredentials = true;
        return this.http.post(url, user, this.options)
            .map(function (response) {
            return response.json();
        });
    };
    UserService.prototype.login = function (email, password) {
        var url = this.baseUrl + '/api/login';
        var credentials = {
            emailAddress: email,
            password: password,
        };
        this.options.withCredentials = true;
        return this.http.post(url, credentials, this.options)
            .map(function (response) {
            // console.log(response);
            return response.json();
        }).catch(function (e) {
            if (e.status === 401) {
                console.log(e);
                return __WEBPACK_IMPORTED_MODULE_7_rxjs_Observable__["a" /* Observable */].throw('Unauthorized');
            }
        });
    };
    UserService.prototype.loggedIn = function () {
        if (this.sharedService.user) {
            return true;
        }
        else {
            this.router.navigate(['/']);
            return false;
        }
    };
    UserService.prototype.createUser = function (user) {
        return this.http.post(this.baseUrl + '/api/user', user)
            .map(function (res) {
            return res.json();
        });
    };
    UserService.prototype.findUserById = function (userId) {
        return this.http.get(this.baseUrl + '/api/user/' + userId)
            .map(function (res) {
            return res.json();
        });
    };
    UserService.prototype.findAllUsers = function () {
        return this.http.get(this.baseUrl + '/api/allusers')
            .map(function (res) {
            // console.log(res);
            return res.json();
        });
    };
    UserService.prototype.findUserByEmail = function (email) {
        return this.http.get(this.baseUrl + '/api/user?email=' + email)
            .map(function (res) {
            // console.log('User service find by email, response', res);
            return res.json();
            // return null;
        });
    };
    UserService.prototype.updateUser = function (user) {
        return this.http.put(this.baseUrl + '/api/user/', user)
            .map(function (res) {
            return res.json();
        });
    };
    UserService.prototype.deleteUser = function (userId) {
        return this.http.delete(this.baseUrl + '/api/user/' + userId)
            .map(function (res) {
            return res.json();
        });
    };
    UserService.prototype.approveUser = function (user) {
        return this.http.put(this.baseUrl + '/api/user/approve', user)
            .map(function (res) {
            return res.json();
        });
    };
    UserService.prototype.rejectUser = function (user) {
        return this.http.put(this.baseUrl + '/api/user/reject', user)
            .map(function (res) {
            return res.json();
        });
    };
    UserService.prototype.findStudentsForProfessor = function (userId, profId) {
        return this.http.get(this.baseUrl + '/api/' + userId + '/students/' + profId)
            .map(function (res) {
            return res.json();
        });
    };
    return UserService;
}());
UserService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__shared_service_client__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__shared_service_client__["a" /* SharedService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["c" /* Router */]) === "function" && _c || Object])
], UserService);

var _a, _b, _c;
//# sourceMappingURL=user.service.client.js.map

/***/ }),

/***/ "./src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
var environment = {
    production: true,
    baseUrl: ''
};
//# sourceMappingURL=environment.js.map

/***/ }),

/***/ "./src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("./node_modules/@angular/platform-browser-dynamic/@angular/platform-browser-dynamic.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("./src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_23" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("./src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map