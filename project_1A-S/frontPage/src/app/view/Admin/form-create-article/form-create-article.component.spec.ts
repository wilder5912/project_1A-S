import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormCreateArticleComponent } from './form-create-article.component';

describe('FormCreateArticleComponent', () => {
  let component: FormCreateArticleComponent;
  let fixture: ComponentFixture<FormCreateArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormCreateArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormCreateArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
