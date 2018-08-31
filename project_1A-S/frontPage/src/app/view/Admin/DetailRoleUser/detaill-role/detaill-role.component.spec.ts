import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetaillRoleComponent } from './detaill-role.component';

describe('DetaillRoleComponent', () => {
  let component: DetaillRoleComponent;
  let fixture: ComponentFixture<DetaillRoleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetaillRoleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetaillRoleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
