import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowImageModalComponent } from './show-image-modal.component';

describe('ShowImageModalComponent', () => {
  let component: ShowImageModalComponent;
  let fixture: ComponentFixture<ShowImageModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowImageModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowImageModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
