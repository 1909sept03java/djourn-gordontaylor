import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SortNumsComponent } from './sort-nums.component';

describe('SortNumsComponent', () => {
  let component: SortNumsComponent;
  let fixture: ComponentFixture<SortNumsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SortNumsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SortNumsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
