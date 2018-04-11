import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormListArticleImageComponent } from './form-list-article-image.component';

describe('FormListArticleImageComponent', () => {
  let component: FormListArticleImageComponent;
  let fixture: ComponentFixture<FormListArticleImageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormListArticleImageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormListArticleImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
