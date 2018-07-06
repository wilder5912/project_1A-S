import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleProviderComponent } from './article-provider.component';

describe('ArticleProviderComponent', () => {
  let component: ArticleProviderComponent;
  let fixture: ComponentFixture<ArticleProviderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticleProviderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
