import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeCashierComponent } from './home-cashier.component';

describe('HomeCashierComponent', () => {
  let component: HomeCashierComponent;
  let fixture: ComponentFixture<HomeCashierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeCashierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeCashierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
