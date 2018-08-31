import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailRoleUserComponent } from './detail-role-user.component';

describe('DetailRoleUserComponent', () => {
  let component: DetailRoleUserComponent;
  let fixture: ComponentFixture<DetailRoleUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailRoleUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailRoleUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
