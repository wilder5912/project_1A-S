import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarouselArticlePageComponent } from './carousel-article-page.component';

describe('CarouselArticlePageComponent', () => {
  let component: CarouselArticlePageComponent;
  let fixture: ComponentFixture<CarouselArticlePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarouselArticlePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarouselArticlePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
