import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleRelationalComponent } from './article-relational.component';

describe('ArticleRelationalComponent', () => {
  let component: ArticleRelationalComponent;
  let fixture: ComponentFixture<ArticleRelationalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticleRelationalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleRelationalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
