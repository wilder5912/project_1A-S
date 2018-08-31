import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeMoneyComponent } from './type-money.component';

describe('TypeMoneyComponent', () => {
  let component: TypeMoneyComponent;
  let fixture: ComponentFixture<TypeMoneyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypeMoneyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypeMoneyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
