import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBannerComponent } from './create-banner.component';

describe('CreateBannerComponent', () => {
  let component: CreateBannerComponent;
  let fixture: ComponentFixture<CreateBannerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateBannerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBannerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
