import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPageArticleComponent } from './list-page-article.component';

describe('ListPageArticleComponent', () => {
  let component: ListPageArticleComponent;
  let fixture: ComponentFixture<ListPageArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListPageArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPageArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
