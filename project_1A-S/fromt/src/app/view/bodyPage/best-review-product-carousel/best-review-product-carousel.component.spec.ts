import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BestReviewProductCarouselComponent } from './best-review-product-carousel.component';

describe('BestReviewProductCarouselComponent', () => {
  let component: BestReviewProductCarouselComponent;
  let fixture: ComponentFixture<BestReviewProductCarouselComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BestReviewProductCarouselComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BestReviewProductCarouselComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
