import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IsPalindromeComponent } from './is-palindrome.component';

describe('IsPalindromeComponent', () => {
  let component: IsPalindromeComponent;
  let fixture: ComponentFixture<IsPalindromeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IsPalindromeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IsPalindromeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
