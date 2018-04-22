import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompareResultComponent } from './compare-result.component';

describe('CompareResultComponent', () => {
  let component: CompareResultComponent;
  let fixture: ComponentFixture<CompareResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompareResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompareResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
