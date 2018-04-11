import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDetailArticleComponent } from './view-detail-article.component';

describe('ViewDetailArticleComponent', () => {
  let component: ViewDetailArticleComponent;
  let fixture: ComponentFixture<ViewDetailArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewDetailArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDetailArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
