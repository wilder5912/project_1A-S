import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateProductAdminComponent } from './create-product-admin.component';

describe('CreateProductAdminComponent', () => {
  let component: CreateProductAdminComponent;
  let fixture: ComponentFixture<CreateProductAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateProductAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateProductAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
