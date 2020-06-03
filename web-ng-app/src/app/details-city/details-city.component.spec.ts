import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsCityComponent } from './details-city.component';

describe('DetailsCityComponent', () => {
  let component: DetailsCityComponent;
  let fixture: ComponentFixture<DetailsCityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsCityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsCityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
