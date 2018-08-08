import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeCashierPageComponent } from './home-cashier-page.component';

describe('HomeCashierPageComponent', () => {
  let component: HomeCashierPageComponent;
  let fixture: ComponentFixture<HomeCashierPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeCashierPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeCashierPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
