import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FiendArticlePageComponent } from './fiend-article-page.component';

describe('FiendArticlePageComponent', () => {
  let component: FiendArticlePageComponent;
  let fixture: ComponentFixture<FiendArticlePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FiendArticlePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FiendArticlePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
