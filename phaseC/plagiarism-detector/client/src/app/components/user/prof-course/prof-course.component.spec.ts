import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfCourseComponent } from './prof-course.component';

describe('ProfCourseComponent', () => {
  let component: ProfCourseComponent;
  let fixture: ComponentFixture<ProfCourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfCourseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
