import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormListArticleInformationComponent } from './form-list-article-information.component';

describe('FormListArticleInformationComponent', () => {
  let component: FormListArticleInformationComponent;
  let fixture: ComponentFixture<FormListArticleInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormListArticleInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormListArticleInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
