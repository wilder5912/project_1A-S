import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubSectionProductComponent } from './sub-section-product.component';

describe('SubSectionProductComponent', () => {
  let component: SubSectionProductComponent;
  let fixture: ComponentFixture<SubSectionProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubSectionProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubSectionProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
