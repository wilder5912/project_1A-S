import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProToBusComponent } from './add-pro-to-bus.component';

describe('AddProToBusComponent', () => {
  let component: AddProToBusComponent;
  let fixture: ComponentFixture<AddProToBusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddProToBusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddProToBusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
