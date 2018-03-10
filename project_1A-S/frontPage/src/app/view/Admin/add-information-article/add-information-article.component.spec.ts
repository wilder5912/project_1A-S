import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddInformationArticleComponent } from './add-information-article.component';

describe('AddInformationArticleComponent', () => {
  let component: AddInformationArticleComponent;
  let fixture: ComponentFixture<AddInformationArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddInformationArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddInformationArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
