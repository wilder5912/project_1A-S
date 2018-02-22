import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadPageComponent } from './load-page.component';

describe('LoadPageComponent', () => {
  let component: LoadPageComponent;
  let fixture: ComponentFixture<LoadPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoadPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoadPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
