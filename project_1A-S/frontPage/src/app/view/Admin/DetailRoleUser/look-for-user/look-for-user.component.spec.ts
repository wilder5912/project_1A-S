import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LookForUserComponent } from './look-for-user.component';

describe('LookForUserComponent', () => {
  let component: LookForUserComponent;
  let fixture: ComponentFixture<LookForUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LookForUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LookForUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
