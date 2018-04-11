import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubSectionAndArticleComponent } from './sub-section-and-article.component';

describe('SubSectionAndArticleComponent', () => {
  let component: SubSectionAndArticleComponent;
  let fixture: ComponentFixture<SubSectionAndArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubSectionAndArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubSectionAndArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
