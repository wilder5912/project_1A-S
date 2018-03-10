import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListArticleFiendComponent } from './list-article-fiend.component';

describe('ListArticleFiendComponent', () => {
  let component: ListArticleFiendComponent;
  let fixture: ComponentFixture<ListArticleFiendComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListArticleFiendComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListArticleFiendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
