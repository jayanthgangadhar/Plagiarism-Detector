import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfAssignmentComponent } from './prof-assignment.component';

describe('ProfAssignmentComponent', () => {
  let component: ProfAssignmentComponent;
  let fixture: ComponentFixture<ProfAssignmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfAssignmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfAssignmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
