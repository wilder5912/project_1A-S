import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarouselImageArticleComponent } from './carousel-image-article.component';

describe('CarouselImageArticleComponent', () => {
  let component: CarouselImageArticleComponent;
  let fixture: ComponentFixture<CarouselImageArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarouselImageArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarouselImageArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
